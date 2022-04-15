package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
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
public class ChaiseDao extends Dao<Chaise> {
    private final static String CREATE = "INSERT INTO chaise (name,bois) VALUES(?,?)";
    private final static String UPDATE = "UPDATE chaise SET name=?, bois=? WHERE id=?";



    @Override
    public void insertEntity(Chaise entity) {
        try {
            PreparedStatement insertStatement = this.connection.prepareStatement(CREATE);
            insertStatement.setString(1,entity.getName());
            insertStatement.setString(2,entity.getBois());
            insertStatement.execute();
            insertStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Chaise getEntityById(int id) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from chaise WHERE id=" + id + ";");
            if(resultSet.next())
                return new Chaise(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("bois"), resultSet.getInt("alloue") == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEntity(Chaise entity) {
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement(UPDATE);
            prepareStatement.setString(1, entity.getName());
            prepareStatement.setString(2, entity.getBois());
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
            statement.execute("DELETE FROM chaise WHERE id=" + id + ";");
            statement.close();
        }catch (SQLException e){

        }
    }

    @Override
    public List<Chaise> getAll() {
        ArrayList<Chaise> chaises = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chaise;");
            while (resultSet.next()){
                chaises.add(new Chaise(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("bois"), resultSet.getInt("alloue") == 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chaises;
    }

    @Override
    public void allocate(int id){
        if (this.getEntityById(id) != null){
            try {
                Statement statement = this.connection.createStatement();
                statement.execute("UPDATE chaise SET alloue=1 WHERE id=" + id + ";");
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
                statement.execute("UPDATE chaise SET alloue=0 WHERE id=" + id + ";");
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
