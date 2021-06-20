package com.sda.traianszabi.online_library.controller;

import com.sda.traianszabi.online_library.model.User;
import com.sda.traianszabi.online_library.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
     private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userService.userExist(user.getLogin())) {
            return ResponseEntity.badRequest().build();
        }
        userService.createUser(user);
        return ResponseEntity.ok("User succesfully created , you are the best progrmammer !");
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

}
