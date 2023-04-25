import java.util.*;

public class ArrayTasks {
    public static int countOccurance(List<String> words, String str) {
        int count = 0;
        for (String word : words) {
            if (word.equals(str)) {
                count++;
            }
        }
        return count;
    }

    public static List createListArray() {
        List<String> words = new ArrayList<>();
        words.add("ball");
        words.add("floor");
        words.add("wall");
        words.add("ball");
        words.add("table");
        words.add("table");
        words.add("chair");
        words.add("wall");
        words.add("wall");
        return words;
    }

    public static <T> List<T> toList(T[] arrayWord) {
        List<T> words = new ArrayList<>(arrayWord.length);
        words.addAll(Arrays.asList(arrayWord));
        return words;
    }

    public static List<Integer> findUnique(List<Integer> ints) {
        List<Integer> uniqNum = new ArrayList<>();
        for (Integer number : ints) {
            if (!uniqNum.contains(number)) {
                uniqNum.add(number);
            }
        }
        return uniqNum;
    }

    public static Map<String, Integer> calcOccurance(List<String> arrayWords) {
        Map<String, Integer> countOccurance = new HashMap<>();
        for (String currentWord : arrayWords) {
            if (countOccurance.containsKey(currentWord)) {
                countOccurance.put(currentWord, countOccurance.get(currentWord) + 1);
            } else {
                countOccurance.put(currentWord, 1);
            }
        }
        return countOccurance;
    }

    public static List<WordOccurance> findOccurance(List<String> arrayWords) {
        List<WordOccurance> resultStructure = new ArrayList<>();
        int count = 1;
        Collections.sort(arrayWords);
        String currentWord = arrayWords.get(0);
        for (int i = 1; i < arrayWords.size(); i++) {
            if (currentWord.equals(arrayWords.get(i))) {
                count++;
            } else {
                resultStructure.add(new WordOccurance(currentWord, count));
                count = 1;
                currentWord = arrayWords.get(i);
            }
        }
        resultStructure.add(new WordOccurance(currentWord, count));
        return resultStructure;
    }
}