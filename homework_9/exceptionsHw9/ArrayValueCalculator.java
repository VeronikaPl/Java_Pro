package exceptionsHw9;

public class ArrayValueCalculator {
    public static int doCalc(String[][] matrix) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i].length != 4 || matrix[j].length != 4) {
                    throw new ArraySizeException("Array's size must be 4x4!");
                }

                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in [" + (i + 1) + "][" + (j + 1) + "] cell! Please check it and input only numbers");
                }
            }
        }
        return sum;
    }
}
