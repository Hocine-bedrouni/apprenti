package com.example.apprenti.service;

import com.example.apprenti.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ProductService {

    List<Product> getAllProduct();

    Optional<Product> getProductById(String id);

    Optional<Product> getProductByLabel(String label);

    Optional<Product> getProductByDescription(String description);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Product deleteById(UUID uuid);

    Product deleteByName(String name);





}
