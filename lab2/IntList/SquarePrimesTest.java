package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesEasy() {
        IntList lst = IntList.of(2, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 49", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesMedium() {
        IntList lst = IntList.of(2, 7, 11, 13, 14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 49 -> 121 -> 169 -> 14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesHard() {
        int[] arr = new int[100];
        int[] answerArr = new int[100];
        for (int i = 0; i < arr.length; i += 1) {
            arr[i] = i+1;
            if (Primes.isPrime(i+1)) {
                answerArr[i] = (i+1) * (i+1);
            } else {
                answerArr[i] = i+1;
            }
        }
        IntList lst = IntList.of(arr);
        IntList answerLst = IntList.of(answerArr);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals(answerLst.toString(), lst.toString());
        assertTrue(changed);
    }
}
