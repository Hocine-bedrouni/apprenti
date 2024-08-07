package com.example.apprenti.service;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<AppUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<AppUser> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<AppUser> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public AppUser addUser(AppUser appUser) throws Exception {
        if (appUser.getName() != null && appUser.getFirstName() != null) {
            return this.userRepository.save(appUser);
        } else throw new RuntimeException("Missing user info");

    }


    @Override
    public AppUser updateUser(AppUser appUser) {
        var user = this.userRepository.findById(appUser.getId())
                .orElseThrow(() -> new RuntimeException("D'oesnt exist"));
        user.setName(appUser.getName());
        user.setFirstName(appUser.getFirstName());
        user.setRoles(appUser.getRoles());
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        if (getUserById(id).isEmpty()) {
            throw new RuntimeException("User with id :" + id + " was not found");
        }
        this.userRepository.deleteById(id);
        log.warn("You just delete the user : " + id + ".");
    }


}
