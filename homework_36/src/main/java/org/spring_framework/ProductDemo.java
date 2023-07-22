package org.spring_framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleProgram consoleProgram = context.getBean(ConsoleProgram.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        consoleProgram.startConsoleProgram(productRepository);
    }
}
