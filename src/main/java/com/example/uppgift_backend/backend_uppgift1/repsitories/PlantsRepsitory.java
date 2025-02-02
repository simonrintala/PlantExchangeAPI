package com.example.uppgift_backend.backend_uppgift1.repsitories;

import com.example.uppgift_backend.backend_uppgift1.PlantStatus;
import com.example.uppgift_backend.backend_uppgift1.models.Plants;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlantsRepsitory extends MongoRepository<Plants, String> {
    List<Plants> findByPlantStatus (PlantStatus plantStatus);
    //gjorde samma sak här som i transaction för det fungerade.
}
