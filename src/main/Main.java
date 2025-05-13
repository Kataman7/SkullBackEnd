package main;

import main.adapters.in.ConsoleCommandAdapter;
import main.adapters.out.broadcaster.ConsoleBroadcaster;
import main.adapters.out.saver.ConsoleGameSaver;
import main.application.port.out.GameStateBroadcaster;
import main.application.port.out.GameStateSaver;
import main.application.service.GameService;
import main.domain.model.Board;

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