package com.example.apprenti.service;

import com.example.apprenti.entity.Product;
import com.example.apprenti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProductByLabel(String label) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProductByDescription(String description) {
        return Optional.empty();
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteById(UUID uuid) {
        return null;
    }

    @Override
    public Product deleteByName(String name) {
        return null;
    }
}
