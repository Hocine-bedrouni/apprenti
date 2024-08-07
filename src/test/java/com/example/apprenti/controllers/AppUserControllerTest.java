package com.example.apprenti.controllers;

import com.example.apprenti.entity.AppUser;
import com.example.apprenti.service.UserService;

import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private AppUserController appUserController;

    @BeforeEach
    void setUp() {
//       userService = mock(UserService.class);
//       appUserController = new AppUserController(userService);


    }

    @Test
    void findAllUsers() {

        List<AppUser> resultList = new ArrayList<>();
        AppUser user = new AppUser(2L, "Toto", "Lino", new ArrayList<>());
        resultList.add(user);
        when(userService.getAllUser()).thenReturn(resultList);
//        when(userService.getUserById(anyLong())).thenReturn(resultList);

        var result = appUserController.findAllUsers();

        assertEquals(resultList, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void findUserById() {

        AppUser user = new AppUser(1L,"Titi", "Poo",new ArrayList<>());
        var option = Optional.of(user);
        when(userService.getUserById(anyLong())).thenReturn(option);

        ResponseEntity<AppUser> responseUser = appUserController.findUserById(48L);

        assertEquals(option.get(), responseUser.getBody());
    }

    @Test
    void findUserByIdNotFound() {

        Optional<AppUser> option = Optional.empty();
        when(userService.getUserById(anyLong())).thenReturn(option);

        ResponseEntity<AppUser> responseUser = appUserController.findUserById(1L);

        assertEquals(HttpStatus.NOT_FOUND, responseUser.getStatusCode());
    }

    @Test
    void findByname() {
        AppUser user = new AppUser(1L,"Titi", "Poo",new ArrayList<>());
        Optional<AppUser> userOptional = Optional.of(user);
        when(userService.getUserByName(anyString())).thenReturn(userOptional);

        ResponseEntity<AppUser> userResponseEntity = appUserController.findByname("Cloclo");

        assertEquals(userOptional.get(), userResponseEntity.getBody());

    }

    @Test
    void findByfirstName() {
    }
}