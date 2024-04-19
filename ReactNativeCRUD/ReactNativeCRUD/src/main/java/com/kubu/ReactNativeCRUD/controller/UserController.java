package com.kubu.ReactNativeCRUD.controller;


import com.kubu.ReactNativeCRUD.domain.User;
import com.kubu.ReactNativeCRUD.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;




@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> createContact(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.createUser(user));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getContact(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }






}