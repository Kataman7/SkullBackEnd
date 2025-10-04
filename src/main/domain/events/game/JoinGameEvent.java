package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.GameFullRule;
import main.domain.rules.NotRule;
import main.domain.rules.ValidPlayerRule;

import javax.json.Json;
import java.util.List;

public class JoinGameEvent extends PlayerEvent
{
    public JoinGameEvent(String playerName)
    {
        super(playerName);
        super.getRules().addAll(List.of(
                new NotRule(new ValidPlayerRule(getPlayerName())),
                new GameFullRule()
        ));
    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().add(new Player(getPlayerName()));
    }

    @Override
    public String toJson() {
        return Json.createObjectBuilder()
                .add("event", "join")
                .add("player", getPlayerName())
                .build()
                .toString();
    }
}
