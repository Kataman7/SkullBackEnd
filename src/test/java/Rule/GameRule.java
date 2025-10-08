package test.java.Rule;

import main.domain.enums.Phases;
import main.domain.model.*;
import main.domain.rules.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameRule {

    private static Player player1, player2;
    private static Board board;
    private static Build build1, build2;
    private static Builder builder, builder2;
    private static int[] ressources1, ressources2;

    @BeforeEach
    void setUpBeforeEach() {
        player1 = new Player("player1");
        player2 = new Player("player2");
        board = new Board();
        board.getPlayers().add(player1);
        board.getPlayers().add(player2);

        ressources1 = new int[]{1, 2, 3, 0}; // exemple de ressources
        ressources2 = new int[] {2, 1, 0, 0};
        build1 = new Build("build1", 5, ressources1, 2, 2, true);
        build2 = new Build("build2", 10, ressources2, 2, 2, true);
        builder = new Builder("builder1", 5, ressources1);
        builder2 = new Builder("builder2", 10, ressources2);

    }
    @Test
    void GameBuildPhase(){
        board.setPhase(Phases.Build);
        GameBuildPhase rule1 = new GameBuildPhase();
        assert (rule1.isApplicable(board));
        board.setPhase(Phases.Lobby);
        assert (!rule1.isApplicable(board));
    }
    @Test
    void GameBuyBuilderPhase(){
        board.setPhase(Phases.Buy_Builders);
        GameBuyBuilderPhase rule1 = new GameBuyBuilderPhase();
        assert (rule1.isApplicable(board));
        board.setPhase(Phases.Lobby);
        assert (!rule1.isApplicable(board));
    }
    @Test
    void GameBuyBuildPhase(){
        board.setPhase(Phases.Buy_Builds);
        GameBuyBuildPhase rule1 = new GameBuyBuildPhase();
        assert (rule1.isApplicable(board));
        board.setPhase(Phases.Lobby);
        assert (!rule1.isApplicable(board));
    }
    @Test
    void GameEmpty(){
        Board board2 = new Board();
        GameEmptyRule rule1 = new GameEmptyRule();
        assert (rule1.isApplicable(board2));
        assert (!rule1.isApplicable(board));
    }
    @Test
    void GameFullRule(){
        Board board2 = new Board();
        for (int i = 0; i < 17; i++) {
            board2.addPlayer("player"+i);
        }
        GameFullRule rule1 = new GameFullRule();
        assert (!rule1.isApplicable(board2));
        assert (rule1.isApplicable(board));
    }

}
