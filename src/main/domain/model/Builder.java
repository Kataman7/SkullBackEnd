package main.domain.model;

public class Builder implements Model {
    private String name;
    private int coast;
    private final Ressources ressources;
    private Build assignedBuild = null;
    private boolean isInfected = false;

    public Builder(String name, int coast, int[] ressources) {
        this.name = name;
        this.coast = coast;
        this.ressources = new Ressources(ressources);
    }
    public String getName() {
        return name;
    }
    public int getCoast() {
        return coast;
    }
    public Ressources getRessources() {
        return ressources;
    }
    public Build getAssignedBuild() {
        return assignedBuild;
    }
    public void setAssignedBuild(Build assignedBuild) {
        this.assignedBuild = assignedBuild;
    }
    public boolean isInfected() {
        return isInfected;
    }
    public void setInfected(boolean infected) {
        isInfected = infected;
    }
}
