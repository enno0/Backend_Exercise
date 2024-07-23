package com.backend_xeercise.taskmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend_xeercise.taskmanagementsystem.models.Users;
import com.backend_xeercise.taskmanagementsystem.service.UsersCRUD;

@Controller
@RequestMapping("/web/users")
public class UsersWebController {

    @Autowired
    private UsersCRUD usersCRUD;

    @GetMapping
    public String getAllUsers(Model model) {
        List<Users> users = usersCRUD.getAll();
        model.addAttribute("users", users);
        return "usersList"; // Return the view name
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "newUserForm"; // return the view name for the new user form
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<Users> user = usersCRUD.getById(id);
        model.addAttribute("user", user.orElse(null));
        return "userDetail"; // Return the view name
    }

    @PostMapping
    public String createUser(@ModelAttribute Users user) {
        usersCRUD.saveInfo(user.getName(), user.getEmail(), user.getPassword(), user.getRoles());
        return "redirect:/web/users"; // Redirect after creation
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute Users user) {
        usersCRUD.updateInfo(user.getName(), user.getEmail(), user.getPassword(), user.getRoles(), id);
        return "redirect:/web/users"; // Redirect after update
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersCRUD.delete(id);
        return "redirect:/web/users"; // Redirect after deletion
    }
}