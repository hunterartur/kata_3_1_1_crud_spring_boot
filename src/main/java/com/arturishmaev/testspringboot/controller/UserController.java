package com.arturishmaev.testspringboot.controller;

import com.arturishmaev.testspringboot.model.User;
import com.arturishmaev.testspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String startPage(ModelMap model) {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            model.addAttribute("users", users);
        }
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createUser";
        } else {
            userService.save(user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(Model model, @RequestParam Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PutMapping("/refreshUser")
    public String refreshUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/updateUser";
        } else {
            userService.updateUserById(user);
            return "redirect:/";
        }
    }

    @DeleteMapping(value = "/deleteUser")
    public String deleteUser(@ModelAttribute User user) {
        userService.removeUserById(user.getId());
        return "redirect:/";
    }

}
