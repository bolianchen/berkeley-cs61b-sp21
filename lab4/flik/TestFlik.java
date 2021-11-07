package flik;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    public static void printIsSameNumber() {
        for (int i = 125; i < 130; i+= 1) {
            System.out.println(Flik.isSameNumber(i,i));
        }
    }

    @Test
    public void testIsSameNumber() {
        for (int i = -10000; i < 10000; i += 1) {
            assertTrue(Flik.isSameNumber(i,i));
        }

    }

    public static void main(String args[]) {
        printIsSameNumber();
    }
}
