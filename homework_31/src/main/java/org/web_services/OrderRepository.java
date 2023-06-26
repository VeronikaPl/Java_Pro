package org.web_services;

import org.springframework.stereotype.Repository;
import org.web_services.entity.Order;

import java.util.*;

@Repository
public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public Order getOrderById(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("ID cannot be less or equal 0");
        } else {
            return this.orders.get(id);
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        Objects.requireNonNull(order);
        this.orders.add(order);
    }
}
