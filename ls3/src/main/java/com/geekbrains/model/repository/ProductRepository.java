package com.geekbrains.model.repository;

import com.geekbrains.model.entity.Product;
import java.util.*;

public class ProductRepository{
    private final Map<Integer, Product> db = new HashMap<>();

    {
        Product product = new Product();
        product.setId(1);
        product.setTitle("Egg");
        product.setPrice(90);
        db.put(product.getId(), product);
    }
    {
        Product product = new Product();
        product.setId(2);
        product.setTitle("Milk");
        product.setPrice(70);
        db.put(product.getId(), product);
    }
    {
        Product product = new Product();
        product.setId(3);
        product.setTitle("Bread");
        product.setPrice(50);
        db.put(product.getId(), product);
    }

    public Product getById(int id){
        return db.get(id);
    }

    public List<Product> getAll(){
        return new ArrayList<Product>(db.values());
    }

    public void save(Product product) {
        db.put(product.getId(), product);
    }
}
