package com.ensa.gi4.modele;

import com.ensa.gi4.datatabase.Entity;

public abstract class Materiel implements Entity {
    protected int id;
    protected String name;
    protected boolean isAllocated;

    public Materiel(int id, String name) {
        this.id = id;
        this.name = name;
        this.isAllocated = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void setAllocated(boolean allocated) {
        isAllocated = allocated;
    }


}