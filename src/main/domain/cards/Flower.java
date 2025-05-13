package main.domain.cards;

import main.domain.events.GameEvent;
import main.domain.events.WinBetEvent;
import main.domain.model.Board;
import main.domain.rules.InBetRule;
import main.domain.rules.NotRule;

import java.util.List;

public class Flower extends Card {

    public Flower() {
        super();
        getEvents().addAll(List.of(
                new WinBetEvent()
        ));
    }

    @Override
    public void apply(Board board) {

        board.setBetValue(board.getBetValue() - 1);
        super.apply(board);
    }


}
