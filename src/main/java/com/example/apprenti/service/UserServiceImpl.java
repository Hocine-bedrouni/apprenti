package com.example.apprenti.service;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
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
    public AppUser getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public AppUser getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
