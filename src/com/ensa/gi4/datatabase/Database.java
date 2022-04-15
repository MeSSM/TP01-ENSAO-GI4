package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


public class Database {
    private Set<Materiel> database;

    public Database() {
        this.database = new HashSet<>();
        this.database.add(new Livre(1,"Candide", "jack l7ewat", false));
        this.database.add(new Livre(2,"Ce comme le C", "Berboucha", false));
        this.database.add(new Chaise(3,"Chaise 1", "Hetre", false));
        this.database.add(new Chaise(4,"Chaise 2", "Sapin", false));
    }

    public Set<Materiel> getDatabase() {
        return database;
    }

    public void setDatabase(Set<Materiel> database) {
        this.database = database;
    }
}
