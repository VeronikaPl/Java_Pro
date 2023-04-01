public class InsertionSort {
    static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insert = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > insert) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = insert;
        }
        return array;
    }
}
