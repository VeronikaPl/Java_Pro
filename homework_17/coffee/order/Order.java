package coffee.order;

import java.util.Objects;

public class Order {
    private int numberOrder;
    private String nameCustomer;

    public Order(int numberOrder, String nameCustomer) {
        this.numberOrder = numberOrder;
        this.nameCustomer = nameCustomer;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return numberOrder == order.numberOrder && Objects.equals(nameCustomer, order.nameCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOrder, nameCustomer);
    }
}
