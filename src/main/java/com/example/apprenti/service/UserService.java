package com.example.apprenti.service;

import com.example.apprenti.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<AppUser> getAllUser();

    Optional<AppUser> getUserById(Long id);

    Optional<AppUser> getUserByName(String name);

    Optional<AppUser> getUserByFirstName(String firstName);

    AppUser addUser(AppUser appUser) throws Exception;

    AppUser updateUser(AppUser appUser);

    void deleteUser(Long id);




}
