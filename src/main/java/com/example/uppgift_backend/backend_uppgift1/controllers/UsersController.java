package com.example.uppgift_backend.backend_uppgift1.controllers;

import com.example.uppgift_backend.backend_uppgift1.repsitories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;




}
