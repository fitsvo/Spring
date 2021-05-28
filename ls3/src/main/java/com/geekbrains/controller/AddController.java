package com.geekbrains.controller;

import com.geekbrains.model.entity.Product;
import com.geekbrains.model.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class AddController {
    ProductRepository productRepository = new ProductRepository();

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(Product product) {
        productRepository.save(product);
        return "addProduct";
    }
}
