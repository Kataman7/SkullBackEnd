package main.domain.rules;

import main.domain.model.Board;

public class NotRule implements GameRule
{
    private GameRule rule;

    public NotRule(GameRule rule) {
        this.rule = rule;
    }

    @Override
    public boolean isApplicable(Board board) {
        return !rule.isApplicable(board);
    }

    @Override
    public String toString() {
        return "!" + rule.toString();
    }
}
