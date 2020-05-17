package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private final List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "listIngredients")
    private final List<GroceryList> lists = new ArrayList<>();

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
