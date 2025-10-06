package main.domain.rules;

import main.domain.model.Board;
import main.domain.model.Build;

import javax.swing.plaf.basic.BasicButtonUI;

public class PlayerHaveBuild extends PlayerRule{
    private Build build;

    public PlayerHaveBuild(String playerName, Build build) {
        super(playerName);
        this.build = build;
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getByName(super.getPlayerName()).getBuildByName(build.getName())  != null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
