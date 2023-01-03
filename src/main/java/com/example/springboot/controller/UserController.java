package com.example.springboot.controller;

import com.example.springboot.models.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listOfUsers(Model model) {
        model.addAttribute("users", userService.listOfUsers());
        return "index";
    }
    @GetMapping("/{id}")
    public void showUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
    }
    @GetMapping("/new")
    public String newUserForm(@ModelAttribute("user") User user) {
        return "new";
    }
    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.saveNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @PatchMapping(path = "/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
