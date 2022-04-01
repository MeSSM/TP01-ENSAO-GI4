package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Livre;


public interface GestionLivreService {
    void init();
    void listerLivre();
    void ajouterNouveauLivre(Livre livre);
    Livre chercherLivreParId(int id);
    void supprimerLivreParId(int id);
    void modifierLivre(Livre livre);
}
