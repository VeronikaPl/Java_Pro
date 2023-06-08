import java.util.Collection;
import java.util.concurrent.Callable;

public class FuelRequests implements Callable<Integer> {
    private PetrolStation petrolStation;
    private int requestedAmount;

    public FuelRequests(PetrolStation petrolStation, int requestedAmount) {
        this.petrolStation = petrolStation;
        this.requestedAmount = requestedAmount;
    }

    @Override
    public Integer call() {
        return petrolStation.doRefuel(requestedAmount);
    }
}