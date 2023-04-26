import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PetrolStation {
    private int amount;
    private final Lock lock = new ReentrantLock();

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int doRefuel(int requestedAmount) {
        lock.lock();
        try {
            if (amount < requestedAmount) {
                throw new IllegalArgumentException("There is NOT enough fuel");
            } else {
                TimeUnit.SECONDS.sleep((long) Math.random() * 7 + 3);
                amount -= requestedAmount;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return amount;
    }
}
