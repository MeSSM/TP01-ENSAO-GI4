package com.ensa.gi4.modele;

public class Chaise extends Materiel {
    public String bois;
    public Chaise(int id, String name, String bois, boolean alloue) {
        super(id, name, alloue);
        this.bois = bois;
    }

    public String getBois() {
        return bois;
    }

    public void setBois(String bois) {
        this.bois = bois;
    }


    @Override
    public String toString() {
        return String.format("Chaise{%d, %s, %s} : %s", this.id, this.name, this.bois, this.isAllocated?"Allouée":"Non-Allouée");
    }


}
