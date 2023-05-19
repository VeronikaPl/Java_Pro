import annotations.AfterSuit;
import annotations.BeforeSuite;
import annotations.Test;

public class TestClass {
    @BeforeSuite
    public static void beforeSuitMethod() {
        System.out.println("Call BeforeSuit method");
    }

    @Test(priority = 7)
    public static void test1() {
        System.out.println("Call Test #1 - priority = 7");
    }

    @Test(priority = 1)
    public static void test2() {
        System.out.println("Call Test #2 - priority = 1");
    }

    @Test(priority = 9)
    public static void test3() {
        System.out.println("Call Test #3 - priority = 9");
    }

    @AfterSuit
    public static void afterSuitMethod() {
        System.out.println("Call AfterSuit method");
    }
}