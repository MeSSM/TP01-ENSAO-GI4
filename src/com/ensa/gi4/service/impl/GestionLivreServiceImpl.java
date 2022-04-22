package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.LivreDao;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionLivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionLivreServiceImpl implements GestionLivreService {
    private final LivreDao livreDao;
    private final ApplicationPublisher applicationPublisher;

    @Autowired
    public GestionLivreServiceImpl(LivreDao livreDao, ApplicationPublisher applicationPublisher) {
        this.livreDao = livreDao;
        this.applicationPublisher = applicationPublisher;
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
        this.applicationPublisher.publish(new MyEvent<>(livre, EventType.ADD));
    }

    @Override
    public Livre chercherLivreParId(int id) {
        return this.livreDao.getEntityById(id);
    }

    @Override
    public void supprimerLivreParId(int id) {
        Livre livre = this.livreDao.getEntityById(id);
        if(livre != null)
            this.applicationPublisher.publish(new MyEvent<>(livre, EventType.REMOVE));
        this.livreDao.deleteEntity(id);
    }

    @Override
    public void modifierLivre(Livre livre) {
        this.livreDao.updateEntity(livre);
        this.applicationPublisher.publish(new MyEvent<>(livre, EventType.UPDATE));
    }

    @Override
    public void allouerLivre(int id) {
        this.livreDao.allocate(id);
    }

}
