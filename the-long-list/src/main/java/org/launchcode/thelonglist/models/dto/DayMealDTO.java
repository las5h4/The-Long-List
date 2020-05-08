package org.launchcode.thelonglist.models.dto;

import org.launchcode.thelonglist.models.Day;
import org.launchcode.thelonglist.models.Meal;

public class DayMealDTO {

    private Day day;

    private Meal meal;

    public DayMealDTO() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
