package test.java.Rule;
import main.domain.model.*;
import main.domain.rules.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerRuleTest {
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
    void testPlayerTurnRule() {
        PlayerTurnRule rule1 = new PlayerTurnRule("player1");
        assert (rule1.isApplicable(board));
        PlayerTurnRule rule2 = new PlayerTurnRule("player2");
        assert (!rule2.isApplicable(board));
        board.getPlayers().next();
        assert (rule2.isApplicable(board));
        board.getPlayers().next();
        assert (rule1.isApplicable(board));
    }

    @Test
    void validPlayerRule() {
        ValidPlayerRule rule1 = new ValidPlayerRule("player1");
        assert (rule1.isApplicable(board));
        ValidPlayerRule rule2 = new ValidPlayerRule("player3");
        assert (!rule2.isApplicable(board));
    }

    @Test
    void playerHasenoughtMoneyRule() {
        player1.setMoney(10);
        PlayerHasEnoughtMoneyRule rule1 = new PlayerHasEnoughtMoneyRule("player1", 5);
        assert (rule1.isApplicable(board));
        PlayerHasEnoughtMoneyRule rule2 = new PlayerHasEnoughtMoneyRule("player1", 15);
        assert (!rule2.isApplicable(board));
    }

    @Test
    void playerHaveBuildsRule()  {

        player1.getBuilds().add(build1);
        player1.getBuilds().add(build2);
        PlayerHaveBuildRule rule1 = new PlayerHaveBuildRule("player1", 1);
        assert (rule1.isApplicable(board));
        PlayerHaveBuildRule rule2 = new PlayerHaveBuildRule("player1", 2);
        assert (rule2.isApplicable(board));
        PlayerHaveBuildRule rule3 = new PlayerHaveBuildRule("player1", 3);
        assert (!rule3.isApplicable(board));
    }
    @Test
    void playerHaveBuilderRule()  {
        player1.getBuilders().add(builder);
        player1.getBuilders().add(builder2);
        PlayerHaveBuilderRule rule1 = new PlayerHaveBuilderRule("player1", 1);
        assert (rule1.isApplicable(board));
        PlayerHaveBuilderRule rule2 = new PlayerHaveBuilderRule("player1", 2);
        assert (rule2.isApplicable(board));
        PlayerHaveBuilderRule rule3 = new PlayerHaveBuilderRule("player1", 3);
        assert (!rule3.isApplicable(board));
    }
}

