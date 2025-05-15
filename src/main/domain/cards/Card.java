package main.domain.cards;

import main.domain.events.GameEvent;
import main.domain.model.Board;

import java.util.ArrayList;
import java.util.List;

public abstract class Card
{
    private final List<GameEvent> events;

    public Card() {
        this.events = new ArrayList<>();
    }

    public void apply(Board board) {
        events.forEach(event -> {
            if (event.getRules().stream().allMatch(rule -> rule.isApplicable(board))) {
                event.apply(board);
            }
        });
    }

    public List<GameEvent> getEvents() {
        return events;
    }
}
