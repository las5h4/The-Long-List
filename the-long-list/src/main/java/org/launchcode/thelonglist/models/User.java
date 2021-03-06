package org.launchcode.thelonglist.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private final List<Plan> plans = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private final List<Day> days = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private final List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private final List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private final List<GroceryList> lists = new ArrayList<>();

    public User() {
    }

    public User(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public List<Day> getDays() {
        return days;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<GroceryList> getLists() {
        return lists;
    }

    public void addPlan(Plan plan) {
        plans.add(plan);
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addList(GroceryList list) {
        lists.add(list);
    }
}
