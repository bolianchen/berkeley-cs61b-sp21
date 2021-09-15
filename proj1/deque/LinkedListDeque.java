package deque;

public class LinkedListDeque<T> {
    private IntNode first; 
    private IntNode last;
    private int size;

    private class IntNode {
        private T item; 
        private IntNode next;
        private IntNode prev;
        private IntNode(T i, IntNode p, IntNode n){
            item = i;
            next = n;
            prev = p; 
        }
    }
    public LinkedListDeque(IntNode f, IntNode l, int s) {
        first = f;
        last = l;
        size = s;
    }

    public LinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    public void addFirst(T item) {
        // first and last would be null or not null at the same time
        if (first == null) {
            first = new IntNode(item, null, null);
            last = first;
        } else {
            IntNode newNode = new IntNode(item, null, first);
            first.prev = newNode;
            first = newNode;
        }
        size += 1;
    }

    public T removeFirst() {
       if (isEmpty()) {
           return null;
       } else if (size()==1) {
           T result = first.item;
           first = null;
           last = null;
           size -= 1;
           return result;
       } else {
           T result = first.item;
           first = first.next;
           first.prev = null;
           size -= 1;
           return result;
       }
    }

    public void addLast(T item) {
        IntNode newNode = new IntNode(item, null, null);
        if (last == null) {
           last = newNode;
           first = last;
        } else {
            last.next = newNode;
            IntNode temp = last;
            last = newNode;
            last.prev = temp;
        }
        size += 1;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size()==1) {
            T result = last.item;
            first = null;
            last = null;
            size -= 1;
            return result;
        } else {
            T result = last.item;
            last = last.prev;
            last.next = null;
            size -= 1;
            return result;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        IntNode p = first;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        } else {
            IntNode temp = first;
            while (index > 0) {
                temp = temp.next;
                index -= 1;
            }
            return temp.item;
        }
    }

    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        } else if (index == 0) {
            return this.first.item;
        } else {
            LinkedListDeque<T> subDeque = new LinkedListDeque<>(this.first.next, this.last, this.size-1);
            return subDeque.getRecursive(index-1);
        }

    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> d = new LinkedListDeque<>();
        d.addLast(100);
        d.addFirst(3);
        d.addFirst(5);
        d.addFirst(10);
        d.addLast(30);
        System.out.println(d.removeFirst());
        System.out.println(d.removeFirst());
        d.addFirst(13);
        d.addFirst(15);
        System.out.println(d.get(3));
        System.out.println(d.getRecursive(3));
        d.addLast(200);
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        System.out.println(d.removeLast());
    }



    
    
}
