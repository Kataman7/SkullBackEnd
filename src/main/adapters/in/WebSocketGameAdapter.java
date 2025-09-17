package main.adapters.in;


import main.adapters.out.broadcaster.WebSocketBroadcaster;
import main.application.port.in.GameCommandHandler;
import main.domain.events.game.GameEvent;
import main.domain.events.game.JoinEvent;
import main.domain.events.game.LeaveEvent;
import main.domain.events.server.CreateEvent;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketGameAdapter extends WebSocketServer {
    private final GameCommandHandler handler;
    private final WebSocketBroadcaster broadcaster;
    private final ConcurrentHashMap<WebSocket, String> connectedPlayers = new ConcurrentHashMap<>();

    public WebSocketGameAdapter(int port, GameCommandHandler handler, WebSocketBroadcaster broadcaster) {
        super(new InetSocketAddress(port));
        this.handler = handler;
        this.broadcaster = broadcaster;
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        broadcaster.addConnection(conn);
        conn.send("Bienvenue ! Envoyez 'join Nom' ou 'leave Nom'.");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        String playerName = connectedPlayers.remove(conn);
        broadcaster.removeConnection(conn);
        if (playerName != null) {
            handler.handle(new LeaveEvent(playerName));
        }
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        GameEvent event = parseCommand(message, conn);
        if (event != null) {
            handler.handle(event);
        } else {
            conn.send("Commande invalide : " + message);
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("Serveur WebSocket démarré sur le port " + getPort());
    }

    private GameEvent parseCommand(String command, WebSocket conn) {
        // Vérification de commande vide
        if (command == null || command.trim().isEmpty()) {
            conn.send("Commande invalide. Utilisez 'help' pour voir les commandes disponibles.");
            return null;
        }

        // Découpage et analyse de la commande
        String[] parts = command.trim().split("\\s+", 2); // Limite à 2 parties pour préserver les espaces
        String action = parts[0].toLowerCase();

        // Commande d'aide
        if (action.equals("help")) {
            String helpMessage = "Commandes disponibles :\n" +
                    "- join [nom] : Rejoindre la partie\n" +
                    "- leave [nom] : Quitter la partie\n" +
                    "- createServer : Créer un nouveau serveur de jeu";
            conn.send(helpMessage);
            return null;
        }

        // Commande pour créer un nouveau serveur
        if (action.equals("createserver")) {
            return new CreateEvent();
        }

        // Commandes qui nécessitent un nom de joueur
        if (parts.length < 2) {
            conn.send("Format invalide. Utilisez '[commande] [argument]' ou 'help'.");
            return null;
        }

        String playerName = parts[1].trim();
        if (playerName.isEmpty()) {
            conn.send("Nom de joueur requis.");
            return null;
        }

        // Traitement selon le type de commande
        switch (action) {
            case "join":
                connectedPlayers.put(conn, playerName);
                return new JoinEvent(playerName);
            case "leave":
                connectedPlayers.remove(conn);
                return new LeaveEvent(playerName);
            default:
                conn.send("Commande inconnue : " + action + ". Utilisez 'help' pour voir les commandes disponibles.");
                return null;
        }
    }
}
