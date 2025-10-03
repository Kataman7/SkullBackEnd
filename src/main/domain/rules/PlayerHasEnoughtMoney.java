package main.domain.rules;

import main.domain.model.Player;

public class PlayerHasEnoughtMoney extends PlayerRule{
    private final int amount;

    public PlayerHasEnoughtMoney(String playerName, int amount) {
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
        return RuleCodes.PLAYER_HAS_ENOUGHT_MONEY.ordinal();
    }
}
