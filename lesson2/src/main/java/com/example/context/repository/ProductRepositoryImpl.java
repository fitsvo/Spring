package com.example.context.repository;

import com.example.context.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    public List<Product> getProductRepository() {
        return new ArrayList<>(Collections.singletonList(new Product("Potato", 12 )));
    }

    private final ArrayList<Product> ProductRepositoryImpl;

    public ProductRepositoryImpl(){
        this.ProductRepositoryImpl = new ArrayList<Product>();
    }

    public int size(){
        return this.ProductRepositoryImpl.size();
    }

    public Product get(int id){
        return this.ProductRepositoryImpl.get(id);
    }

    public void all(){
        for (Product product : this.ProductRepositoryImpl) {
            System.out.printf("%s. %s %s;", product.getId(),
                    product.getTitle(),
                    product.getCost());
            System.out.println();
        }
    }

    public void add(Product product) {
        this.ProductRepositoryImpl.add(product);
    }

    protected void remove(int id) {
        this.ProductRepositoryImpl.remove(id);
    }
}
