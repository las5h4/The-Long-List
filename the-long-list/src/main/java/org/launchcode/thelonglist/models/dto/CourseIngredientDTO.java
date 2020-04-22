package org.launchcode.thelonglist.models.dto;

import org.launchcode.thelonglist.models.Course;
import org.launchcode.thelonglist.models.Ingredient;

import javax.validation.constraints.NotNull;

public class CourseIngredientDTO {

    @NotNull
    private Course course;

    @NotNull
    private Ingredient ingredient;

    public CourseIngredientDTO() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
