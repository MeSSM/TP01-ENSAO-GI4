package com.ensa.gi4.datatabase;


import com.ensa.gi4.modele.Materiel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public abstract class Dao<T extends Model> {
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
        return this.database.stream().anyMatch(e -> e.getId() == id && e.isAllocated());
    }

    public void allocate(int id ){
        this.database.stream().filter(e -> e.getId() == id).findFirst().ifPresent(materiel -> materiel.setAllocated(true));
    }

    public void deAllocate(int id ){
        this.database.stream().filter(e -> e.getId() == id).findFirst().ifPresent(materiel -> materiel.setAllocated(false));
    }


}
