import coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("John");
        coffeeOrderBoard.add("Ann");
        coffeeOrderBoard.add("Lily");
        coffeeOrderBoard.add("Abby");
        coffeeOrderBoard.add("Nick");

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(5);
        coffeeOrderBoard.draw();

        coffeeOrderBoard.add("Josh");
        coffeeOrderBoard.draw();
    }
}
