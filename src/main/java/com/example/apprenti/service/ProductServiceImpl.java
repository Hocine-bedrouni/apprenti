package com.example.apprenti.service;

import com.example.apprenti.entity.Product;
import com.example.apprenti.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByLabel(String label) {
        return productRepository.findByLabel(label);
    }

    @Override
    public Optional<Product> getProductByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        if (product.getLabel() != null) {
            return this.productRepository.save(product);
        } else throw new RuntimeException("Missing product info");
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return this.productRepository.findById(id).map(prod -> {
                    if (prod.getLabel() != null)
                        prod.setLabel(product.getLabel());
                    if (prod.getDescription() !=null)
                        prod.setDescription(product.getDescription());
                    return this.productRepository.save(prod);
                }
        ).orElseThrow(()->new RuntimeException("Product with id :" +id+ " was not found"))      ;
    }

    @Override
    public void deleteById(Long id) {
        if (getProductById(id).isPresent()){
            this.productRepository.deleteById(String.valueOf(id));
            log.warn("You just delete the product : " +id+ "." );
        } throw new RuntimeException("User with id :" +id+ " was not found");
    }

}
