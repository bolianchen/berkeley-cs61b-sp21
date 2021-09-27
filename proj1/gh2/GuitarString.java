package gh2;

import deque.Deque;
// TODO: maybe more imports
import deque.ArrayDeque;
import java.lang.Math;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR/frequency);
        buffer = new ArrayDeque<>();
        for (int i=0; i<capacity; i+=1) {
            buffer.addLast(0.0);
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        int capacity = buffer.size();
        for (int i=0; i<capacity; i+=1) {
            buffer.removeFirst();
            double randDVal = Math.random() - 0.5;
            buffer.addLast(randDVal);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double frontSample = buffer.removeFirst();
        double nextSample = sample();
        double newSample = DECAY * 0.5 * (frontSample + nextSample);
        buffer.addLast(newSample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }

    public static void main(String[] args) {
        TestGuitarString tg = new TestGuitarString();
        tg.testTicCalculations();
    }
}