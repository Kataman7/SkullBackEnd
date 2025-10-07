package test.java.Rule;
import main.domain.model.*;
import main.domain.rules.*;

import org.junit.jupiter.api.BeforeEach;
class PlayerRule {
    private static Player player1, player2;
    private static Board board;


    @BeforeEach
    void setUpBeforeEach() {
        player1 = new Player("player1");
        player2 = new Player("player2");
        board = new Board();
        board.getPlayers().add(player1);
        board.getPlayers().add(player2);
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
        int[] ressources1 = {1, 2, 3, 0}; // exemple de ressources
        int[] ressources2 = {2, 1, 0, 0};
        Build build1 = new Build("build1", 5, ressources1, 2, 2, true);
        Build build2 = new Build("build2", 10, ressources2, 2, 2, true);

        player1.getBuilds().add(build1);
        player1.getBuilds().add(build2);
        PlayerHaveBuild rule1 = new PlayerHaveBuild("player1", build1);
        assert (rule1.isApplicable(board));
        PlayerHaveBuild rule2 = new PlayerHaveBuild("player1", build2);
        assert (rule2.isApplicable(board));
        PlayerHaveBuild rule3 = new PlayerHaveBuild("player1", new Build("build3", 10, ressources2, 2, 2, true));
        assert (!rule3.isApplicable(board));
    }
    @Test
    void playerHaveBuilderRule()  {
        int[] ressources1 = {1, 2, 3, 0}; // exemple de ressources
        int[] ressources2 = {2, 1, 0, 0};
        Builder builder = new Builder("builder1", 5, ressources1);
        Builder builder2 = new Builder("builder2", 10, ressources2);
        player1.getBuilders().add(builder);
        player1.getBuilders().add(builder2);
        PlayerHaveBuilder rule1 = new PlayerHaveBuilder("player1", builder);
        assert (rule1.isApplicable(board));
        PlayerHaveBuilder rule2 = new PlayerHaveBuilder("player1", builder2);
        assert (rule2.isApplicable(board));
        PlayerHaveBuilder rule3 = new PlayerHaveBuilder("player1", new Builder("build3", 10, ressources2));
        assert (!rule3.isApplicable(board));
    }
}

