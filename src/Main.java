import adapters.in.ConsoleCommandAdapter;
import adapters.out.ConsoleBroadcaster;
import adapters.out.ConsoleGameSaver;
import application.port.out.GameStateBroadcaster;
import application.port.out.GameStateSaver;
import application.service.GameService;
import domain.model.Board;

public class Main {
    public static void main(String[] args) {
        // Création du modèle de jeu
        Board game = new Board();
        game.addPlayer("Alice");
        game.addPlayer("Bob");

        // Adaptateurs sortants
        GameStateSaver saver = new ConsoleGameSaver();         // Affiche l'état après chaque action
        GameStateBroadcaster broadcaster = new ConsoleBroadcaster(); // Affiche le message de chaque événement

        // Service qui gère les événements du jeu
        GameService service = new GameService(game, saver, broadcaster);

        // Adaptateur entrant : lit les commandes depuis la console
        ConsoleCommandAdapter adapter = new ConsoleCommandAdapter(service);

        // Démarre la boucle de jeu
        adapter.startListening();
    }
}