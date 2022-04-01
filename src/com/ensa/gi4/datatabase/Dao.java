package com.ensa.gi4.datatabase;


import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.List;
import java.util.Set;

public abstract class Dao<T extends Entity> {
    protected Set<Materiel> database;
    public Dao(Database database) {
        this.database = database.getDatabase();
    }

    abstract void insertEntity(T entity);
    abstract T getEntityById(int id);
    abstract void updateEntity(T entity);
    abstract void deleteEntity(int id);
    abstract List<T> getAll();

    public boolean isAllocated(int id){
        return this.database.stream().filter(e -> e.getId() == id && e.isAllocated()).findFirst().orElse(null)!=null;
    }

    public void allocate(int id ){
        Materiel materiel = this.database.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (materiel != null)
            materiel.setAllocated(true);
    }

    public void deAllocate(int id ){
        Materiel materiel = this.database.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (materiel != null)
            materiel.setAllocated(false);
    }


}
