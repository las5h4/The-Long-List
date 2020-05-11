package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.DayRepository;
import org.launchcode.thelonglist.data.PlanRepository;
import org.launchcode.thelonglist.models.Day;
import org.launchcode.thelonglist.models.Meal;
import org.launchcode.thelonglist.models.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("plans")
public class PlanController {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    DayRepository dayRepository;

    @GetMapping
    public String viewPlans(Model model) {
        model.addAttribute("title", "My Plans");
        model.addAttribute("plans", planRepository.findAll());
        return "plans/index";
    }

    @GetMapping("start-new")
    public String startNewPlan(Model model) {
        model.addAttribute("title", "Start A New Plan");
        model.addAttribute(new Plan());
        return "plans/start-new";
    }

    @PostMapping("start-new")
    public String createNewPlan(@ModelAttribute Plan newPlan, Model model) {
        for(int i = 0; i < newPlan.getPlanLength(); i++) {
            Day day = new Day(newPlan.getName() + " Day " + (i + 1));
            newPlan.addDay(day);
            dayRepository.save(day);
        }
        planRepository.save(newPlan);
        model.addAttribute("title", newPlan.getName());
        model.addAttribute("subtitle", "Click on a Day to add Meals");
        model.addAttribute("planDays", newPlan.getDays());
        return "plans/new-plan";
    }

    @GetMapping("new-plan")
    public String showPlan(@RequestParam int planId, Model model) {
        Optional<Plan> result = planRepository.findById(planId);
        Plan newPlan = result.get();
        for(int i = 0; i < newPlan.getPlanLength(); i++) {
            Day day = new Day(newPlan.getName() + " Day " + (i + 1));
            newPlan.addDay(day);
            dayRepository.save(day);
        }
        planRepository.save(newPlan);
        model.addAttribute("title", newPlan.getName());
        model.addAttribute("subtitle", "Click on a Day to add Meals");
        model.addAttribute("planDays", newPlan.getDays());
        return "plans/new-plan";
    }

    @GetMapping("day")
    public String showPlanDay(@RequestParam int dayId, Model model) {
        Optional<Day> result = dayRepository.findById(dayId);
        Day day = result.get();
        model.addAttribute("title", day.getName());
        model.addAttribute("meals", day.getMeals());
        model.addAttribute("dayId", day.getId());
        model.addAttribute("planId", day.getPlan().getId());
        return "plans/day";
    }
}
