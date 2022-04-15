package com.ensa.gi4.modele;

import com.ensa.gi4.datatabase.Model;

public abstract class Materiel implements Model {
    protected int id;
    protected String name;
    protected boolean isAllocated;

    public Materiel(int id, String name, boolean isAllocated) {
        this.id = id;
        this.name = name;
        this.isAllocated = isAllocated;
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
