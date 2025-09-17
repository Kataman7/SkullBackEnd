package main.domain.model;

public class Board {

    private final PlayerList players;
    private Player winner;

    public Board()
    {
        players = new PlayerList();
        winner = null;
    }
    public void addPlayer(String playerName)
    {
        players.add(new Player(playerName));
    }
    public PlayerList getPlayers()
    {
        return players;
    }
    public Player getWinner()
    {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
