package domain.rules;

import domain.model.Board;

public abstract class PlayerRule implements GameRule
{
    private final String playerName;

    public PlayerRule(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
