package org.spring_framework;

import org.spring_framework.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> cartProducts;

    public Cart() {
        cartProducts = new ArrayList<>();
    }

    public void addProductByID(ProductRepository repository, int id) {
        Objects.requireNonNull(id);
        Product addProduct = repository.getProductByID(id);
        cartProducts.add(addProduct);
    }

    public void removeProductByID(int id) {
        Objects.requireNonNull(id);
        for (int i = 0; i < cartProducts.size(); i++) {
            Product product = cartProducts.get(i);
            if (product != null && product.getId() == id) {
                cartProducts.remove(i);
            }
        }
    }

    public List<Product> getCartProducts() {
        return cartProducts;
    }
}
