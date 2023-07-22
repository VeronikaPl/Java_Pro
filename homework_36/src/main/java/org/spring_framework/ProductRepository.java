package org.spring_framework;

import org.spring_framework.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
        products.add(new Product(192, "apple", 12.3));
        products.add(new Product(214, "pear", 14));
        products.add(new Product(116, "cherry", 10.5));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByID(int id) {
        for (Product product : products) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }
}
