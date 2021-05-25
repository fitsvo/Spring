package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Random;

@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
public class BasicServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        resp.getWriter().printf("<h1>Welcome to product's pool</h1>");
        resp.getWriter().printf("<h1>Id     Product     Cost</h1>");
        Random rand = new Random();
        String[] products = {"Melon", "Lime", "Pumpkin", "Peach", "Beans", "Cucumber", "Tomato", "Lemon", "Potato", "Carrot"};

        for (int i = 0; i < 10; i++) {
            int cost = rand.nextInt(50 * (i + 1));
            Products product = new Products(products[i], cost);
            product.setId(i + 1);

            resp.getWriter().printf("<h1>%d.  %s  %s</h1>", product.getId(), product.getTitle(), product.getCost());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");

        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}

