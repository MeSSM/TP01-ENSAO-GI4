package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.ChaiseDao;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.service.api.GestionChaiseService;

public class GestionChaiseServiceImpl implements GestionChaiseService {
    private ChaiseDao chaiseDao;

    public GestionChaiseServiceImpl(ChaiseDao chaiseDao) {
        this.chaiseDao = chaiseDao;
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
    }

    @Override
    public Chaise chercherChaiseParId(int id) {
        return this.chaiseDao.getEntityById(id);
    }

    @Override
    public void supprimerChaiseParId(int id) {
        this.chaiseDao.deleteEntity(id);
    }

    @Override
    public void modifierChaise(Chaise chaise) {
        this.chaiseDao.updateEntity(chaise);
    }

}
