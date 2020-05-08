package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import org.launchcode.thelonglist.models.Day;

@Entity
public class Meal extends AbstractEntity {

    private String name;

    @ManyToOne
    private Day day;

    private String mealType;

    @ManyToMany
    private final List<Course> courses = new ArrayList<>();

    public Meal(Day day, String mealType) {
        this.day = day;
        this.mealType = mealType;
    }

    public Meal() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
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
        this.name = day.getName() + " " + mealType;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }
}
