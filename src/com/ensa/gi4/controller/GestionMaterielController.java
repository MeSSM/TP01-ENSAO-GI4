package com.ensa.gi4.controller;

import com.ensa.gi4.datatabase.MaterielFactory;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class GestionMaterielController {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private GestionMaterielService gestionMaterielService;
    private MaterielFactory materielFactory;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }

    public void chercherMateriel() {
        System.out.print("Entrer l'id du materiel :");
        System.out.println(gestionMaterielService.chercherMateriel(scanner.nextInt()));
    }

    public void ajouterMateriel(){

        String userEntry;
        do{
            System.out.print("Enter le type du materiel: (livre/chaise): ");
            userEntry = scanner.next();
        }while(!userEntry.equals("livre") && !userEntry.equals("chaise"));
        if (userEntry.equals("livre")){
            System.out.print("Enrer le nom : ");
            String nom = scanner.next();
            System.out.print("Enrer l'auteur : ");
            String auteur = scanner.next();
            gestionMaterielService.ajouterNouveauMateriel(this.materielFactory.creerLivre(nom, auteur));
        }else{
            System.out.print("Enrer le nom : ");
            String nom = scanner.next();
            System.out.print("Enrer le type du bois : ");
            String bois = scanner.next();
            gestionMaterielService.ajouterNouveauMateriel(this.materielFactory.creerChaise(nom, bois));
        }
    }

    public void supprimerMateriel() {
        System.out.print("Entrer l'id du materiel à supprimer: ");
        int id = scanner.nextInt();
        if(gestionMaterielService.chercherMateriel(id) != null){
            gestionMaterielService.supprimerMateriel(id);
        }
    }

    public void modifierMateriel() {
        System.out.print("Enter l'id du materiel: ");
        int idMateriel = scanner.nextInt();
        Materiel materiel = gestionMaterielService.chercherMateriel(idMateriel);
        if (materiel == null)
            System.out.println("Materiele introuvable !");
        else if(materiel instanceof Livre){
            System.out.println("Livre Trouvé ! " + (Livre) materiel);
            System.out.print("Enter le nouveau nom : ");
            String nom = scanner.next();
            System.out.print("Enter le nouveau auteur : ");
            String auteur = scanner.next();
            materiel.setName(nom !=null?nom: materiel.getName());
            ((Livre) materiel).setAuteur(auteur!=null?auteur:((Livre) materiel).getAuteur());

        }else {
            System.out.println("Chaise Trouvée ! " + (Chaise) materiel);
            System.out.print("Enter le nouveau nom : ");
            String nom = scanner.next();
            System.out.print("Enter le nouveau type de bois : ");
            String chaise = scanner.next();
            materiel.setName(nom !=null?nom: materiel.getName());
            ((Chaise) materiel).setBois(chaise!=null?chaise:((Chaise) materiel).getBois());
        }
        gestionMaterielService.modifierMateriel(materiel);
    }


    public void allouerUnMateriel() {
        System.out.print("Entrer l'id du materiel: ");
        int materielId = scanner.nextInt();
        Materiel materiel = gestionMaterielService.chercherMateriel(materielId);
        if(materiel != null){
            this.gestionMaterielService.allouerUnMateriel(materiel);
        }else{
            System.out.println("Le materiel est introuvable !");
        }
    }


    public void afficherMenu() {
        System.out.println("[1] : Lister les materiels.");
        System.out.println("[2] : Ajouter un nouveau materiel");
        System.out.println("[3] : Afficher Un materiel");
        System.out.println("[4] : Modifier un materiel");
        System.out.println("[5] : Suprrimer un materiel");
        System.out.println("[6] : Allouer un materiel");
        System.out.println("[0] : Sortir de l'application");


        System.out.print("localhost@root~# ");
        String next = scanner.next();
        switch (next) {
            case "0" -> sortirDeLApplication();
            case "1" -> listerMateriel();
            case "2" -> ajouterMateriel();
            case "3" -> chercherMateriel();
            case "4" -> modifierMateriel();
            case "5" -> supprimerMateriel();
            case "6" -> allouerUnMateriel();
            default -> System.out.println("Choix invalide ! Veuiller réssayer");
        }

    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    @Autowired
    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }

    @Autowired
    public void setMaterielFactory(MaterielFactory materielFactory){
        this.materielFactory = materielFactory;
    }


}
