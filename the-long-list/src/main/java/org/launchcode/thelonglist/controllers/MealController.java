package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.CourseRepository;
import org.launchcode.thelonglist.data.IngredientRepository;
import org.launchcode.thelonglist.data.MealRepository;
import org.launchcode.thelonglist.models.Course;
import org.launchcode.thelonglist.models.Ingredient;
import org.launchcode.thelonglist.models.Meal;
import org.launchcode.thelonglist.models.dto.CourseIngredientDTO;
import org.launchcode.thelonglist.models.dto.MealCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("meals")
public class MealController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    MealRepository mealRepository;

    @GetMapping
    public String displayMeals(Model model) {
        model.addAttribute("title", "My Meals");
        model.addAttribute("meals", mealRepository.findAll());
        return "meals/index";
    }

    @GetMapping("create")
    public String displayCreateMealForm(Model model) {
        model.addAttribute("title", "Create a new Meal");
        model.addAttribute(new Meal());
        return "meals/create";
    }

    @PostMapping("create")
    public String processCreateMealForm(@ModelAttribute Meal newMeal, Model model) {
        newMeal.setName();
        mealRepository.save(newMeal);
        model.addAttribute("title", "My Meals");
        model.addAttribute("meals", mealRepository.findAll());
        return "redirect:";
    }

    @GetMapping("add-meal-course")
    public String displayAddMealCourseForm(@RequestParam Integer mealId, Model model) {
        Optional<Meal> result = mealRepository.findById(mealId);
        Meal meal = result.get();
        model.addAttribute("title", "Add Course to " + meal.getName());
        model.addAttribute("courses", courseRepository.findAll());
        MealCourseDTO mealCourse = new MealCourseDTO();
        mealCourse.setMeal(meal);
        model.addAttribute("mealCourse", mealCourse);
        return "meals/add-meal-course.html";
    }

    @PostMapping("add-meal-course")
    public String processAddMealCourseForm(@ModelAttribute MealCourseDTO mealCourse, Model model) {
        Meal meal = mealCourse.getMeal();
        Course course = mealCourse.getCourse();
        if (!meal.getCourses().contains(course)) {
            meal.addCourses(course);
            mealRepository.save(meal);
        }
        model.addAttribute("title", "My Meals");
        model.addAttribute("meals", mealRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view-meal-courses")
    public String viewMealCourses(@RequestParam int mealId, Model model) {
        Optional<Meal> result = mealRepository.findById(mealId);
        Meal meal = result.get();
        model.addAttribute("title", meal.getName()+" Courses");
        model.addAttribute("courses", meal.getCourses());
        model.addAttribute("mealId", mealId);
        return "meals/view-meal-courses.html";
    }
}
