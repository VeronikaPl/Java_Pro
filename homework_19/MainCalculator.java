public class MainCalculator {
    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator(1_200_300);
        System.out.println("Time: " + valueCalculator.countTime());
    }
}
