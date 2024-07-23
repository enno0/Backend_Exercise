package com.backend_xeercise.taskmanagementsystem.restcontroller;

import java.util.List;
import java.util.Optional;

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

import com.backend_xeercise.taskmanagementsystem.models.Users;
import com.backend_xeercise.taskmanagementsystem.service.UsersCRUD;

@RestController
@RequestMapping("/api/users")
public class UsersRestController {

    @Autowired
    private UsersCRUD usersCRUD;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersCRUD.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Optional<Users> user = usersCRUD.getById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody Users user) {
        usersCRUD.saveInfo(user.getName(), user.getEmail(), user.getPassword(), user.getRoles());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody Users user) {
        usersCRUD.updateInfo(user.getName(), user.getEmail(), user.getPassword(), user.getRoles(), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersCRUD.delete(id);
        return ResponseEntity.noContent().build();
    }
}