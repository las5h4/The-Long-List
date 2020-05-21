package org.launchcode.thelonglist.controllers;

import org.launchcode.thelonglist.data.UserRepository;
import org.launchcode.thelonglist.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String index(HttpSession session, Model model) {
        Object userId = session.getAttribute("user");
        Optional<User> result = userRepository.findById((Integer) userId);
        User user = result.get();
        model.addAttribute("username", user.getUsername());
        return "index";
    }

}
