package ru.geekbrains.ls4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.ls4.model.entity.Product;
import ru.geekbrains.ls4.model.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class CatalogController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/catalog")
    public String index(Model model){
        List<Product> productList = productRepository.getAll();
        model.addAttribute("productList", productList);
        return "catalog";
    }
}
