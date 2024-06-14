package com.example.apprenti.controllers;


import com.example.apprenti.entity.Product;
import com.example.apprenti.repository.ProductRepository;
import com.example.apprenti.service.ProductService;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct(){
        var listProduct = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }

    @GetMapping("/{id}")
    //TODO voir le UUID si possible de recup ou non
    public ResponseEntity<Product> findProductById(@PathVariable UUID id){
        return null;
    }

    @GetMapping("/{label}")
    public ResponseEntity<Product> findPRoductByLabel(@PathVariable String label){
        Optional<Product> product = productService.getProductByLabel(label);
        return product.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(product.get());
    }



}
