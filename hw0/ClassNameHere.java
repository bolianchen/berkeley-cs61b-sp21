public class ClassNameHere {
    /** Exercise 2
     *  Uses a while loop to return the maximum value from m. */
    public static int max(int[] m) {
        int max_value = m[0]; // use the 1st entry as the initial maximum value
        int i = 1;
        while (i < m.length) {
            if (m[i] > max_value) {
                max_value = m[i];
            }
            i = i+1;
        }
        return max_value;
    }
    /** Exercise 3 
     *  Uses a for loop to return the maximum value from m. */
    public static int forMax(int[] m) {
        int max_value = m[0];
        for (int i = 1; i < m.length; i += 1){
            if (m[i] > max_value) {
                max_value = m[i];
            }
        }
        return max_value;
    }
    /** Uses a while loop to sum an int matrix a */
    public static int whileSum(int[] a) {
        int i = 0; //initialization of the looping index
        int sum = 0;
        while (i < a.length){
            sum += a[i];
            i += 1; //increment
        }
        return sum;
    }
    /** Uses a basic for loop to sum an int matrix a */
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i = i+1){
            sum += a[i];
        }
        return sum;
    }
    /** Exercies 4 
     *  replaces each element a[i] with the sum of a[i] through a[i + n],
     *  but only if a[i] is positive valued. If there are not enough values 
     *  because we reach the end of the array, we sum only as many values
     *  as we have. */
     public static void windowPosSum(int[] a, int n){
        for (int i = 0; i < a.length; i += 1){
            if (a[i] > 0){
                int sum = 0;
                int end; // the endpoint to sum, not included in the iteration
                if (i+n >= a.length){
                    end = a.length;
                } else {
                    end = i+n+1;
                }
                for (int j = i; j < end; j += 1 ){
                    sum += a[j];
                }
                a[i] = sum;
            }
        }
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6}; // to test max and forMax
        System.out.print("max of " + java.util.Arrays.toString(numbers));
        System.out.println(" is " + max(numbers));
        System.out.print("forMax of " + java.util.Arrays.toString(numbers));
        System.out.println(" is " + forMax(numbers));

        int[] a1 = new int[]{1, 2, -3, 4, 5, 4}; // to test windowPosSum
        int[] a2 = new int[]{1, -1, -1, 10, 5, -1}; // to test windowPosSum
        System.out.println("original a1=" + java.util.Arrays.toString(a1));
        windowPosSum(a1, 3);
        System.out.println("processed a1 by windowPowSum=" + java.util.Arrays.toString(a1));
        System.out.println("original a1=" + java.util.Arrays.toString(a2));
        windowPosSum(a2, 2);
        System.out.println("processed a2 by windowPowSum=" + java.util.Arrays.toString(a2));
    }
}
