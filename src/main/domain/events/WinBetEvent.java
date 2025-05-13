package main.domain.events;

import main.domain.model.Board;

public class WinBetEvent extends PlayerEvent
{
    public WinBetEvent(String playerName) {
        super(playerName);
    }

    @Override
    public void apply(Board board) {
        int score = board.getPlayers().getCurrent().getScore();
        board.getPlayers().getCurrent().setScore(score + 1);
    }
}
