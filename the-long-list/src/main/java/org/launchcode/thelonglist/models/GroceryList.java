package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GroceryList extends AbstractEntity {

    private String name;

    @ManyToOne
    private Plan plan;

    @ManyToMany
    private List<Ingredient> listIngredients = new ArrayList<>();

    @ManyToOne
    private User user;

    public GroceryList(Plan plan) {
        this.plan = plan;
    }

    public GroceryList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void generateList() {
        for (Day day : plan.getDays()) {
            for (Meal meal : day.getMeals()) {
                for (Course course : meal.getCourses()) {
                    for (Ingredient ingredient : course.getIngredients()) {
                        if (!listIngredients.contains(ingredient)) {
                            listIngredients.add(ingredient);
                        }
                    }
                }
            }
        }
    }

    public List<Ingredient> getList(String category) {
        List<Ingredient> categoryList = new ArrayList<>();
        for (Ingredient ingredient : listIngredients) {
            if (ingredient.getCategory().equals(category)) {
                categoryList.add(ingredient);
            }
        }
        return categoryList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
