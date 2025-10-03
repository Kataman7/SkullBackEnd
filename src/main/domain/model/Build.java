package main.domain.model;

public class Build {
    private String name;
    private int coast;
    private Ressources ressources;

    public Build(String name, int coast, int[] ressources) {
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


}
