package com.ensa.gi4.bootstrap;

import com.ensa.gi4.datatabase.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DataBootsrapper {
    private final static String CREATE_CHAISE = "CREATE TABLE IF NOT EXISTS chaise (id int, name VARCHAR, bois VARCHAR, alloue int DEFAULT 0)";
    private final static String CREATE_Livre = "CREATE TABLE IF NOT EXISTS livre (id int, name VARCHAR, auteur VARCHAR, alloue int DEFAULT 0)";
    private final Connection connection;

    @Autowired
    public DataBootsrapper(DatabaseManager databaseManager) throws SQLException {
        this.connection = databaseManager.getConnection();
    }

    public void initTables() {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(CREATE_CHAISE);
            statement.execute(CREATE_Livre);
            System.out.println("INITIALISATION COMPLETE");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
