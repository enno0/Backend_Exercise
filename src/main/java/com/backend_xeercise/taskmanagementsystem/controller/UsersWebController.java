package com.backend_xeercise.taskmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend_xeercise.taskmanagementsystem.customannotation.ValidId;
import com.backend_xeercise.taskmanagementsystem.datatransferopject.UsersTransferOp;
import com.backend_xeercise.taskmanagementsystem.models.Users;
import com.backend_xeercise.taskmanagementsystem.service.UsersCRUD;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/web/users")
public class UsersWebController {

    @Autowired
    private UsersCRUD usersCRUD;

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<Users> users = usersCRUD.getAll();
        model.addAttribute("users", users);
        return "usersList"; // Return the view name
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("users", new Users());
        return "addUsers";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute UsersTransferOp uTO, BindingResult result) {
        if (result.hasErrors()) {
            return "addUsers"; // Return to the form view if validation errors exist
        }
        usersCRUD.saveInfo(uTO.getName(), uTO.getEmail(), uTO.getPassword(), uTO.getMobilePhone());
        return "redirect:/web/users/allUsers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable @ValidId Long id, Model model) {
        Optional<Users> users = usersCRUD.getById(id);
        if (users.isPresent()) {
            model.addAttribute("users", users.get());
            model.addAttribute("UsersTransferOp",
                    new UsersTransferOp(users.get().getName(), users.get().getEmail(), users.get().getPassword(),
                            users.get().getMobilePhone()));
            return "update";
        } else {
            return "redirect:/web/users/allUsers";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable @ValidId Long id, @Valid @ModelAttribute UsersTransferOp uTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return "update"; // Return to the form view if validation errors exist
        }
        usersCRUD.updateInfo(uTO.getName(), uTO.getEmail(), uTO.getPassword(), uTO.getMobilePhone(), id);
        return "redirect:/web/users/allUsers";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable @ValidId Long id) {
        usersCRUD.delete(id);
        return "redirect:/web/users/allUsers";
        // Redirect after deletion
    }

}