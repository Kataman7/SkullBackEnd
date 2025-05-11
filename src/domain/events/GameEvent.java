package domain.events;

import domain.model.Board;
import domain.rules.GameRule;

import java.util.List;

public abstract class GameEvent
{
    private List<GameRule> rules;

    public void apply(Board board)
    {

    }

    public List<GameRule> getRules() {
        return rules;
    }
}