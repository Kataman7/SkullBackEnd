package main.domain.rules;

import main.domain.model.Player;
import main.domain.enums.ErrorCodes;

public class PlayerHasEnoughtMoneyRule extends PlayerRule{
    private final int amount;

    public PlayerHasEnoughtMoneyRule(String playerName, int amount) {
        super(playerName);
        this.amount = amount;
    }

    @Override
    public boolean isApplicable(main.domain.model.Board board) {
        Player player = board.getPlayers().getByName(getPlayerName());
        return player.getMoney() >= amount;
    }

    @Override
    public int getCode() {
        return ErrorCodes.PLAYER_HAS_ENOUGHT_MONEY.ordinal();
    }
}
