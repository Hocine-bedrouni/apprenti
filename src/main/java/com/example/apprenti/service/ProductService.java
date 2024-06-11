package com.example.apprenti.service;

import com.example.apprenti.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct();

    Optional<Product> getProductById(String id);

    Product getProductByLabel(String label);


}
