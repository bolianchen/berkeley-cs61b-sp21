package deque;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /* create an empty array deque */
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    public ArrayDeque(T[] array) {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        for (T i: array) {
            addLast(i);
        }
    }
    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;
        public ArrayDequeIterator() {
            wizPos = updateIndex(nextFirst+1);
        }
        public boolean hasNext() {
            return wizPos != nextLast;
        }
        public T next() {
            T returnItem = items[wizPos];
            wizPos = updateIndex(wizPos + 1);
            return returnItem;
        }
    }
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    private int updateIndex(int i) {
        if (i > (items.length - 1)) {
            return i - items.length;
        } else if(i < 0) {
            return items.length + i;
        } else {
            return i;
        }
    }
    private void resize(int capacity) {
        T[] tempItems = (T []) new Object[capacity];
        for(int i = 0; i < size; ++i) {
            nextFirst = updateIndex(nextFirst + 1);
            tempItems[i] = items[nextFirst];
        }
        items = tempItems;
        nextFirst = tempItems.length - 1;
        nextLast = size;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = updateIndex(nextFirst - 1);
        size += 1;
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = updateIndex(nextLast + 1);
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        if (!isEmpty()) {
            int currPos = updateIndex(nextFirst + 1);
            for(int i = 0; i < size; ++i) {
                System.out.print( items[currPos]+ " ");
                currPos = updateIndex(currPos + 1);
            }
            System.out.println();
        }
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            if (size == items.length / 4 && size >= 16) {
                resize(items.length / 2);
            }
            nextFirst = updateIndex(nextFirst + 1);
            T result = items[nextFirst];
            items[nextFirst] = null;
            size -= 1;
            return result;
        }
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            if (size == items.length / 4 && size >= 16) {
                resize(items.length / 2);
            }
            nextLast = updateIndex(nextLast - 1);
            T result = items[nextLast];
            items[nextLast] = null;
            size -= 1;
            return result;
        }
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            return items[updateIndex(nextFirst + 1 + index)];
        }
    }
    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (size != other.size()) {
            return false;
        }
        int currPos1 = updateIndex(nextFirst + 1);
        int currPos2 = updateIndex(other.nextFirst + 1);
        for(int i = 0; i < size; ++i) {
            if (!items[currPos1].equals(other.items[currPos2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> subject = new ArrayDeque();
        int testRounds = 10;
        for(int i = 0; i < testRounds; ++i) {
            int operationNumber = StdRandom.uniform(0, 6);
            int sampledIndex;
            if (operationNumber == 0) {
                sampledIndex = StdRandom.uniform(0, 100);
                subject.addFirst(sampledIndex);
                System.out.println("addFirst(" + sampledIndex + ")");
            } else if (operationNumber == 1) {
                sampledIndex = StdRandom.uniform(0, 100);
                subject.addLast(sampledIndex);
                System.out.println("addLast(" + sampledIndex + ")");
            } else if (operationNumber == 2) {
                System.out.println("removeFirst:" + subject.removeFirst());
            } else if (operationNumber == 3) {
                System.out.println("removeLast:" + subject.removeLast());
            } else if (operationNumber == 4) {
                sampledIndex = StdRandom.uniform(0, subject.size() + 10);
                System.out.println("get " + sampledIndex + "th item:" + subject.get(sampledIndex));
            } else if (operationNumber == 5) {
                subject.printDeque();
            }
        }
        Iterator<Integer> aqseer = subject.iterator();
        while (aqseer.hasNext()) {
            System.out.println(aqseer.next());
        }
    }
}
