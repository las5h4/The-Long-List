package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.ListRepository;
import org.launchcode.thelonglist.models.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;



@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    ListRepository listRepository;

    @GetMapping("view/{listId}")
    public String viewList(@PathVariable Integer listId, Model model) {
        Optional<GroceryList> result = listRepository.findById(listId);
        GroceryList list = result.get();
        model.addAttribute("title", "List");
        model.addAttribute("ingredients", list.getList());
        return "list/view";
    }
}
