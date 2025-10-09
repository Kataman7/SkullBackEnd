package main.domain.events.game;

import main.domain.enums.Phases;
import main.domain.model.Board;
import main.domain.model.Builder;
import main.domain.model.Player;
import main.domain.rules.*;

import java.util.List;

public class InfectBuilderEvent extends PlayerEvent
{
    private final int builderIndex;

    public InfectBuilderEvent(String playerName, int builderIndex, int cost) {
        super(playerName);
        this.builderIndex = builderIndex;

        super.getRules().addAll(List.of(
                new ValidGamePhaseRule(Phases.BUY_BUILDERS),
                new ValidDeckBuilderIndexRule(builderIndex),
                new ValidPlayerRule(playerName),
                new PlayerTurnRule(playerName),
                new PlayerHaveEnoughtMoneyRule(playerName, cost)
        ));
    }

    @Override
    public void apply(Board board) {
        Builder builder = board.getBuilders().get(builderIndex);
        Player player = board.getPlayers().getByName(getPlayerName());
        player.setMoney(player.getMoney() - builder.getCost());
        builder.setInfected(true);
    }

    @Override
    public String toJson() {
        return "";
    }
}
