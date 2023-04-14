package coffee.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoffeeOrderBoard {
    private List<Order> orderList = new ArrayList<>();
    int naturalOrdering;

    public CoffeeOrderBoard() {
        naturalOrdering = 1;
    }

    public void add(String nameCustomer) {
        Objects.requireNonNull(nameCustomer);
        orderList.add(new Order(naturalOrdering++, nameCustomer));
    }

    public void deliver() {
        if (orderList.isEmpty()) {
            throw new ArrayStoreException("Queue is empty");
        } else {
            orderList.remove(0);
        }
    }

    public void deliver(int numberOrder) {
        if (orderList.isEmpty()) {
            throw new ArrayStoreException("Queue is empty");
        } else {
            for (Order order : orderList) {
                if (order.getNumberOrder() == numberOrder) {
                    orderList.remove(order);
                    return;
                }
            }
            throw new ArrayStoreException("Order " + numberOrder + " doesn't exist");
        }
    }

    public void draw() {
        System.out.println("\tCurrent queue:");
        for (Order order : orderList) {
            System.out.println(order.getNumberOrder() + " | " + order.getNameCustomer());
        }
    }
}
