public class TriangleDrawer {
    /** Excercise 1b */ 
    public static void drawTriangle(int N) {
        int row = 0; // row
        int col; //column
        while (row < N){
            col = 0;
            while (col <= row) {
                if (col == row)
                    System.out.println("*");
                else
                    System.out.print("*");
                col += 1;
            }
            row += 1;
        }
    }
    public static void main(String[] args) {
        int N = 10;
        drawTriangle(N);
    }
}
