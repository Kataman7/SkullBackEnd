package domain.events;

import domain.model.Board;
import domain.model.Player;

public class PickCardEvent extends PlayerEvent
{
    private final String targetName;

    public PickCardEvent(String playerName, String targetName) {
        super(playerName);
        this.targetName = targetName;
    }

    @Override
    public void apply(Board board) {
        Player targetPlayer = board.getPlayers().getByName(targetName);
        board.getPlayers().getCurrent().pickCard(targetPlayer);
    }
}
