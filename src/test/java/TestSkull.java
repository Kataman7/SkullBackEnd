package test.java;

import main.application.port.out.GameStateSaver;
import main.application.service.GameService;
import main.domain.events.DrawCardEvent;
import main.domain.events.JoinEvent;
import main.domain.events.LeaveEvent;
import main.domain.model.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestSkull
{
    private GameService gameService;
    private Board board;
    private GameStateSaver saver;

    @Before
    public void setUp()
    {
        board = new Board();
        gameService = new GameService(board, null, null);
    }

    @Test
    public void drawCardTest()
    {
        gameService.handle(new JoinEvent("Player1"));
        gameService.handle(new JoinEvent("Player2"));

        new DrawCardEvent("Player1", 1).apply(board);
        assertEquals(1, board.getPlayers().getDeckSize());
        assertEquals(3, board.getPlayers().getByName("Player1").getDeckSize());

        new DrawCardEvent("Player2", 1).apply(board);
        assertEquals(2, board.getPlayers().getDeckSize());
        assertEquals(3, board.getPlayers().getByName("Player2").getDeckSize());
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
}
