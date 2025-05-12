package test.java;

import main.application.port.out.GameStateSaver;
import main.application.service.GameService;
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
