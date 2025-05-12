package main.domain.events;

import main.domain.model.Board;
import main.domain.rules.GameRule;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEvent
{
    private List<GameRule> rules;

    public void apply(Board board)
    {
        rules = new ArrayList<GameRule>();
    }

    public List<GameRule> getRules() {
        return rules;
    }
}