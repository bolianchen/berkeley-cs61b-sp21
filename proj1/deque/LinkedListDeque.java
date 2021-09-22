package deque;

import edu.princeton.cs.algs4.StdRandom;

public class LinkedListDeque<T> implements Proj1Deque<T> {
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
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (!isEmpty()) {
            IntNode p = first;
            while (p != null) {
                System.out.print(p.item + " ");
                p = p.next;
            }
            System.out.println();
        }
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
    public T get(int index) {
        if (index >= size) {
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
        if (index >= size) {
            return null;
        } else if (index == 0) {
            return this.first.item;
        } else {
            LinkedListDeque<T> subDeque = new LinkedListDeque<>(this.first.next, this.last, this.size-1);
            return subDeque.getRecursive(index-1);
        }
    }
    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque oo = LinkedListDeque.class.cast(o);
        if (size != oo.size()) {
            return false;
        }
        IntNode node1 = first;
        IntNode node2 = oo.first;
        while (node1 != null) {
            if (!node1.item.equals(node2.item)) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> subject = new LinkedListDeque<>();
        int testRounds = 100;
        for (int i=0; i< testRounds; i+=1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                subject.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                subject.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 2) {
                //removeFirst
                System.out.println("removeFirst:" + subject.removeFirst());
            } else if (operationNumber == 3) {
                //removeLast
                System.out.println("removeLast:" + subject.removeLast());
            } else if (operationNumber == 4) {
                // get
                int sampledIndex = StdRandom.uniform(0, subject.size()+10);
                System.out.println("get " + sampledIndex +"th item:" + subject.get(sampledIndex));
            } else if (operationNumber == 5) {
                // printDeque
                subject.printDeque();
            }
        }
    }



    
    
}
