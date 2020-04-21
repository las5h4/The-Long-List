package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.CourseRepository;
import org.launchcode.thelonglist.data.IngredientRepository;
import org.launchcode.thelonglist.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
