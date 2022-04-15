package com.ensa.gi4.datatabase;


import com.ensa.gi4.modele.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class LivreDao extends Dao<Livre> {
    private final static String CREATE = "INSERT INTO livre (id,name,auteur) VALUES(?,?,?)";
    private final static String UPDATE = "UPDATE livre SET name=?, auteur=? WHERE id=?";


    @Override
    public void insertEntity(Livre entity) {

        try {
            PreparedStatement insertStatement = this.connection.prepareStatement(CREATE);
            insertStatement.setInt(1, entity.getId());
            insertStatement.setString(2,entity.getName());
            insertStatement.setString(3,entity.getAuteur());
            insertStatement.execute();
            insertStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Livre getEntityById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from livre WHERE id=" + id + ";");
            if(resultSet.next())
                return new Livre(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("auteur"), resultSet.getInt("alloue") == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEntity(Livre entity) {
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement(UPDATE);
            prepareStatement.setString(1, entity.getName());
            prepareStatement.setString(2, entity.getAuteur());
            prepareStatement.setInt(3, entity.getId());
            prepareStatement.execute();
            prepareStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEntity(int id) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute("DELETE FROM livre WHERE id=" + id + ";");
            statement.close();
        }catch (SQLException e){

        }
    }

    @Override
    public List<Livre> getAll() {
        ArrayList<Livre> livres = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM livre;");
            while (resultSet.next()){
                livres.add(new Livre(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("auteur"), resultSet.getInt("alloue") == 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }

    public void allocate(int id){
        if (this.getEntityById(id) != null){
            try {
                Statement statement = this.connection.createStatement();
                statement.execute("UPDATE livre SET alloue=1 WHERE id=" + id + ";");
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deallocate(int id){
        if (this.getEntityById(id) != null){
            try {
                Statement statement = this.connection.createStatement();
                statement.execute("UPDATE livre SET alloue=0 WHERE id=" + id + ";");
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
