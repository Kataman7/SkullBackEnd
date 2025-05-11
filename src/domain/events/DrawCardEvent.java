package domain.events;

import domain.model.Board;

public class DrawCardEvent extends PlayerEvent
{
    private final int index;

    public DrawCardEvent(String playerName, int index)
    {
        super(playerName);
        this.index = index;
    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().getCurrent().drawCard(index);
    }
}
