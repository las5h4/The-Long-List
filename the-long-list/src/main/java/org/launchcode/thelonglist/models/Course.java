package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends AbstractEntity {

    private String name;

    @ManyToMany
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String showIngredients() {
        String ingredientsString = null;
        for (Ingredient ingredient : ingredients) {
            ingredientsString.concat(ingredient.getName() + ", ");
        }
        return ingredientsString;
    }

    public void addIngredients(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }


}
