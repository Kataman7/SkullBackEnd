package main.domain.model;

import java.util.*;

public class Player
{
    private final String name;
    private int score;

    public Player(String name)
    {
        this.name = name;
        score = 0;
    }
    public String getName()
    {
        return name;
    }
    public int getScore()
    {
        return score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    //compare uniquement le nom lors des égalités
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}