package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.IngredientRepository;
import org.launchcode.thelonglist.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String displayIngredients(Model model) {
        model.addAttribute("title", "Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(Model model){
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "ingredients/add";
    }

    @PostMapping("add")
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Model model) {
        ingredientRepository.save(newIngredient);
        model.addAttribute("title", "Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "redirect:";
    }

}
