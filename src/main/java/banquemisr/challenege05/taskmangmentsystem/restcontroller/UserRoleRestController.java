package banquemisr.challenege05.taskmangmentsystem.restcontroller;

import java.util.List;
import java.util.Optional;

import banquemisr.challenege05.taskmangmentsystem.customannotation.ValidId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banquemisr.challenege05.taskmangmentsystem.models.UserRole;
import banquemisr.challenege05.taskmangmentsystem.service.UserRoleCRUD;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleRestController {
    @Autowired
    private UserRoleCRUD uRoleCRUD;

    @GetMapping
    public ResponseEntity<List<UserRole>> getAllRoles() {
        return ResponseEntity.ok(uRoleCRUD.getAllUserRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable @ValidId Long id) {
        Optional<UserRole> userRole = uRoleCRUD.getUserRoleById(id);
        return userRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRole userRole) {
        uRoleCRUD.saveInfo(userRole.getName(), userRole.getRole());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable @ValidId Long id, @Valid @RequestBody UserRole userRole) {
        uRoleCRUD.updateInfo(userRole.getName(), userRole.getRole(), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @ValidId Long id) {
        uRoleCRUD.delete(id);
        return ResponseEntity.noContent().build();
    }

}
