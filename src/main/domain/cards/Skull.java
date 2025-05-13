package main.domain.cards;

import main.domain.events.LooseCardEvent;
import main.domain.model.Board;

import java.util.List;

public class Skull extends Card {

    public Skull() {
        super();
        getEvents().addAll(List.of(
                new LooseCardEvent()
        ));
    }

    @Override
    public void apply(Board board) {
        super.apply(board);
    }
}
