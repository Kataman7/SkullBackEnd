package main.domain.events.game;

public abstract class ChainedEvent extends GameEvent
{
    private GameEvent nextEvent;

    public  ChainedEvent(GameEvent nextEvent)
    {
        this.nextEvent = nextEvent;
    }

    public GameEvent getNextEvent()
    {
        return nextEvent;
    }
}
