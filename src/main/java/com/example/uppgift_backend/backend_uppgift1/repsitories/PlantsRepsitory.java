package com.example.uppgift_backend.backend_uppgift1.repsitories;

import com.example.uppgift_backend.backend_uppgift1.models.Plants;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantsRepsitory extends MongoRepository<Plants, String> {
}
