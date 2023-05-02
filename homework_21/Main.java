import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = getProducts();
        System.out.println(ProductMethods.getBookWithPriceOver250(productList));
        System.out.println(ProductMethods.getBookWithDiscount(productList));
        System.out.println(ProductMethods.getCheapestBook(productList));
        System.out.println(ProductMethods.getLastThreeProducts(productList));
        System.out.println("Total price: " + ProductMethods.getTotalPrice(productList));
        System.out.println(ProductMethods.groupProductsByCategory(productList));
    }

    private static List<Product> getProducts() {
        return new ArrayList<>(
                Arrays.asList(
                        new Product(1625, ProductType.BOOK, 300, false, LocalDate.of(2022, 02, 24)),
                        new Product(1616, ProductType.BOOK, 80, true, LocalDate.of(2023, 03, 25)),
                        new Product(1523, ProductType.TOY, 50, false, LocalDate.of(2021, 12, 30)),
                        new Product(1982, ProductType.TOY, 350, true, LocalDate.of(2023, 04, 19)),
                        new Product(1824, ProductType.BOOK, 330, true, LocalDate.now())
                )
        );
    }
}
