package com.ensa.gi4.service.impl;

import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here
    private final GestionLivreService gestionLivreService;
    private final GestionChaiseService gestionChaiseService;

    @Autowired
    public GestionMaterielServiceImpl(GestionLivreService gestionLivreService, GestionChaiseService gestionChaiseService) {
        this.gestionLivreService = gestionLivreService;
        this.gestionChaiseService = gestionChaiseService;
    }

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        System.out.println("Liste de matériel :");
        this.gestionLivreService.listerLivre();
        this.gestionChaiseService.listerChaise();

    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        if (materiel instanceof Livre){
            this.gestionLivreService.ajouterNouveauLivre((Livre) materiel);
        }else{
            this.gestionChaiseService.ajouterNouveauChaise((Chaise) materiel);
        }

        //System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succès !");
    }

    @Override
    public Materiel chercherMateriel(int id) {
        Livre livre = this.gestionLivreService.chercherLivreParId(id);
        Chaise chaise = this.gestionChaiseService.chercherChaiseParId(id);
        if (livre != null) return livre;
        else return chaise;
    }

    @Override
    public void supprimerMateriel(int id) {
        this.gestionLivreService.supprimerLivreParId(id);
        this.gestionChaiseService.supprimerChaiseParId(id);

    }

    @Override
    public void modifierMateriel(Materiel materiel) {
        if(materiel instanceof Livre) this.gestionLivreService.modifierLivre((Livre) materiel);
        else this.gestionChaiseService.modifierChaise((Chaise) materiel);
    }

    @Override
    public void allouerUnMateriel(Materiel materiel) {
        if(materiel.isAllocated()){
            System.out.println("Ce materiel est deja alloué");
        }else{
            this.gestionLivreService.allouerLivre(materiel.getId());
            this.gestionChaiseService.allouerChaise(materiel.getId());
            System.out.println("Materiel alloué avec success !");
        }

    }
}
