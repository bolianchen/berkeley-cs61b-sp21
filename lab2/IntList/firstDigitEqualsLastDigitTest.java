package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class firstDigitEqualsLastDigitTest {

    @Test
    public void testFEL1() {
        int x = 535;
        boolean equal = IntListExercises.firstDigitEqualsLastDigit(x);
        assertEquals(true, equal);
    }

    @Test
    public void testFEL2() {
        int x = 10;
        boolean equal = IntListExercises.firstDigitEqualsLastDigit(x);
        assertEquals(false, equal);
    }

    @Test
    public void testFEL3() {
        int x = 1000;
        boolean equal = IntListExercises.firstDigitEqualsLastDigit(x);
        assertEquals(false, equal);
    }
}
