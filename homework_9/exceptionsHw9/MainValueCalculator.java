package exceptionsHw9;

public class MainValueCalculator {
    public static void main(String[] args) throws ArrayDataException, ArraySizeException {
        String[][] array = {
                {"2", "5", "2", "6"},
                {"1", "17", "4", "3"},
                {"21", "8", "9", "10"},
                {"12", "7", "8", "4"}
        };

        System.out.println("Sum of array is " + ArrayValueCalculator.doCalc(array));
    }
}
