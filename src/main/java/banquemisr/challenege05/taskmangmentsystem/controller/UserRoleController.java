package banquemisr.challenege05.taskmangmentsystem.controller;

import java.util.List;
import java.util.Optional;

import banquemisr.challenege05.taskmangmentsystem.customannotation.ValidId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import banquemisr.challenege05.taskmangmentsystem.models.UserRole;
import banquemisr.challenege05.taskmangmentsystem.service.UserRoleCRUD;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/web/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleCRUD uRoleCRUD;

    @GetMapping
    public String getAllRoles(Model model) {
        List<UserRole> userRoles = uRoleCRUD.getAllUserRoles();
        model.addAttribute("userRoles", userRoles);
        return "userRoleList"; // Return the view name for displaying all user roles
    }

    @GetMapping("/{id}")
    public String getUserRoleById(@PathVariable @ValidId Long id, Model model) {
        Optional<UserRole> userRole = uRoleCRUD.getUserRoleById(id);
        if (userRole.isPresent()) {
            model.addAttribute("userRole", userRole.get());
            return "viewUserRole"; // Return the view name for displaying a single user role
        } else {
            return "redirect:/web/userRole"; // Redirect if user role not found
        }
    }

    @GetMapping("/add")
    public String addUserRoleForm(Model model) {
        model.addAttribute("userRole", new UserRole());
        return "addUserRole"; // Return the view name for the add form
    }

    @PostMapping("/add")
    public String createUserRole(@Valid @ModelAttribute UserRole userRole, BindingResult result) {
        if (result.hasErrors()) {
            return "addUserRole"; // Return to the form view if validation errors exist
        }
        uRoleCRUD.saveInfo(userRole.getName(), userRole.getRole());
        return "redirect:/web/userRole"; // Redirect after successful creation
    }

    @GetMapping("/update/{id}")
    public String updateUserRoleForm(@PathVariable @ValidId Long id, Model model) {
        Optional<UserRole> userRole = uRoleCRUD.getUserRoleById(id);
        if (userRole.isPresent()) {
            model.addAttribute("userRole", userRole.get());
            return "updateUserRole"; // Return the view name for the update form
        } else {
            return "redirect:/web/userRole"; // Redirect if user role not found
        }
    }

    @PostMapping("/update/{id}")
    public String updateUserRole(@PathVariable @ValidId Long id, @Valid @ModelAttribute UserRole userRole,
            BindingResult result) {
        if (result.hasErrors()) {
            return "updateUserRole"; // Return to the form view if validation errors exist
        }
        uRoleCRUD.updateInfo(userRole.getName(), userRole.getRole(), id);
        return "redirect:/web/userRole"; // Redirect after successful update
    }

    @GetMapping("/delete/{id}")
    public String deleteUserRole(@PathVariable @ValidId Long id) {
        uRoleCRUD.delete(id);
        return "redirect:/web/userRole"; // Redirect after successful deletion
    }
}