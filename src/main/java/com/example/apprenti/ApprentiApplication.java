package com.example.apprenti;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.entity.Product;
import com.example.apprenti.entity.Role;
import com.example.apprenti.repository.ProductRepository;
import com.example.apprenti.repository.RoleRepository;
import com.example.apprenti.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@Slf4j
public class ApprentiApplication {



    @Bean
    public CommandLineRunner affiche(UserRepository userRepository, RoleRepository roleRepository, ProductRepository productRepository){


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

            var prod = new Product();
            prod.setLabel("Coconut");
            prod.setDescription("hairy ball");

            var p2 = productRepository.save(prod);
            var p4 = productRepository.findById(p2.getId());
             if (Objects.equals(p2.getId(), p4.get().getId())){
                 log.warn("tutu");
             } else {
                 log.warn("toto");
             }

            log.info(p2.getLabel());
            log.info(appUser.getName());
        };
    }

    public static void main (String[] args) {
        SpringApplication.run(ApprentiApplication.class, args);

    }

}
