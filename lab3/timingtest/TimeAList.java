package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // construct an AList
        AList<Integer> testList;
        // test cases
        int[] Ns = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 10000000};
        // initialize a stopwatch
        Stopwatch sw = new Stopwatch();

        AList<Integer> sizeList = new AList<>();
        AList<Double> timeList = new AList<>();
        AList<Integer> opCountList = new AList<>();

        for (int N : Ns) {
            // reset the testList
            testList = new AList<>();
            // start timing
            double start = sw.elapsedTime();
            for (int i = 0; i < N; i += 1) {
                testList.addLast(i);
            }
            // end timing
            timeList.addLast(sw.elapsedTime()-start);
            sizeList.addLast(testList.size());
            opCountList.addLast(N);
        }
        printTimingTable(sizeList, timeList, opCountList);
    }
}
