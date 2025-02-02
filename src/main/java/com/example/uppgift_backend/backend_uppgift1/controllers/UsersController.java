package com.example.uppgift_backend.backend_uppgift1.controllers;

import com.example.uppgift_backend.backend_uppgift1.models.Plants;
import com.example.uppgift_backend.backend_uppgift1.models.Users;
import com.example.uppgift_backend.backend_uppgift1.repsitories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    //Registrera en ny användare
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users userSaved = usersRepository.save(user);
        return ResponseEntity.ok(userSaved);
    }

    //Hämta en lista över alla användare
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return ResponseEntity.ok(users);
    }

    //Hämta en specifik användares information
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return ResponseEntity.ok(user);
    }

    //Uppdatera en användares information
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable String id, @RequestBody Users user) {
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());

        return ResponseEntity.ok(usersRepository.save(existingUser));
    }

    //Ta bort en användare
    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable String id) {
        if (!usersRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        usersRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Hämta alla växter som tillhör en specifik användare
    @GetMapping("/{id}/plants")
    public ResponseEntity<List<Plants>> getUserPlants(@PathVariable String id) {
        Users userplants = usersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (userplants.getPlants() == null || userplants.getPlants().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User has no plants");
        }
        return ResponseEntity.ok(userplants.getPlants());
    }





}
