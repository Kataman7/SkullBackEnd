package main.domain.model;

import java.util.*;

public class Player
{
    private final String name;
    private int score;
    private ArrayList<Build> builds;
    private ArrayList<Builder> builders;
    private int money;

    public Player(String name)
    {
        this.name = name;
        score = 0;
        builds = new ArrayList<>();
        builders = new ArrayList<>();
        money = 0;
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

    public ArrayList<Build> getBuilds() {
        return builds;
    }
    public Build getBuildByName(String name) {
        for (Build build : builds) {
            if (build.getName().equals(name)) {
                return build;
            }
        }
        return null;
    }
    public ArrayList<Builder> getBuilders() {
        return builders;
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Builder getBuilderByName(String name) {
        for (Builder builder : builders) {
            if (builder.getName().equals(name)) {
                return builder;
            }
        }
        return null;
    }


}