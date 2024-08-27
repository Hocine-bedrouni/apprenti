package com.example.apprenti.controllers;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Slf4j
public class AppUserController {

    private final UserService userService;


    @Autowired
    public AppUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> findAllUsers() {
        var listuser = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(listuser);
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<AppUser> findUserById(@PathVariable Long id) {
        var tt = userService.getUserById(id);
        if (tt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(tt.get());
        }
    }


    @GetMapping("/user/{name}")
    public ResponseEntity<AppUser> findByname(@PathVariable String name) {
        Optional<AppUser> user = userService.getUserByName(name);
        //  log.info("user : {},{},{}", user, user.get(), user.isEmpty());
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/firstname/{firstName}")
    public ResponseEntity<AppUser> findByfirstName(@PathVariable String firstName) {
        Optional<AppUser> user = userService.getUserByFirstName(firstName);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/user/add")
    public ResponseEntity<AppUser> addUser(@Validated @RequestBody AppUser appUser) {
        //TODO Verif validated and to finish
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.addUser(appUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
