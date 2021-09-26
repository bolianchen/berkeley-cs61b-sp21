package deque;

import java.util.Iterator;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> internalComp;
    public MaxArrayDeque(Comparator<T> c) {
        internalComp = c;
    }
    // returns the maximum element in the deque by internalComp
    public T max() {
        Iterator<T> iter = iterator();
        if (!iter.hasNext()) {
            return null;
        }
        T maxElement = iter.next();
        while (iter.hasNext()) {
            T curElement = iter.next();
            int comp = internalComp.compare(curElement, maxElement);
            if (comp > 0) {
                maxElement = curElement;
            }
        }
        return maxElement;
    }
    // returns the maximum element in the deque by the given comparator
    public T max(Comparator<T> c) {
        Iterator<T> iter = iterator();
        if (!iter.hasNext()) {
            return null;
        }
        T maxElement = iter.next();
        while (iter.hasNext()) {
            T curElement = iter.next();
            int comp = c.compare(curElement, maxElement);
            if (comp > 0) {
                maxElement = curElement;
            }
        }
        return maxElement;
    }
}
