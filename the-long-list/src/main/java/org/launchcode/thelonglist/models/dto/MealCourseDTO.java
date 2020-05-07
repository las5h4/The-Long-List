package org.launchcode.thelonglist.models.dto;

import org.launchcode.thelonglist.models.Course;
import org.launchcode.thelonglist.models.Meal;

public class MealCourseDTO {

    private Meal meal;

    private Course course;

    public MealCourseDTO() {
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
