package deque;
import edu.princeton.cs.algs4.StdRandom;

public class CircularSentinelLinkedListDeque<T> implements Proj1Deque<T> {
    private IntNode sentinel;
    private int size;

    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;
        private IntNode(T i, IntNode p, IntNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }
    /* Creates an empty linked list deque
     * an circular sentinel with item null and whose next and prev pointing
     * to itself
     */
    public CircularSentinelLinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /* Create an linked list deque by giving the sentinel node
     * and the deque size
     */
    public CircularSentinelLinkedListDeque(IntNode senti, int s) {
        sentinel = senti;
        size = s;
    }
    public void addFirst(T item) {
        IntNode temp = sentinel.next;
        sentinel.next = new IntNode(item, sentinel, sentinel.next);
        temp.prev = sentinel.next;
        size += 1;
    }
    public void addLast(T item) {
        IntNode temp = sentinel.prev;
        sentinel.prev = new IntNode(item, sentinel.prev, sentinel);
        temp.next = sentinel.prev;
        size += 1;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        if (!isEmpty()) {
            IntNode p = sentinel.next;
            int loopsToRun = size;
            while (loopsToRun > 0) {
                System.out.print(p.item + " ");
                p = p.next;
                loopsToRun -= 1;
            }
            System.out.println();
        }
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T result = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return result;
        }
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T result = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return result;
        }
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            // first node, returned when index is 0;
            IntNode temp = sentinel.next;
            while (index > 0) {
                temp = temp.next;
                index -= 1;
            }
            return temp.item;
        }
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else if (index == 0) {
            return sentinel.next.item;
        } else {
            // create a new deque by shifting the sentinel forward
            CircularSentinelLinkedListDeque<T> newDeque = new CircularSentinelLinkedListDeque<>(sentinel.next,size);
            return newDeque.getRecursive(index-1);
        }
    }
    public boolean equals(Object o) {
        if (!(o instanceof CircularSentinelLinkedListDeque)) {
            return false;
        }
        CircularSentinelLinkedListDeque cq = (CircularSentinelLinkedListDeque) o;
        if (size != cq.size()) {
            return false;
        }
        IntNode node1 = sentinel.next;
        IntNode node2 = cq.sentinel.next;
        int loopsToRun = size;
        while (loopsToRun > 0) {
            if (!node1.item.equals(node2.item)) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
            loopsToRun -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        CircularSentinelLinkedListDeque<Integer> cq = new CircularSentinelLinkedListDeque<>();
        cq.addFirst(3);
        cq.addFirst(5);
        cq.printDeque();
        cq.addLast(13);
        cq.addLast(15);
        cq.printDeque();
        cq.removeFirst();
        cq.removeLast();
        cq.printDeque();
    }
}
