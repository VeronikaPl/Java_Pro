import coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("John");
        coffeeOrderBoard.add("Ann");
        coffeeOrderBoard.add("Lily");
        coffeeOrderBoard.add("Abby");
        coffeeOrderBoard.add("Nick");

        System.out.println(coffeeOrderBoard.draw());

        coffeeOrderBoard.deliver();
        System.out.println(coffeeOrderBoard.draw());

        coffeeOrderBoard.deliver(5);
        System.out.println(coffeeOrderBoard.draw());

        coffeeOrderBoard.add("Josh");
        System.out.println(coffeeOrderBoard.draw());
    }
}
