package main.domain.cards;

import main.domain.model.Board;
import main.domain.rules.InBetRule;
import main.domain.rules.NotRule;

public class Flower implements Card {
    @Override
    public void apply(Board board) {
        board.setBetValue(board.getBetValue() - 1);

        if (board.getBetValue() <= 0) {

        }
    }


}
