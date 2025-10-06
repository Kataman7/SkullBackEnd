package main.domain.model;

public class Build {
    private final String name;
    private final int reward;
    private final Ressources ressources;
    private final int sizeX;
    private final int sizeY;
    private final boolean isreplaceable;

    public Build(String name, int coast, int[] ressources, int sizeX, int sizeY, boolean isreplaceable) {
        this.name = name;
        this.reward = coast;
        this.ressources = new Ressources(ressources);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.isreplaceable = isreplaceable;
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
}
