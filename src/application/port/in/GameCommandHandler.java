package application.port.in;

import domain.events.GameEvent;

public interface GameCommandHandler {
    void handle(GameEvent event);
}