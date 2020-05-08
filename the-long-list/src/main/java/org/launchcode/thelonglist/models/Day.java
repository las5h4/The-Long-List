package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Day extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "day")
    private final List<Meal> meals = new ArrayList<>();

    @ManyToOne
    private Plan plan;

    public Day(String name) {
        this.name = name;
    }

    public Day() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }
}
