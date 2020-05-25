package org.launchcode.thelonglist.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Plan extends AbstractEntity {

    private String name;

    private int planLength;

    @OneToMany(mappedBy = "plan", cascade = {CascadeType.ALL})
    private final List<Day> days = new ArrayList<>();

    @OneToMany(mappedBy = "plan", cascade = {CascadeType.ALL})
    private final List<GroceryList> lists = new ArrayList<>();

    @ManyToOne
    private User user;

    public Plan(String name, int planLength, User user) {
        this.name = name;
        this.planLength = planLength;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
