package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> buggy = new BuggyAList<>();
      int[] addItems = new int[]{100, 200, 300};

      for (int item : addItems) {
        correct.addLast(item);
        buggy.addLast(item);
      }
      assertEquals(correct.size(), buggy.size());
      for (int i = 0; i<3; i += 1 ) {
        assertEquals(correct.removeLast(), buggy.removeLast());
      }
      assertEquals(correct.size(), buggy.size());
    }
    @Test
    public void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> buggyL = new BuggyAList<>();

      int N = 50000;
      for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        if (operationNumber == 0) {
          // addLast
          int randVal = StdRandom.uniform(0, 100);
          L.addLast(randVal);
          buggyL.addLast(randVal);
          System.out.println("addLast(" + randVal + ")");
        } else if (operationNumber == 1) {
          // size
          int size = L.size();
          int buggySize = buggyL.size();
          System.out.println("size: " + size);
          System.out.println("buggySize: " + buggySize);
          assertEquals(size, buggySize);
        } else if (operationNumber == 2) {
          if (L.size() == 0) {
            continue;
          }
          int last = L.getLast();
          int buggyLast = buggyL.getLast();
          System.out.println("getLast(" + last + ")");
          System.out.println("getLast(" + buggyLast + ")");
          assertEquals(last, buggyLast);
        } else if (operationNumber == 3) {
          if (L.size() == 0) {
            continue;
          }
          int last = L.removeLast();
          int buggyRemovedLast = buggyL.removeLast();
          System.out.println("removeLast(" + last + ")");
          System.out.println("removeLast(" + buggyRemovedLast + ")");
          assertEquals(last, buggyRemovedLast);
        }
      }
    }
}
