package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.ChaiseDao;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionChaiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionChaiseServiceImpl implements GestionChaiseService {
    private final ChaiseDao chaiseDao;
    private final ApplicationPublisher applicationPublisher;

    @Autowired
    public GestionChaiseServiceImpl(ChaiseDao chaiseDao, ApplicationPublisher applicationPublisher) {
        this.chaiseDao = chaiseDao;
        this.applicationPublisher = applicationPublisher;
    }

    @Override
    public void init() {

    }

    @Override
    public void listerChaise() {
        System.out.println( chaiseDao.getAll().size() +" Chaise");
        chaiseDao.getAll().forEach(System.out::println);
    }

    @Override
    public void ajouterNouveauChaise(Chaise chaise) {
        this.chaiseDao.insertEntity(chaise);
        this.applicationPublisher.publish(new MyEvent<>(chaise, EventType.ADD));
    }

    @Override
    public Chaise chercherChaiseParId(int id) {
        return this.chaiseDao.getEntityById(id);
    }

    @Override
    public void supprimerChaiseParId(int id) {
        Chaise chaise = this.chaiseDao.getEntityById(id);
        if(chaise != null)
            this.applicationPublisher.publish(new MyEvent<>(chaise, EventType.REMOVE));
        this.chaiseDao.deleteEntity(id);
    }

    @Override
    public void modifierChaise(Chaise chaise) {
        this.chaiseDao.updateEntity(chaise);
        this.applicationPublisher.publish(new MyEvent<>(chaise, EventType.UPDATE));
    }

    @Override
    public void allouerChaise(int id) {
        this.chaiseDao.allocate(id);
    }

}
