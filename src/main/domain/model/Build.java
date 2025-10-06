package main.domain.model;

import java.util.ArrayList;

public class Build {
    private final String name;
    private final int reward;
    private final Ressources ressources;
    private final int sizeX;
    private final int sizeY;
    private final boolean isreplaceable;
    private ArrayList<Builder> builder;

    public Build(String name, int coast, int[] ressources, int sizeX, int sizeY, boolean isreplaceable) {
        this.name = name;
        this.reward = coast;
        this.ressources = new Ressources(ressources);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.isreplaceable = isreplaceable;
        this.builder =  new ArrayList<Builder>();
    }
    public String getName() {
        return name;
    }
    public int getReward() {
        return reward;
    }
    public Ressources getRessources() {
        return ressources;
    }
    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public boolean isReplaceable() {
        return isreplaceable;
    }
    public ArrayList<Builder> getBuilder() {
        return builder;
    }
    public void addBuilder(Builder b) {
        this.builder.add(b);
    }


}
