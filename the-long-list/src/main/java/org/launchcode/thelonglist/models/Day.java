package org.launchcode.thelonglist.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Day extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "day", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private final List<Meal> meals = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    private Plan plan;

    @ManyToOne
    private User user;

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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
