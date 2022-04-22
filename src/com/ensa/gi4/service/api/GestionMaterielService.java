package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    Materiel chercherMateriel(int id);
    void supprimerMateriel(int id);
    void modifierMateriel(Materiel materiel);
    void allouerUnMateriel(Materiel materiel);
}
