package ru.geekbrains.ls4.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.ls4.model.entity.Product;
import ru.geekbrains.ls4.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class AddController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product")
    public String create(@ModelAttribute Product product, Model model) {
        productRepository.save(product);
        model.addAttribute("product", product);
        return "redirect:/product";
    }
}
