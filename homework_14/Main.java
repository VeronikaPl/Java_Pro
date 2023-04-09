import java.util.List;

public class Main {
    public static void main(String[] args) {
        List wordsList = ArrayTasks.createListArray();
        System.out.println("Array: " + wordsList);
        System.out.println("Word \"" + wordsList.get(0) + "\" repeat " + ArrayTasks.countOccurance(wordsList, wordsList.get(0).toString()) + " times");

        Integer[] ints = {3, 1, 1, 3, 7, 5, 8, 2, 7};
        List<Integer> convertToList = ArrayTasks.toList(ints);
        System.out.println("List: " + convertToList);
        System.out.println(ArrayTasks.findUnique(convertToList));

        ArrayTasks.calcOccurance(wordsList);
        System.out.println(ArrayTasks.findOccurance(wordsList));
    }
}