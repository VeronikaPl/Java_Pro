package coffee.order;

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
}
