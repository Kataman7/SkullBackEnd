package main.application.port.in;

import main.domain.events.GameEvent;

public interface GameCommandHandler {
    void handle(GameEvent event);
}