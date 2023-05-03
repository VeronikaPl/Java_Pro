import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private int id;
    private ProductType type;
    private double price;
    private boolean discount;
    private LocalDate createdAt;

    public Product(int id, ProductType type, double price, boolean discount, LocalDate createdAt) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public boolean isBook() {
        return getType() == ProductType.BOOK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDate getLocalDate() {
        return createdAt;
    }

    public void setLocalDate(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && discount == product.discount && type == product.type && Objects.equals(createdAt, product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price, discount, createdAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", discount=" + discount +
                ", localDate=" + createdAt +
                '}' + '\n';
    }
}
