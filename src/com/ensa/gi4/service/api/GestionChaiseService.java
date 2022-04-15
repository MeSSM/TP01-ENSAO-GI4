package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Chaise;


public interface GestionChaiseService {
    void init();
    void listerChaise();
    void ajouterNouveauChaise(Chaise chaise);
    Chaise chercherChaiseParId(int id);
    void supprimerChaiseParId(int id);
    void modifierChaise(Chaise chaise);
    void allouerChaise(int id);
}
