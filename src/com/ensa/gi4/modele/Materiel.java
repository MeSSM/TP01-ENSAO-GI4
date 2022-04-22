package com.ensa.gi4.modele;

import com.ensa.gi4.datatabase.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public abstract class Materiel implements Model {

    protected int id;
    protected String name;
    protected boolean isAllocated;



}
