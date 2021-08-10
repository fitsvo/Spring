package com.example.context;

import com.example.context.configuration.AppConfig;
import com.example.context.domain.Product;
import com.example.context.repository.Cart;
import com.example.context.repository.ProductRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            /*ProductService productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
            System.out.println(productService.getProducts());

            Product simpleProduct = context.getBean("simpleProduct", Product.class);
            System.out.println(simpleProduct.getId());*/

            //Массив с продуктами из которого создается репозиторий
            Product[] productRepository = {
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class),
                    context.getBean(Product.class)
            };
            System.out.println(Arrays.toString(productRepository));

            ProductRepositoryImpl productList = context.getBean("productRepository", ProductRepositoryImpl.class);
//заполняем репозиторий продуктами (не более пяти)
            ArrayList<Integer> arrId = new ArrayList<>();
            while (productList.size() < 5)
            {
                int id =(int) (Math.random() * productRepository.length);
                if (!arrId.contains(id)) {
                    productRepository[id].setId(productList.size() + 1);
                    productList.add(productRepository[id]);
                    arrId.add(id);
                }
            }

            Cart cart = context.getBean("cart",Cart.class);

            while (true) {
                System.out.println("Set action:");
                Scanner n = new Scanner(System.in);
                String line = n.nextLine();
                while (!line.equals("end")) {
                    if (line.equals("list")) {
                        System.out.println("List of products:");
                        productList.all();
                        break;
                    }

                    if (line.contains("get "))
                        for(int j = 0; j < productList.size() + 1; j++)
                            if ( Integer.parseInt(line.split(" ")[1]) == j-1){
                                productList.get(j).getProduct();
                                break;
                            }


                    if (line.contains("cart")){
                        if (line.contains("add"))
                            for(int j = 0; j < productList.size() ; j++)
                                if ( Integer.parseInt(line.split(" ")[2]) == j){
                                    cart.add(productList.get(j));
                                    System.out.println("Put in cart product:" + productList.get(j).getTitle());
                                    break;
                                }
                        if (line.equals("cart list")){
                            System.out.println("In your cart:");
                            cart.all();
                            break;
                        }
                    }

                    break;
                }
                if (line.equals("end")) break;
            }
        };
}
