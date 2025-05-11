package domain.model;

import infrastructure.utils.CircularList;

public class Board {

    private PlayerList players;
    private Player winner;
    private Player bettor;
    private int betValue;

    public boolean addPlayer(String playerName)
    {
        return players.add(new Player(playerName));
    }

    public PlayerList getPlayers() {
        return players;
    }

    public void setBetValue(int betValue) {
        this.betValue = betValue;
    }
}
