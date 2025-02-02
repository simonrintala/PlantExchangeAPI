package com.example.uppgift_backend.backend_uppgift1.controllers;

import com.example.uppgift_backend.backend_uppgift1.PlantStatus;
import com.example.uppgift_backend.backend_uppgift1.models.Plants;
import com.example.uppgift_backend.backend_uppgift1.repsitories.PlantsRepsitory;
import com.example.uppgift_backend.backend_uppgift1.repsitories.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/plants")
public class PlantsController {
    @Autowired
    private PlantsRepsitory plantsRepsitory;

    @Autowired
    private UsersRepository usersRepository;

    //Lägg till en ny växt för byte/försäljning
    @PostMapping
    public ResponseEntity <Plants> createPlant(@Valid @RequestBody Plants plants) {

        if (plants.getUser() != null && usersRepository.existsById(plants.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }

        Plants savedPlant = plantsRepsitory.save(plants);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
    }

    //Hämta en lista över alla tillgängliga växter
    @GetMapping
    public ResponseEntity <List<Plants>> getAllPlants() {
        List<Plants> allPlants = plantsRepsitory.findAll();
        return ResponseEntity.ok(allPlants);
    }

    //Hämta information om en specifik växt
    @GetMapping("/{id}")
    public ResponseEntity <Plants> getPlantById(@PathVariable String id) {
        Plants plants = plantsRepsitory.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant with id " + id + " not found"));
        return ResponseEntity.ok(plants);

    }

    //Uppdatera information om en växt
    @PutMapping("/{id}")
    public ResponseEntity <Plants> updatePlant(@PathVariable String id, @RequestBody Plants plants) {
        Plants existingPlant = plantsRepsitory.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant with id " + id + " not found"));


        if (plants.getPlantName() != null) {
            existingPlant.setPlantName(plants.getPlantName());
        }
        if (plants.getPlantSize() != null) {
            existingPlant.setPlantSize(plants.getPlantSize());
        }
        if (plants.getPlantType() != null) {
            existingPlant.setPlantType(plants.getPlantType());
        }
        if (plants.getPlantLightNeeds() != null) {
            existingPlant.setPlantLightNeeds(plants.getPlantLightNeeds());
        }
        if (plants.getPlantWaterNeeds() != null) {
            existingPlant.setPlantWaterNeeds(plants.getPlantWaterNeeds());
        }
        if (plants.getPlantDifficulty() != null) {
            existingPlant.setPlantDifficulty(plants.getPlantDifficulty());
        }
        if (plants.getPlantTrade() != null) {
            existingPlant.setPlantTrade(plants.getPlantTrade());
        }
        if (plants.getPlantPrice() != null) {
            existingPlant.setPlantPrice(plants.getPlantPrice());
        }
        if (plants.getPlantPicture() != null) {
            existingPlant.setPlantPicture(plants.getPlantPicture());
        }
        if (plants.getPlantStatus() != null) {
            existingPlant.setPlantStatus(plants.getPlantStatus());
        }
            Plants updatedPlant = plantsRepsitory.save(existingPlant);
            return ResponseEntity.ok(updatedPlant);
    }


    //Ta bort en växtannons
    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> deletePlant(@PathVariable String id) {
        if (!plantsRepsitory.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant with id " + id + " not found");
        }
        plantsRepsitory.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    //Hämta endast tillgängliga växter
    @GetMapping("/available")
    public  List<Plants> getAvailablePlants() {
        return plantsRepsitory.findByPlantStatus(PlantStatus.AVAILABLE);
    }











}
