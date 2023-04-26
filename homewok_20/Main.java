import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(150);

        FuelRequests fuelRequests1 = new FuelRequests(petrolStation, 20);
        FuelRequests fuelRequests2 = new FuelRequests(petrolStation, 30);
        FuelRequests fuelRequests3 = new FuelRequests(petrolStation, 50);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            executorService.invokeAll(List.of(fuelRequests1, fuelRequests2, fuelRequests3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The rest of the fuel is: " + petrolStation.getAmount());
    }
}
