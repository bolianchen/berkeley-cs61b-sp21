/** Class that prints the Collatz sequence starting from a given number.
 *  @author BolianChen
 */
public class Collatz {
    /** This program is to print the Collatz sequence
     *  If the current number is even, the next number is n/2
     *  If the current number is odd, the next number is 3n + 1
     *  The sequence is over when the current number is 1
    */
    public static int nextNumber(int n) {
        if (n%2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
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

