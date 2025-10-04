package main.domain.events.server;

import main.domain.events.game.GameEvent;
import main.domain.model.Board;

import javax.json.Json;

public class CreateEvent extends GameEvent
{
    @Override
    public void apply(Board board)
    {
    }

    @Override
    public String toJson() {
        return Json.createObjectBuilder()
                .add("event", "create")
                .build()
                .toString();
    }
}


