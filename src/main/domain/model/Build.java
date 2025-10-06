package main.domain.model;

import java.util.ArrayList;

public class Build {
    private String name;
    private int coast;
    private Ressources ressources;
    private ArrayList<Builder> builder;

    public Build(String name, int coast, int[] ressources) {
        this.name = name;
        this.coast = coast;
        this.ressources = new Ressources(ressources);
        this.builder =  new ArrayList<Builder>();
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
    public ArrayList<Builder> getBuilder() {
        return builder;
    }
    public void addBuilder(Builder b) {
        this.builder.add(b);
    }


}
