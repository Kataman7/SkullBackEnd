package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Builder;
import main.domain.rules.GameBuyBuilderPhase;
import main.domain.rules.PlayerHasEnoughtMoney;
import main.domain.rules.PlayerTurnRule;
import main.domain.rules.ValidPlayerRule;

import javax.json.Json;
import java.util.List;

public class BuyBuilderEvent extends PlayerEvent {
    private final int value;
    private final int cost;

    public BuyBuilderEvent(String playerName, int value,int cost) {
        super(playerName);
        this.value = value;
        this.cost = cost;

        super.getRules().addAll(List.of(
                new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new GameBuyBuilderPhase(),
                new PlayerHasEnoughtMoney(getPlayerName(), cost)
        ));
    }

    @Override
    public void apply(Board board) {
        var player = board.getPlayers().getByName(getPlayerName());
        Builder build = board.getBuidlerReveal().get(value);
        player.setMoney(player.getMoney() - build.getCoast());
        player.getBuilders().add(build);
        board.setPlayedPlayersCount(board.getPlayedPlayersCount() + 1);
    }

    @Override
    public String toJson() {
        return Json.createObjectBuilder()
                .add("event", "buyBuilder")
                .add("player", getPlayerName())
                .add("value", value)
                .add("cost", cost)
                .build()
                .toString();
    }

    public int getValue() {
        return value;
    }
}
