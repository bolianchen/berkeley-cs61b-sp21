package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;
import java.util.LinkedList;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double> lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }
    public void inplaceChange(Deque<Integer> o, int i) {
        if (i%4 == 0) {
            o.addFirst(i);
        } else if (i%4 == 1) {
            o.addLast(i);
        } else if (i%4 == 2) {
            o.removeFirst();
        } else if (i%4 == 3) {
            o.removeLast();
        }
    }
    @Test
    /* two ArrayDeques having the same items */
    public void equalityTest1() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        int N = 1000;
        for (int i=0; i<N; i+=1) {
            int randVal = StdRandom.uniform(0, 100);
            inplaceChange(lld1, randVal);
            inplaceChange(lld2, randVal);
        }
        assertEquals(true, lld1.equals(lld2));
        assertEquals(true, lld2.equals(lld1));
    }
    @Test
    /* two LinkedListDeques having different items */
    public void equalityTest2() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        int N = 1000;
        for (int i=0; i<N; i+=1) {
            int randVal = StdRandom.uniform(0, 100);
            inplaceChange(lld1, randVal);
            inplaceChange(lld2, randVal);
        }
        lld1.addFirst(N);
        assertEquals(false, lld1.equals(lld2));
        assertEquals(false, lld2.equals(lld1));
    }
    @Test
    /* two Deques of different classes */
    public void equalityTest3() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        int N = 1000;
        for (int i=0; i<N; i+=1) {
            int randVal = StdRandom.uniform(0, 100);
            inplaceChange(lld1, randVal);
            inplaceChange(lld2, randVal);
        }
        assertEquals(false, lld1.equals(lld2));
        assertEquals(false, lld2.equals(lld1));
    }

    @Test
    /* Conduct randomized tests by comparing with Java's built in
    * data structure LinkedList */
    public void randomizedTest() {
        LinkedList<Integer> examiner = new LinkedList<>();
        LinkedListDeque<Integer> subject = new LinkedListDeque<>();
        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                examiner.addFirst(randVal);
                subject.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                examiner.addLast(randVal);
                subject.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 2) {
                // size
                assertEquals(examiner.size(), subject.size());
            } else if (operationNumber == 3) {
                // removeFirst
                if (examiner.size() == 0) {
                    assertEquals(examiner.size(), subject.size());
                } else {
                    assertEquals(examiner.removeFirst(), subject.removeFirst());
                    assertEquals(examiner.size(), subject.size());
                }
            } else if (operationNumber == 4) {
                // removeLast
                if (examiner.size() == 0) {
                    assertEquals(examiner.size(), subject.size());
                } else {
                    assertEquals(examiner.removeLast(), subject.removeLast());
                    assertEquals(examiner.size(), subject.size());
                }
            } else if (operationNumber == 5) {
                //get and getRecursive
                int index = StdRandom.uniform(0, 100);
                if (index < examiner.size()) {
                    assertEquals(examiner.get(index), subject.get(index));
                    assertEquals(examiner.get(index), subject.getRecursive(index));
                } else {
                    assertEquals(examiner.size(), subject.size());
                }
            }
        }
    }
}
