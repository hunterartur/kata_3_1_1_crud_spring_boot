package com.arturishmaev.testspringboot.controller;

import com.arturishmaev.testspringboot.model.User;
import com.arturishmaev.testspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String startPage(ModelMap model) {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            model.addAttribute("users", users);
        }
        return "index";
    }

    @RequestMapping(value = "/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createUser";
        } else {
            userService.save(user);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(Model model, @RequestParam Long id) {
        System.out.println(id);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/refreshUser")
    public String refreshUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/updateUser";
        } else {
            userService.updateUserById(user);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

}
