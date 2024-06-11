package com.example.apprenti;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.entity.Role;
import com.example.apprenti.repository.RoleRepository;
import com.example.apprenti.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApprentiApplication {



    @Bean
    public CommandLineRunner affiche(UserRepository userRepository, RoleRepository roleRepository){


        return arg -> {

            var appUser = new AppUser();
            appUser.setName("Momo");
            appUser.setFirstName("Le clodo");

            Role role = new Role();
            role.setRoleName("Admin");

            Role savedRole = roleRepository.save(role);
            List<Role> roleList = new ArrayList<>();
            roleList.add(savedRole);

            appUser.setRoles(roleList);
            userRepository.save(appUser);

        };
    }

    public static void main (String[] args) {
        SpringApplication.run(ApprentiApplication.class, args);

    }

}
