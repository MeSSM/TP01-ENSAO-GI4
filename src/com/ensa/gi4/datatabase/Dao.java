package com.ensa.gi4.datatabase;


import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.List;


public abstract class Dao<T extends Model> {
    protected Connection connection;
    protected MaterielFactory materielFactory;


    public abstract void insertEntity(T entity);
    public abstract T getEntityById(int id);
    public abstract void updateEntity(T entity);
    public abstract void deleteEntity(int id);
    public abstract List<T> getAll();
    public abstract void allocate(int id);
    public abstract void deallocate(int id);

    @Autowired
    private void setConnection(DatabaseManager databaseManager) throws SQLException {
        this.connection = databaseManager.getConnection();
    }

    @Autowired
    private void setMaterielFactory(MaterielFactory materielFactory){
        this.materielFactory = materielFactory;
    }



}
