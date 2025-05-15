package main.domain.model;

public class Board {

    private PlayerList players;
    private Player winner;
    private Player bettor;
    private int betValue;

    public Board() {
        players = new PlayerList();
        winner = null;
        bettor = null;
        betValue = 0;
    }

    public void addPlayer(String playerName)
    {
        players.add(new Player(playerName));
    }

    public PlayerList getPlayers() {
        return players;
    }

    public int getBetValue() {
        return betValue;
    }

    public void setBetValue(int betValue) {
        this.betValue = betValue;
    }

    public Player getBettor() {
        return bettor;
    }

    public void setBettor(String playerName) {
        this.bettor = players.getByName(playerName);
    }

    public Player getWinner() {
        return winner;
    }
}
