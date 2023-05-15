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

    public void add(String customer) {
        Objects.requireNonNull(customer);
        orderList.add(new Order(naturalOrdering++, customer));
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

    public String draw() {
        String result = "";
        for (Order order : orderList) {
            result += order.getNumberOrder() + " | " + order.getNameCustomer() + "\n";
        }
        return "\tCurrent queue:\n" + result;
    }
}
