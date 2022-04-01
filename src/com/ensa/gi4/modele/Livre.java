package com.ensa.gi4.modele;

public class Livre extends Materiel {
    private String auteur;
    public Livre(int id, String name, String auteur) {
        super(id, name);
        this.auteur = auteur;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return String.format("Livre{%d, %s, %s} : %s", this.id, this.name, this.auteur, this.isAllocated?"Allouée":"Non-Allouée");
    }
}
