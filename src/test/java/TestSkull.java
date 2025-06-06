package test.java;

import main.adapters.out.broadcaster.InMemoryBroardCaster;
import main.adapters.out.saver.InMemoryGameSaver;
import main.application.port.out.GameStateSaver;
import main.application.service.GameService;
import main.domain.events.ClearDecks;
import main.domain.events.DrawCardEvent;
import main.domain.events.JoinEvent;
import main.domain.events.LeaveEvent;
import main.domain.model.Board;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSkull
{
    private static GameService gameService;
    private static Board board;

    @BeforeAll
    public static void setUp()
    {
        board = new Board();
        InMemoryGameSaver saver = new InMemoryGameSaver();
        InMemoryBroardCaster broardCaster = new InMemoryBroardCaster();
        gameService = new GameService(board, saver, broardCaster);
    }

    @Test
    public void drawCardTest()
    {
        gameService.handle(new JoinEvent("Player1"));
        gameService.handle(new JoinEvent("Player2"));

        new DrawCardEvent("Player1", 1).apply(board);
        assertEquals(1, board.getPlayers().getDeckSize());
        assertEquals(3, board.getPlayers().getByName("Player1").getHandSize());

        new DrawCardEvent("Player2", 1).apply(board);
        assertEquals(2, board.getPlayers().getDeckSize());
        assertEquals(3, board.getPlayers().getByName("Player2").getHandSize());
    }

    @Test
    public void clearDecksTest()
    {
        gameService.handle(new JoinEvent("Player1"));
        gameService.handle(new JoinEvent("Player2"));

        new DrawCardEvent("Player1", 1).apply(board);
        new DrawCardEvent("Player2", 1).apply(board);
        new ClearDecks().apply(board);

        assertEquals(0, board.getPlayers().getDeckSize());
        assertEquals("Player1", board.getPlayers().getCurrent().getName());
    }

    @Test
    public void joinLeaveTest()
    {
        assertEquals(0, board.getPlayers().size());
        gameService.handle(new JoinEvent("Player1"));
        assertEquals(1, board.getPlayers().size());
        gameService.handle(new JoinEvent("Player2"));
        assertEquals(2, board.getPlayers().size());
        gameService.handle(new LeaveEvent("Player1"));
        assertEquals(1, board.getPlayers().size());
        gameService.handle(new LeaveEvent("Player3"));
        assertEquals(1, board.getPlayers().size());
        gameService.handle(new LeaveEvent("Player2"));
        assertEquals(0, board.getPlayers().size());
    }

    @Test
    public void simpleGame()
    {
        gameService.handle(new JoinEvent("Player1"));
        gameService.handle(new JoinEvent("Player2"));
        gameService.handle(new DrawCardEvent("Player1", 1));
        assertEquals(1, board.getPlayers().getDeckSize());

        gameService.handle(new DrawCardEvent("Player2", 1));
        assertEquals(2, board.getPlayers().getDeckSize());
    }
}
