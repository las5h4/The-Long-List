package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.CourseRepository;
import org.launchcode.thelonglist.data.IngredientRepository;
import org.launchcode.thelonglist.models.Course;
import org.launchcode.thelonglist.models.Ingredient;
import org.launchcode.thelonglist.models.dto.CourseIngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping
    public String displayCourses(Model model) {
        model.addAttribute("title", "My Courses");
        model.addAttribute("courses", courseRepository.findAll());
        return "courses/index";
    }

    @GetMapping("create")
    public String displayCreateCourseForm(Model model) {
        model.addAttribute("title", "Create a new Course");
        model.addAttribute(new Course());
        return "courses/create";
    }

    @PostMapping("create")
    public String processCreateCourseForm(@ModelAttribute Course newCourse, Model model) {
        courseRepository.save(newCourse);
        model.addAttribute("title", "My Courses");
        model.addAttribute("courses", courseRepository.findAll());
        return "redirect:";
    }

    @GetMapping("add-course-ingredient")
    public String displayAddCourseIngredientForm(@RequestParam Integer courseId, Model model) {
        Optional<Course> result = courseRepository.findById(courseId);
        Course course = result.get();
        model.addAttribute("title", "Add Ingredient to " + course.getName());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        CourseIngredientDTO courseIngredient = new CourseIngredientDTO();
        courseIngredient.setCourse(course);
        model.addAttribute("courseIngredient", courseIngredient);
        return "courses/add-course-ingredient";
    }
}
