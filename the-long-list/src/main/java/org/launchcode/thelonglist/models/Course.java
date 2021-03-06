package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends AbstractEntity {

    private String name;

    @ManyToMany
    private final List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private final List<Meal> meals = new ArrayList<>();

    @ManyToOne
    private User user;

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

    public void removeIngredient(Ingredient ingredient) {ingredients.remove(ingredient); }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
