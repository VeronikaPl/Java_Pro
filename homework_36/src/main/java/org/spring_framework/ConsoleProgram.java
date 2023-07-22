package org.spring_framework;

import org.spring_framework.entity.Product;
import org.spring_framework.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ConsoleProgram {
    private final Cart cart;
    private final LoggingService logger;

    @Autowired
    public ConsoleProgram(Cart cart, LoggingService logger) {
        this.cart = cart;
        this.logger = logger;
    }

    public void startConsoleProgram(ProductRepository productRepository) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int inputValue;
            do {
                logger.log("1. Add product to cart\n" +
                        "2. Delete product from cart\n" +
                        "3. Show cart\n" +
                        "4. Exit\n" +
                        "Choose: ");
                inputValue = Integer.parseInt(reader.readLine());
                switch (inputValue) {
                    case 1: {
                        logger.log("Input ID to add product to cart: ");
                        int productID = Integer.parseInt(reader.readLine());
                        cart.addProductByID(productRepository, productID);
                        break;
                    }
                    case 2: {
                        logger.log("Input ID to delete product from cart: ");
                        int productID = Integer.parseInt(reader.readLine());
                        cart.removeProductByID(productID);
                        break;
                    }
                    case 3:
                        logger.log("Cart:");
                        for (Product product : cart.getCartProducts()) {
                            logger.log(product.getId() + ": " + product.getName() + " - " + product.getPrice());
                        }
                        break;
                    case 4: {
                        logger.log("Exiting program...");
                        break;
                    }
                    default:
                        logger.log("Wrong input! Choose 1, 2, 3 or 4.");
                }
            } while (inputValue != 4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}