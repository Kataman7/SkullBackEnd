package application.service;

import application.port.in.GameCommandHandler;
import application.port.out.GameStateBroadcaster;
import application.port.out.GameStateSaver;
import domain.model.Board;
import domain.events.GameEvent;

public class GameService implements GameCommandHandler {

    private final Board game;
    private final GameStateSaver saver;
    private final GameStateBroadcaster broadcaster;

    public GameService(Board game, GameStateSaver saver, GameStateBroadcaster broadcaster) {
        this.game = game;
        this.saver = saver;
        this.broadcaster = broadcaster;
    }

    @Override
    public void handle(GameEvent event) {
        // logique jeu
        event.apply(game);

        // sauvegarde
        saver.save(game);

        // notification
        broadcaster.broadcast(event.toString());
    }
}
