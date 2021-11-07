/** Class that prints the Collatz sequence starting from a given number.
 *  @author BolianChen
 */
public class Collatz {
    /** This program is to print the Collatz sequence
     *  If the current number is even, the next number is n/2
     *  If the current number is odd, the next number is 3n + 1
     *  The sequence is over when the current number is 1
    */

    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {
        if (n  == 128) {
            return 1;
        } else if (n == 5) {
            return 3 * n + 1;
        } else {
            return n * 2;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

