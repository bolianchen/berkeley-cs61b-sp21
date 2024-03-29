package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
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
        int[] Ns = new int[]{100000, 200000, 400000, 800000, 1600000, 3200000, 6400000, 12800000, 25600000};
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
        int[] Ns = new int[]{100000, 200000, 400000, 800000, 1600000, 3200000, 6400000, 12800000, 25600000};
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
    public static void timeRemoveFirst() {
        // construct a
        LinkedListDeque<Integer> testList;
        // test cases, how many items to add preliminarily
        int[] Ns = new int[]{51200000};
        // how many items to remove
        int[] Ms = new int[]{12800000, 51200000};

        // initialize a stopwatch
        Stopwatch sw = new Stopwatch();

        LinkedListDeque<Integer> addedNumberList = new LinkedListDeque<>();
        LinkedListDeque<Double> timeList = new LinkedListDeque<>();
        LinkedListDeque<Integer> opCountList = new LinkedListDeque<>();

        for (int M : Ms) {
            for (int N : Ns) {
                // reset the testList
                testList = new LinkedListDeque<>();
                // add items
                for (int i = 0; i < N; i += 1) {
                    testList.addFirst(i);
                }
                // start timing
                double start = sw.elapsedTime();
                for (int i = 0; i < M; i += 1) {
                    testList.removeFirst();
                }
                // end timing
                timeList.addLast(sw.elapsedTime() - start);
                addedNumberList.addLast(N);
                opCountList.addLast(M);
            }
        }
        printTimingTable(addedNumberList, timeList, opCountList);
    }

    public static void timeRemoveLast() {
        // construct a
        LinkedListDeque<Integer> testList;
        // test cases, how many items to add preliminarily
        int[] Ns = new int[]{51200000};
        // how many items to remove
        int[] Ms = new int[]{12800000, 51200000};

        // initialize a stopwatch
        Stopwatch sw = new Stopwatch();

        LinkedListDeque<Integer> addedNumberList = new LinkedListDeque<>();
        LinkedListDeque<Double> timeList = new LinkedListDeque<>();
        LinkedListDeque<Integer> opCountList = new LinkedListDeque<>();

        for (int M : Ms) {
            for (int N : Ns) {
                // reset the testList
                testList = new LinkedListDeque<>();
                // add items
                for (int i = 0; i < N; i += 1) {
                    testList.addFirst(i);
                }
                // start timing
                double start = sw.elapsedTime();
                for (int i = 0; i < M; i += 1) {
                    testList.removeLast();
                }
                // end timing
                timeList.addLast(sw.elapsedTime() - start);
                addedNumberList.addLast(N);
                opCountList.addLast(M);
            }
        }
        printTimingTable(addedNumberList, timeList, opCountList);
    }

    public static void timeIteration() {
        // construct a
        LinkedListDeque<Integer> testList;
        // test cases, how many items to add preliminarily
        int[] Ns = new int[]{1000000, 2000000, 4000000, 8000000, 16000000, 32000000, 64000000};

        // initialize a stopwatch
        Stopwatch sw = new Stopwatch();

        LinkedListDeque<Integer> addedNumberList = new LinkedListDeque<>();
        LinkedListDeque<Double> timeList = new LinkedListDeque<>();
        LinkedListDeque<Integer> opCountList = new LinkedListDeque<>();

        for (int N : Ns) {
            // reset the testList
            testList = new LinkedListDeque<>();
            // add items
            for (int i=0; i<N; i+=1) {
                testList.addFirst(i);
            }
            // start timing
            Iterator<Integer> lqseer = testList.iterator();
            double start = sw.elapsedTime();
            while (lqseer.hasNext()) {
                lqseer.next();
            }
            // end timing
            timeList.addLast(sw.elapsedTime()-start);
            addedNumberList.addLast(N);
            opCountList.addLast(N);
        }
        printTimingTable(addedNumberList, timeList, opCountList);
    }

    public static void main(String[] args) {
        //System.out.println("Timing Table for addLast");
        //timeAddLast();
        //System.out.println("Timing Table for addFirst");
        //timeAddFirst();
        //System.out.println("Timing Table for removeFirst");
        //timeRemoveFirst();
        //System.out.println("Timing Table for removeLast");
        //timeRemoveLast();
        System.out.println("Timing Table for iteration");
        timeIteration();
    }
}
