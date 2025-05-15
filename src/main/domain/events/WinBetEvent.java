package main.domain.events;

import main.domain.model.Board;
import main.domain.rules.InBetRule;
import main.domain.rules.NotRule;

import java.util.List;

public class WinBetEvent extends GameEvent
{
    public WinBetEvent() {
              getRules().addAll(List.of(
                new NotRule(new InBetRule())
        ));
    }

    @Override
    public void apply(Board board) {
        int score = board.getBettor().getScore();
        board.getPlayers().getCurrent().setScore(score + 1);
    }
}
