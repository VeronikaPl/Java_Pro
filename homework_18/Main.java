import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] str = {"apple", "peach", "grapes"};
        System.out.println(toList(str));

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Box<Apple> appleBox = new Box<>();
        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(apple3);

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        List<Orange> orangeList = new ArrayList<>();
        orangeList.add(orange1);
        orangeList.add(orange2);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(orangeList);
        System.out.println(orangeBox.compare(appleBox));

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.add(orange3);
        System.out.println(orangeBox2.compare(appleBox));

        orangeBox2.merge(orangeBox);
        System.out.println(orangeBox2.getWeight());
        System.out.println(orangeBox.getWeight());
    }

    public static <T> List<T> toList(T[] array) {
        Objects.requireNonNull(array);
        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }
}
