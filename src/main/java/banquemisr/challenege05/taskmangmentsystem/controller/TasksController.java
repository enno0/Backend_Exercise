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

import banquemisr.challenege05.taskmangmentsystem.models.Tasks;
import banquemisr.challenege05.taskmangmentsystem.service.TasksCRUD;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/web/tasks")
public class TasksController {

    @Autowired
    private TasksCRUD tCRUD;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("tasks", new Tasks());
        return "addTasks";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Tasks tasks, BindingResult result) {
        if (result.hasErrors()) {
            return "addTasks"; // Return to the form view if validation errors exist
        }
        tCRUD.saveInfo(tasks.getTitle(), tasks.getDescription(), tasks.getStatus());
        return "redirect:/web/tasks/allTasks";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable @ValidId Long id, Model model) {
        Optional<Tasks> tasks = tCRUD.getById(id);
        if (tasks.isPresent()) {
            model.addAttribute("tasks", tasks.get());
            return "updateTask";
        } else {
            return "redirect:/web/tasks/allTasks";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable @ValidId Long id, @Valid @ModelAttribute Tasks tasks, BindingResult result) {
        if (result.hasErrors()) {
            return "updateTask"; // Return to the form view if validation errors exist
        }
        tCRUD.updateInfo(tasks.getTitle(), tasks.getDescription(), tasks.getStatus(), id);
        return "redirect:/web/tasks/allTasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable @ValidId Long id) {
        tCRUD.delete(id);
        return "redirect:/web/tasks/allTasks";
    }

    @GetMapping("/allTasks")
    public String getAllTasks(Model model) {
        List<Tasks> tasks = tCRUD.getAll();
        model.addAttribute("tasks", tasks);
        return "tasksList"; // Return the view name
    }
}
