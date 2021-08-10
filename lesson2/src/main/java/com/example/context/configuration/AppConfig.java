package com.example.context.configuration;

import com.example.context.repository.Cart;
import com.example.context.domain.Product;
import com.example.context.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"com.example.context.repository", "com.example.context.service"})
public class AppConfig {

    @Bean
    public ProductRepositoryImpl productRepository(){
        return new ProductRepositoryImpl();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Product simpleProduct(){
        String[] name = {
                "Огурцы","Сыр", "Молоко", "Йогурт","Хлеб","Конфеты","Чай", "Курица", "Лук", "Тунец","Кефир"};
        Integer[] cost = {50, 100, 54, 23, 28, 12, 60, 45, 120};
        return new Product(name[(int) (Math.random() * name.length)],
                cost[(int) (Math.random() * cost.length)]);
    }


    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Cart cart(){
        return new Cart();
    }
}
