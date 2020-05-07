package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Meal extends AbstractEntity {

    private String name;

    private int day;

    private String mealType;

    @ManyToMany
    private final List<Course> courses = new ArrayList<>();

    public Meal(int day, String mealType) {
        this.day = day;
        this.mealType = mealType;
        this.name = "Day " + day + " " + mealType;
    }

    public Meal() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = "Day " + day + " " + mealType;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }
}
