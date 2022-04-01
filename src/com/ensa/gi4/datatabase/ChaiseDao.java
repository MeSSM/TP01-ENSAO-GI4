package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Materiel;
import java.util.List;
import java.util.Set;

public class ChaiseDao extends Dao<Chaise>{

    public ChaiseDao(Database database) {
        super(database);
    }



    @Override
    public void insertEntity(Chaise chaise) {
        database.add(chaise);
    }

    @Override
    public Chaise getEntityById(int id) {
        return (Chaise) database.stream().filter(chaise -> chaise.getId() == id && chaise instanceof Chaise).findFirst().orElse(null);
    }

    @Override
    public void updateEntity(Chaise chaise) {
        if (chaise == null) return;
        Chaise chaiseFound = (Chaise) database.stream().filter(m -> m.getId() == chaise.getId()).findFirst().orElse(null);
        if (chaiseFound != null){
            chaise.setName(chaise.getName());
            chaise.setBois(chaise.getBois());
        } else
            throw new RuntimeException("Chaise avec id: " + chaise.getId() + " ne ce trouve pas dans la base de donnée");
    }

    @Override
    public void deleteEntity(int id) {
        database.removeIf(chaise -> chaise.getId() == id);
    }

    @Override
    public List<Chaise> getAll() {
        return (List<Chaise>)(List<?>) database.stream().filter(chaise -> chaise instanceof Chaise).toList();
    }


}
