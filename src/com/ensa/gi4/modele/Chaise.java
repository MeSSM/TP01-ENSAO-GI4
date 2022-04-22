package com.ensa.gi4.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class Chaise extends Materiel {
    public String bois;
    public Chaise(int id, String name, String bois, boolean alloue) {
        super(id, name, alloue);
        this.bois = bois;
    }



    @Override
    public String toString() {
        return String.format("Chaise{%d, %s, %s} : %s", this.id, this.name, this.bois, this.isAllocated?"Allouée":"Non-Allouée");
    }


}
