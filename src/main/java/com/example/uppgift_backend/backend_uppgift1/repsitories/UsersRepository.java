package com.example.uppgift_backend.backend_uppgift1.repsitories;

import com.example.uppgift_backend.backend_uppgift1.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
}
