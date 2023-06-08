import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(500);

        List<FuelRequests> requests = new ArrayList<>();
        requests.add(new FuelRequests(petrolStation, 20));
        requests.add(new FuelRequests(petrolStation, 30));
        requests.add(new FuelRequests(petrolStation, 50));
        requests.add(new FuelRequests(petrolStation, 10));
        requests.add(new FuelRequests(petrolStation, 50));
        requests.add(new FuelRequests(petrolStation, 20));
        requests.add(new FuelRequests(petrolStation, 20));
        requests.add(new FuelRequests(petrolStation, 60));
        requests.add(new FuelRequests(petrolStation, 10));
        requests.add(new FuelRequests(petrolStation, 40));

        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        try {
            executorService.invokeAll(requests);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("The rest of the fuel is: " + petrolStation.getAmount());
        executorService.shutdown();
    }
}
