package main.domain.rules;

import main.domain.model.Builder;

public class PlayerHaveBuilder extends PlayerRule {
    private Builder builder;

    public PlayerHaveBuilder(String playerName, Builder builder) {
        super(playerName);
        this.builder = builder;
    }

    @Override
    public boolean isApplicable(main.domain.model.Board board) {
        return board.getPlayers().getByName(super.getPlayerName()).getBuilderByName(builder.getName()) != null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
