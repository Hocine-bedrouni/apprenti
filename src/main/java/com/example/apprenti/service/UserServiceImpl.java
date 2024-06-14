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
public class UserServiceImpl implements UserService{

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
       } else throw new Exception("missing user info");

    }



    @Override
    public AppUser updateUser(Long id, AppUser appUser) {
         return this.userRepository.findById(id).map(user ->{
             if (user.getName() != null)
                 user.setName(appUser.getName());
             if(user.getFirstName() != null)
                 user.setFirstName(appUser.getFirstName());
             return this.userRepository.save(user);
//             if(user.getRoles() != null)
//                 List<Role> roleList = appUser.getRoles().add();
//                 user.setRoles(roleList);
//                 TODO role et avec optional
         }
         ).orElseThrow(()-> new RuntimeException("User with id :" +id+ " was not found"));
    }

    @Override
    public void deleteUser(Long id) {
      if (getUserById(id).isEmpty()){
          throw new RuntimeException("User with id :" +id+ " was not found");
      }
        this.userRepository.deleteById(id);
        log.warn("You just delete the user : " +id+ "." );

    }


}
