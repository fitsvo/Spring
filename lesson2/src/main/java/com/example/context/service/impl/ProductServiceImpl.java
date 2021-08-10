package com.example.context.service.impl;

import com.example.context.domain.Product;
import com.example.context.repository.ProductRepository;
import com.example.context.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getProducts() {
        return productRepository.getProductRepository();
    }
}
