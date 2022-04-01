package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;

public class MaterielFactory {
    public static int currentId = 0;

    public Livre creerLivre(String name, String auteur){
        return new Livre(currentId++, name, auteur);
    }

    public Chaise creerChaise(String name, String bois){
        return new Chaise(currentId++, name, bois);
    }
}
