package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.ValidPlayerRule;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.List;

public class LeaveGameEvent extends PlayerEvent
{
    public LeaveGameEvent(String playerName)
    {
        super(playerName);

        super.getRules().addAll(List.of(
                new ValidPlayerRule(getPlayerName())
        ));

    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().remove(new Player(super.getPlayerName()));
    }

    @Override
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("content", "event")
                .add("event", "leave")
                .add("player", getPlayerName())
                .build();
    }
}
