package org.launchcode.thelonglist.models;

import javax.persistence.Entity;

@Entity
public class Ingredient extends AbstractEntity {

    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
