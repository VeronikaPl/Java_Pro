package package_2;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Start class car!");
    }

    private void startElectricity() {
        System.out.println("Start electricity");
    }

    private void startCommand() {
        System.out.println("Start command");
    }

    private void startFuelSystem() {
        System.out.println("Start fuel system");
    }
}
