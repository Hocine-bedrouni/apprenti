package com.example.apprenti.service;

import com.example.apprenti.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<AppUser> getAllUser();

    Optional<AppUser> getUserById(Long id);

    AppUser getUserByName(String name);

    AppUser getUserByFirstName(String firstName);
}
