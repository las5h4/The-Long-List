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

    @ManyToMany
    private final List<Course> courses = new ArrayList<>();

    public Meal(String name, Day day) {
        this.day = day;
        this.name = name;
    }

    public Meal() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) { courses.remove(course); }
}
