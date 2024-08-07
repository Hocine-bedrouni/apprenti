package com.example.apprenti.controllers;

import com.example.apprenti.entity.Product;
import com.example.apprenti.service.ProductService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;



    @Test
    void findAllProduct() {
        List<Product>resultListProd = new ArrayList<>();
        Product product = new Product(4L, "Marmite", "Parfaite pour la soupe" );
        Product product2 = new Product(5L, "Casserole", "pour faire bouillir" );
        resultListProd.add(product);
        resultListProd.add(product2);
        when(productService.getAllProduct()).thenReturn(resultListProd);

        ResponseEntity<List<Product>> response = productController.findAllProduct();

        assertEquals(resultListProd, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findProductById() {
        Product product = new Product(4L, "Marmite", "Parfaite pour la soupe" );
       Optional<Product> optionalProduct= Optional.of(product);
        when(productService.getProductById(anyLong())).thenReturn(optionalProduct);

        ResponseEntity<Product> response = productController.findProductById(88L);

//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void findPRoductByLabel() {
    }
}