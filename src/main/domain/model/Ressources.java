package main.domain.model;

public class Ressources {
    private int bois;
    private int pierre;
    private int or;
    private int nourriture;

    public Ressources(int[] ressources) {
        this.bois = ressources[0];
        this.pierre = ressources[1];
        this.or = ressources[2];
        this.nourriture = ressources[3];
    }

    public int getBois() {
        return bois;
    }
    public int getPierre() {
        return pierre;
    }
    public int getOr() {
        return or;
    }
    public int getNourriture() {
        return nourriture;
    }
}
