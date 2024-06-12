package com.example.apprenti.controllers;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
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

        //TODO faire en Response Entity
    }


    @GetMapping("/user/{name}")
    public ResponseEntity<AppUser> findByname(@PathVariable String name) {
        AppUser user = userService.getUserByName(name);
        log.info("user : {},{},{}", user, user.getName(), user.getId());
        return ResponseEntity.status(HttpStatus.OK).body(user);
        //TODO si je trouve as le user
    }


}
