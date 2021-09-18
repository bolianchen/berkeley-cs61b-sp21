package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Stopwatch;
public class TimeLinkedListDeque {

    private static void printTimingTable(LinkedListDeque<Integer> Ns, LinkedListDeque<Double> times, LinkedListDeque<Integer> opCounts) {
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
    public static void timeAddFirst() {
        // construct a 
        LinkedListDeque<Integer> testList;
        // test cases, how many items to add preliminarily
        int[] Ns = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        // initialize a stopwatch
        Stopwatch sw = new Stopwatch();

        LinkedListDeque<Integer> addedNumberList = new LinkedListDeque<>();
        LinkedListDeque<Double> timeList = new LinkedListDeque<>();
        LinkedListDeque<Integer> opCountList = new LinkedListDeque<>();

        for (int N : Ns) {
            // reset the testList
            testList = new LinkedListDeque<>();
            // start timing
            double start = sw.elapsedTime();
            for (int i=0; i<N; i+=1) {
                testList.addFirst(i);
            }
            // end timing
            timeList.addLast(sw.elapsedTime()-start);
            addedNumberList.addLast(N);
            opCountList.addLast(N);
        }
        printTimingTable(addedNumberList, timeList, opCountList);
    }

    public static void timeAddLast() {
        // construct a
        LinkedListDeque<Integer> testList;
        // test cases, how many items to add preliminarily
        int[] Ns = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        // initialize a stopwatch
        Stopwatch sw = new Stopwatch();

        LinkedListDeque<Integer> addedNumberList = new LinkedListDeque<>();
        LinkedListDeque<Double> timeList = new LinkedListDeque<>();
        LinkedListDeque<Integer> opCountList = new LinkedListDeque<>();

        for (int N : Ns) {
            // reset the testList
            testList = new LinkedListDeque<>();
            // start timing
            double start = sw.elapsedTime();
            for (int i=0; i<N; i+=1) {
                testList.addLast(i);
            }
            // end timing
            timeList.addLast(sw.elapsedTime()-start);
            addedNumberList.addLast(N);
            opCountList.addLast(N);
        }
        printTimingTable(addedNumberList, timeList, opCountList);
    }

    public static void main(String[] args) {
        timeAddLast();
    }
}
