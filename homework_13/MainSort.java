import java.util.Arrays;

public class MainSort {
    public static void main(String[] args) {
        int[] sortNumbers = new int[]{9, 4, 2, 7, 1, 8, 3};
        int[] resBubbleSort = BubbleSort.bubbleSort(sortNumbers);
        System.out.println("Bubble sort: " + Arrays.toString(resBubbleSort));

        int[] sortNum = new int[]{9, 4, 2, 7, 1, 8, 3};
        int[] resInsertionSort = InsertionSort.insertionSort(sortNum);
        System.out.println("Insertion sort: " + Arrays.toString(resInsertionSort));
    }
}
