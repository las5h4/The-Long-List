package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.ListRepository;
import org.launchcode.thelonglist.data.UserRepository;
import org.launchcode.thelonglist.models.Constants;
import org.launchcode.thelonglist.models.GroceryList;
import org.launchcode.thelonglist.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;



@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    ListRepository listRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String viewListIndex(HttpSession session, Model model) {
        Object userId = session.getAttribute("user");
        Optional<User> result = userRepository.findById((Integer) userId);
        User user = result.get();
        model.addAttribute("title", "My Lists");
        model.addAttribute("lists", user.getLists());
        return "list/index";
    }

    @GetMapping("view/{listId}")
    public String viewList(@PathVariable Integer listId, Model model) {
        Optional<GroceryList> result = listRepository.findById(listId);
        GroceryList list = result.get();
        model.addAttribute("title", list.getPlan().getName());
        for (String category : Constants.getIngredientCategories()) {
            model.addAttribute(category.replaceAll("[^a-zA-Z]","")+"List", list.getList(category));
        }
        return "list/view";
    }
}
