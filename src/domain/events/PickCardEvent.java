package domain.events;

import domain.model.Board;
import domain.model.Player;
import domain.rules.*;

import java.util.List;

public class PickCardEvent extends PlayerEvent {
    private final String targetName;

    public PickCardEvent(String playerName, String targetName) {
        super(playerName);
        this.targetName = targetName;

        super.getRules().addAll(List.of(
                new PlayerTurnRule(super.getPlayerName()),
                new GameEmptyRule(),
                new ValidPlayerRule(super.getPlayerName()),
                new ValidPlayerRule(targetName),
                new DeckNotEmptyRule(targetName)
        ));
    }

    @Override
    public void apply(Board board) {
        Player targetPlayer = board.getPlayers().getByName(targetName);
        board.getPlayers().getCurrent().pickCard(targetPlayer);
    }
}
