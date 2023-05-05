import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T extends Fruit> {
    private final List<T> fruitList = new ArrayList<>();

    public void add(T fruit) {
        Objects.requireNonNull(fruit);
        fruitList.add(fruit);
    }

    public void add(List<T> fruit) {
        if (fruit.getClass() == fruitList.getClass()) {
            fruitList.addAll(fruit);
        } else {
            throw new RuntimeException("Different type of fruit can't be in the same box");
        }
    }

    public double getWeight() {
        if (fruitList.isEmpty()) {
            return 0.0F;
        }
        double weight = 0;
        for (T fruit : fruitList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> box) {
        Objects.requireNonNull(box);
        return this.getWeight() == box.getWeight();
    }

    public void merge(Box<T> box) {
        Objects.requireNonNull(box);
        if (fruitList.get(0).getClass() != box.fruitList.get(0).getClass()) {
            throw new IllegalArgumentException("Different fruit's types can't be merged");
        } else {
            fruitList.addAll(box.fruitList);
            box.fruitList.clear();
        }
    }
}
