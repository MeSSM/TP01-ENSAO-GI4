package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.LivreDao;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionLivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionLivreServiceImpl implements GestionLivreService {
    private final LivreDao livreDao;

    @Autowired
    public GestionLivreServiceImpl(LivreDao livreDao) {
        this.livreDao = livreDao;
    }

    @Override
    public void init() {

    }

    @Override
    public void listerLivre() {
        System.out.println( livreDao.getAll().size() +" Livres");
        livreDao.getAll().forEach(System.out::println);
    }

    @Override
    public void ajouterNouveauLivre(Livre livre) {
        this.livreDao.insertEntity(livre);
    }

    @Override
    public Livre chercherLivreParId(int id) {
        return this.livreDao.getEntityById(id);
    }

    @Override
    public void supprimerLivreParId(int id) {
        this.livreDao.deleteEntity(id);
    }

    @Override
    public void modifierLivre(Livre livre) {
        this.livreDao.updateEntity(livre);
    }

}
