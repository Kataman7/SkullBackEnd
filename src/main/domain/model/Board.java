package main.domain.model;

import main.domain.enums.Phases;

import java.util.ArrayList;

public class Board {

    private final PlayerList players;
    private Player winner;
    private ArrayList<Build> builds;
    private ArrayList<Builder> builders;
    private int deckNumber;
    private Phases phase;
    private int playedPlayersCount;

    public Board()
    {
        players = new PlayerList();
        winner = null;
        builds = new ArrayList<>();
        builders = new ArrayList<>();
        phase = Phases.Lobby;
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
    public ArrayList<Build> getBuilds() {
        return builds;
    }
    public ArrayList<Builder> getBuilders() {
        return builders;
    }
    public ArrayList<Builder> getBuidlerReveal(){
        ArrayList<Builder> res = new ArrayList<>();
        for (int i = 0; i <deckNumber; i++) {
            res.add(builders.getFirst());
        }
        return res;
    }

    public ArrayList<Build> getBuildReveal(){
        ArrayList<Build> res = new ArrayList<>();
        for (int i = 0; i <deckNumber; i++) {
            res.add(builds.getFirst());
        }
        return res;
    }
    public Phases getPhase() {
        return phase;
    }
    public void setPhase(Phases phase) {
        this.phase = phase;
    }
    public void setPlayedPlayersCount(int playedPlayersCount) {
        this.playedPlayersCount = playedPlayersCount;
    }

    public int getPlayedPlayersCount() {
        return playedPlayersCount;
    }
}
