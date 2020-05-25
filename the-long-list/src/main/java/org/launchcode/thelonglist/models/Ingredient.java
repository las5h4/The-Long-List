package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    private String name;

    private IngredientCategory category;



    @ManyToMany(mappedBy = "ingredients")
    private final List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "listIngredients")
    private final List<GroceryList> lists = new ArrayList<>();

    public Ingredient(String name, IngredientCategory category) {
        this.name = name;
        this.category = category;
    }

    public Ingredient() {
    }

    public IngredientCategory getCategory() {
        return category;
    }

    public void setCategory(IngredientCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
