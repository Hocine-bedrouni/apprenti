package com.example.apprenti.service;

import com.example.apprenti.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<Product> getAllProduct();

    Optional<Product> getProductById(String id);

    Optional<Product> getProductByLabel(String label);

    Optional<Product> getProductByDescription(String description);

    Product addProduct(Product product) throws Exception;

    Product updateProduct(String id, Product product);

    void deleteById(String id);







}
