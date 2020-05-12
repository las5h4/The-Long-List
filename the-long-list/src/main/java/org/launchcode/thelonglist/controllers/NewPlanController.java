package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.DayRepository;
import org.launchcode.thelonglist.data.PlanRepository;
import org.launchcode.thelonglist.models.Day;
import org.launchcode.thelonglist.models.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("new-plan")
public class NewPlanController {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    PlanRepository planRepository;

    @GetMapping
    public String startNewPlan(Model model) {
        model.addAttribute("title", "Start New Plan");
        model.addAttribute(new Plan());
        return "new-plan/start";
    }

    @GetMapping("create")
    public RedirectView createNewPlan(@ModelAttribute Plan plan) {
        for(int i = 0; i < plan.getPlanLength(); i++) {
            Day day = new Day(plan.getName() + " Day " + (i + 1));
            plan.addDay(day);
            day.setPlan(plan);
            dayRepository.save(day);
        }
        planRepository.save(plan);
        return new RedirectView("/new-plan/"+plan.getId());
    }

    @GetMapping("{planId}")
    public String displayNewPlanHome(@PathVariable Integer planId, Model model) {
        Optional<Plan> result = planRepository.findById(planId);
        Plan plan = result.get();
        model.addAttribute("title", plan.getName());
        model.addAttribute("subtitle", "Click on a Day to add Meals");
        model.addAttribute("planDays", plan.getDays());
        return "new-plan/home";
    }

}
