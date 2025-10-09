package main.domain.rules;

import main.domain.model.Player;

public class ValidPlayerBuilderIndexRule extends PlayerRule {
    private final int builderIndex;

    public ValidPlayerBuilderIndexRule(String playerName, int builderIndex) {
        super(playerName);
        this.builderIndex = builderIndex;
    }

    @Override
    public boolean isApplicable(main.domain.model.Board board) {
        Player player = board.getPlayers().getByName(super.getPlayerName());
        return builderIndex > 0 && builderIndex < player.getBuilders().size();
    }

    @Override
    public int getCode() {
        return 0;
    }
}
