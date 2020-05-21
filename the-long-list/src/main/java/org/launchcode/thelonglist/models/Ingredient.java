package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    private String name;

    private String category;



    @ManyToMany(mappedBy = "ingredients")
    private final List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "listIngredients")
    private final List<GroceryList> lists = new ArrayList<>();

    public Ingredient(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Ingredient() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
