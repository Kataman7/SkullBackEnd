package main.domain.events;

import main.domain.model.Board;
import main.domain.rules.GameRule;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEvent
{
    private final List<GameRule> rules;

    public GameEvent()
    {
        rules = new ArrayList<>();
    }

    public abstract void apply(Board board);

    public List<GameRule> getRules() {
        return rules;
    }

    public boolean requireNextTurnEvent() {
        return false;
    }
}