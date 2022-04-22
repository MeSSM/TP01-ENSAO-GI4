package com.ensa.gi4.modele;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class Livre extends Materiel {
    private String auteur;

    public Livre(int id, String name, String auteur, boolean alloue) {
        super(id, name, alloue);
        this.auteur = auteur;
    }


    @Override
    public String toString() {
        return String.format("Livre{%d, %s, %s} : %s", this.id, this.name, this.auteur, this.isAllocated?"Allouée":"Non-Allouée");
    }
}
