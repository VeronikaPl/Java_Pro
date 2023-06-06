import java.util.Arrays;
import java.util.logging.Logger;

public class ValueCalculator {
    private static final Logger LOGGER = Logger.getLogger(ValueCalculator.class.getName());
    private double[] array;
    private int size;
    private int halfSize;

    public ValueCalculator(int size) {
        if (size < 1_000_000) {
            throw new IllegalArgumentException("Size can't be less than 1 000 000");
        }
        this.array = new double[size];
        this.size = size;
        this.halfSize = size / 2;
    }

    public synchronized void run() {
        long start = System.currentTimeMillis();

        Arrays.fill(array, 1);

        double[] arr1 = new double[halfSize];
        double[] arr2 = new double[halfSize];

        System.arraycopy(array, 0, arr1, 0, halfSize);
        System.arraycopy(array, halfSize, arr2, 0, halfSize);

        Thread thread1 = new Thread(new RefactorArrayValues(arr1));
        Thread thread2 = new Thread(new RefactorArrayValues(arr2));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.arraycopy(arr1, 0, array, 0, halfSize);
        System.arraycopy(arr2, 0, array, halfSize, halfSize);

        long end = System.currentTimeMillis();

        LOGGER.info("Time: " + (end - start));
    }
}