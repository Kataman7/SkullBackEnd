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
        // logique du jeu
        boolean allRulesApplicable = event.getRules().stream()
                .allMatch(gameRule -> {
                    if (!gameRule.isApplicable(game)) {
                        broadcaster.broadcast(gameRule.toString());
                        return false;
                    }
                    return true;
                });
        if (allRulesApplicable) {
            event.apply(game);
            saver.save(game);
            // notification
            broadcaster.broadcast(event.toString());
        }
    }
}
