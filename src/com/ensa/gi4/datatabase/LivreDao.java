package com.ensa.gi4.datatabase;


import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import java.util.List;
import java.util.Set;

public class LivreDao extends Dao<Livre>{



    public LivreDao(Database database) {
        super(database);
    }

    @Override
    public void insertEntity(Livre livre) {
        database.add(livre);
    }

    @Override
    public Livre getEntityById(int id) {
        return (Livre) database.stream().filter(livre -> livre.getId() == id && livre instanceof Livre).findFirst().orElse(null);
    }

    @Override
    public void updateEntity(Livre livre) {
        if (livre == null) return;
        Livre livreFound = (Livre) database.stream().filter(m -> m.getId() == livre.getId()).findFirst().orElse(null);
        if (livreFound != null){
            livre.setName(livre.getName());
            livre.setAuteur(livre.getAuteur());
        } else
            throw new RuntimeException("Livre avec id: " + livre.getId() + " ne ce trouve pas dans la base de donnée");
    }

    @Override
    public void deleteEntity(int id) {
        database.removeIf(livre -> livre.getId() == id);
    }

    @Override
    public List<Livre> getAll() {
        return (List<Livre>)(List<?>) database.stream().filter(livre -> livre instanceof Livre).toList();
    }



}
