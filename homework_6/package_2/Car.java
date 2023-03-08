package package_2;

public class Car {
    private void startElectricity(){
        System.out.println("Start electricity");
    }
    private void startCommand(){
        System.out.println("Start command");
    }
    private void startFuelSystem(){
        System.out.println("Start fuel system");
    }
    public void start(){
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Start class car!");
    }
}
