import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductMethods {
    public static List<Product> getBookWithPriceOver250(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getBookWithDiscount(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.isDiscount())
                .peek(product -> product.setPrice(product.getPrice() * 0.9))
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(Product::isBook)
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new IllegalArgumentException("Продукт [категорія: Book] не знайдено"));
    }

    public static List<Product> getLastThreeProducts(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .skip(products.size() - 3)
                .collect(Collectors.toList());
    }

    public static double getTotalPrice(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.getLocalDate().getYear() == LocalDate.now().getYear()
                        && product.isBook() && product.getPrice() <= 75)
                .mapToDouble(Product::getPrice).sum();
    }

    public static Map<ProductType, List<Product>> groupProductsByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
