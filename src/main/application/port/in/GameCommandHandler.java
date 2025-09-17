package main.application.port.in;

import main.domain.events.game.GameEvent;

public interface GameCommandHandler {
    void handle(GameEvent event);
}