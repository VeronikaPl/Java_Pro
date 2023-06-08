import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList<T> {
    private final List<T> list = Collections.synchronizedList(new ArrayList<>());

    public void add(T element) {
        synchronized (list) {
            list.add(element);
        }
    }

    public void remove(T element) {
        synchronized (list) {
            list.remove(element);
        }
    }

    public void get(int index) {
        synchronized (list) {
            list.get(index);
        }
    }
}
