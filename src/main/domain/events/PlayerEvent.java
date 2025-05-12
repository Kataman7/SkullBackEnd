package main.domain.events;

public abstract class PlayerEvent extends GameEvent {
    private final String playerName;

    public PlayerEvent(String playerName)
    {
        this.playerName = playerName;
    }

    public String getPlayerName()
    {
        return playerName;
    }
}