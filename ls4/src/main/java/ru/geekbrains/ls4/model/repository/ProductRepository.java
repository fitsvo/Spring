package ru.geekbrains.ls4.model.repository;

import ru.geekbrains.ls4.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductRepository{
    private final Map<Integer, Product> db = new HashMap<>();

    {
        Product product = new Product();
        product.setId(db.size() + 1);
        product.setTitle("Egg");
        product.setPrice(90);
        db.put(product.getId(), product);
    }
    {
        Product product = new Product();
        product.setId(db.size() + 1);
        product.setTitle("Milk");
        product.setPrice(70);
        db.put(product.getId(), product);
    }
    {
        Product product = new Product();
        product.setId(db.size() + 1);
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
        product.setId(db.size() + 1);
        db.put(product.getId(), product);
    }
}
