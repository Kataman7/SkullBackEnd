package domain.events;

import domain.model.Board;

public interface GameEvent
{
    void apply(Board board);
    String toString();
}