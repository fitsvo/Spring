package com.geekbrains.controller;


import com.geekbrains.model.entity.Product;
import com.geekbrains.model.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class WelcomeController {
    ProductRepository productRepository = new ProductRepository();

    @GetMapping("/catalog")
    public String index(Model model){
        List<Product> productList = productRepository.getAll();
        model.addAttribute("product", productList);
        return "catalog";
    }
}
