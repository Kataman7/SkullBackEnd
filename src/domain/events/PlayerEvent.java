package domain.events;

import domain.events.GameEvent;

public abstract class PlayerEvent implements GameEvent
{
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