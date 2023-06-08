import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class PetrolStation {
    private final Semaphore SEMAFORE = new Semaphore(3, true);
    private static final Logger LOGGER = Logger.getLogger(PetrolStation.class.getName());
    private int amount;

    public int getAmount() {
        return amount;
    }

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public int doRefuel(int requestedAmount) {
        try {
            SEMAFORE.acquire();
            synchronized (this) {
                if (amount < requestedAmount) {
                    LOGGER.warning("There is NOT enough fuel");
                } else {
                    TimeUnit.SECONDS.sleep((long) (Math.random() * 7) + 3);
                    amount -= requestedAmount;
                }
            }
            SEMAFORE.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }
}
