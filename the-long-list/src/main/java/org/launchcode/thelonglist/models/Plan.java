package org.launchcode.thelonglist.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Plan extends AbstractEntity {

    private String name;

    private int planLength;

    @OneToMany(mappedBy = "plan")
    private final List<Day> days = new ArrayList<>();

    public Plan(String name, int planLength) {
        this.name = name;
        this.planLength = planLength;
    }

    public Plan() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlanLength() {
        return planLength;
    }

    public void setPlanLength(int planLength) {
        this.planLength = planLength;
    }

    public List<Day> getDays() {
        return days;
    }

    public void addDay(Day day) {
        days.add(day);
    }
}
