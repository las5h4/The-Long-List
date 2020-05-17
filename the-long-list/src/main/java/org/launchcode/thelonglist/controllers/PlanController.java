package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.*;
import org.launchcode.thelonglist.models.*;
import org.launchcode.thelonglist.models.dto.CourseIngredientDTO;
import org.launchcode.thelonglist.models.dto.MealCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("plan")
public class PlanController {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    ListRepository listRepository;

    @GetMapping("start")
    public String startNewPlan(Model model) {
        model.addAttribute("title", "Start New Plan");
        model.addAttribute(new Plan());
        return "plan/start";
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
        return new RedirectView("/plan/"+plan.getId());
    }

    @GetMapping("{planId}")
    public String displayNewPlanHome(@PathVariable Integer planId, Model model) {
        Optional<Plan> result = planRepository.findById(planId);
        Plan plan = result.get();
        model.addAttribute("title", plan.getName());
        model.addAttribute("subtitle", "Click on a Day to add Meals");
        model.addAttribute("planDays", plan.getDays());
        model.addAttribute("planId", planId);
        return "plan/home";
    }

    @GetMapping("{planId}/day/{dayId}")
    public String displayDayMeals(@PathVariable Integer dayId, @PathVariable Integer planId, Model model) {
        Optional<Day> result = dayRepository.findById(dayId);
        Day day = result.get();
        model.addAttribute("title", day.getName());
        model.addAttribute("meals", day.getMeals());
        model.addAttribute("dayId", dayId);
        model.addAttribute("planId", planId);
        return "plan/day";
    }

    @GetMapping("{planId}/day/{dayId}/meal/form")
    public String displayAddMealForm(@PathVariable Integer dayId, @PathVariable Integer planId, Model model){
        Optional<Day> result = dayRepository.findById(dayId);
        Day day = result.get();
        model.addAttribute("title", "New Meal");
        model.addAttribute("dayName", day.getName());
        model.addAttribute("dayId", dayId);
        model.addAttribute("planId", planId);
        model.addAttribute(new Meal());
        return "plan/add-meal";
    }

    @GetMapping("{planId}/day/{dayId}/meal/form/process")
    public RedirectView processAddMealForm(@ModelAttribute Meal meal, @PathVariable Integer dayId, @PathVariable Integer planId) {
        Optional<Day> result = dayRepository.findById(dayId);
        Day day = result.get();
        meal.setDay(day);
        mealRepository.save(meal);
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+meal.getId());
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}")
    public String displayAddMealCoursesForm(@PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, Model model) {
        Optional<Meal> result = mealRepository.findById(mealId);
        Meal meal = result.get();
        MealCourseDTO mealCourse = new MealCourseDTO();
        mealCourse.setMeal(meal);
        model.addAttribute("mealCourse", mealCourse);
        model.addAttribute("title", meal.getName());
        model.addAttribute("addedCourses", meal.getCourses());
        model.addAttribute("allCourses", courseRepository.findAll());
        model.addAttribute("dayId", dayId);
        model.addAttribute("planId", planId);
        model.addAttribute("mealId", mealId);
        return "plan/meal-courses";
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/remove")
    public RedirectView removeMealFromDay(@PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId) {
        Optional<Meal> mealResult = mealRepository.findById(mealId);
        Meal meal = mealResult.get();
        mealRepository.delete(meal);
        return new RedirectView("/plan/"+planId+"/day/"+dayId);
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/add")
    public RedirectView addCourse(@ModelAttribute MealCourseDTO mealCourse, @PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId) {
        Meal meal = mealCourse.getMeal();
        Course course = mealCourse.getCourse();
        if (!meal.getCourses().contains(course)) {
            meal.addCourses(course);
            mealRepository.save(meal);
        }
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+mealId);
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/form")
    public String displayCreateCourseForm(@PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, Model model) {
        model.addAttribute("title", "Create a New Course");
        model.addAttribute("dayId", dayId);
        model.addAttribute("planId", planId);
        model.addAttribute("mealId", mealId);
        model.addAttribute(new Course());
        return "plan/create-course";
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/form/process")
    public RedirectView createCourse(@ModelAttribute Course course, @PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId) {
        courseRepository.save(course);
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+mealId+"/course/"+course.getId());
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/{courseId}")
    public String displayAddIngredientsToCourseForm(@PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, @PathVariable Integer courseId, Model model) {
        Optional<Course> result = courseRepository.findById(courseId);
        Course course = result.get();
        CourseIngredientDTO courseIngredient = new CourseIngredientDTO();
        courseIngredient.setCourse(course);
        model.addAttribute("title", course.getName());
        model.addAttribute("courseIngredient", courseIngredient);
        model.addAttribute("courseIngredients", course.getIngredients());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("dayId", dayId);
        model.addAttribute("planId", planId);
        model.addAttribute("mealId", mealId);
        model.addAttribute("courseId", courseId);
        return "plan/add-ingredient";
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/{courseId}/remove")
    public RedirectView removeCourseFromMeal (@PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, @PathVariable Integer courseId) {
        Optional<Course> result = courseRepository.findById(courseId);
        Course course = result.get();
        Optional<Meal> mealResult = mealRepository.findById(mealId);
        Meal meal = mealResult.get();
        meal.removeCourse(course);
        mealRepository.save(meal);
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+mealId);
    }


    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/{courseId}/ingredient/add")
    public RedirectView createIngredient(@ModelAttribute CourseIngredientDTO courseIngredient, @PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, @PathVariable Integer courseId){
        Course course = courseIngredient.getCourse();
        Ingredient ingredient = courseIngredient.getIngredient();
        if (!course.getIngredients().contains(ingredient)) {
            course.addIngredients(ingredient);
            courseRepository.save(course);
        }
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+mealId+"/course/"+courseId);
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/{courseId}/ingredient/create")
    public String displayCreateIngredientForm(@PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, @PathVariable Integer courseId, Model model) {
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute("dayId", dayId);
        model.addAttribute("planId", planId);
        model.addAttribute("mealId", mealId);
        model.addAttribute("courseId", courseId);
        model.addAttribute(new Ingredient());
        return "plan/create-ingredient";
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/{courseId}/ingredient/form/process")
    public RedirectView processCreateIngredientForm(@ModelAttribute Ingredient ingredient, @PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, @PathVariable Integer courseId) {
        ingredientRepository.save(ingredient);
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+mealId+"/course/"+courseId);
    }

    @GetMapping("{planId}/day/{dayId}/meal/{mealId}/course/{courseId}/ingredient/{ingredientId}/remove")
    public RedirectView removeIngredientFromCourse(@PathVariable Integer ingredientId, @PathVariable Integer mealId, @PathVariable Integer dayId, @PathVariable Integer planId, @PathVariable Integer courseId) {
        Optional<Ingredient> ingredientResult = ingredientRepository.findById(ingredientId);
        Optional<Course> courseResult = courseRepository.findById(courseId);
        Ingredient ingredient = ingredientResult.get();
        Course course = courseResult.get();
        course.removeIngredient(ingredient);
        courseRepository.save(course);
        return new RedirectView("/plan/"+planId+"/day/"+dayId+"/meal/"+mealId+"/course/"+courseId);
    }

    @GetMapping("{planId}/list/generate")
    public RedirectView generateGroceryList(@PathVariable Integer planId) {
        Optional<Plan> result = planRepository.findById(planId);
        Plan plan = result.get();
        GroceryList list = new GroceryList(plan);
        list.generateList();
        listRepository.save(list);
        return new RedirectView("/list/view/"+list.getId());
    }
}
