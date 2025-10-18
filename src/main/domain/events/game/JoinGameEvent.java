package main.domain.events.game;

import main.domain.enums.Phases;
import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.GameNotFullRule;
import main.domain.rules.NotRule;
import main.domain.rules.ValidGamePhaseRule;
import main.domain.rules.ValidPlayerRule;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.List;

public class JoinGameEvent extends PlayerEvent
{
    public JoinGameEvent(String playerName)
    {
        super(playerName);
        super.getRules().addAll(List.of(
                new ValidGamePhaseRule(Phases.LOBBY),
                new GameNotFullRule(),
                new NotRule(new ValidPlayerRule(getPlayerName()))
        ));
    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().add(new Player(getPlayerName()));
    }

    @Override
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("content", "event")
                .add("event", "join")
                .add("player", getPlayerName())
                .build();
    }
}
