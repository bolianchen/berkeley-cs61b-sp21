package deque;
import java.util.Comparator;

public class MaxArrayDequeTest {

    public static void main(String[] args) {
        Dog d1 = new Dog("big", 50);
        Dog d2 = new Dog("middle", 30);
        Dog d3 = new Dog("small", 10);
        Dog d4 = new Dog("zebra", 70);
        Comparator<Dog> nc = new Dog.NamedComparator();
        Comparator<Dog> sc = new Dog.SizeComparator();

        MaxArrayDeque<Dog> maq = new MaxArrayDeque<>(nc);
        maq.addFirst(d1);
        maq.addFirst(d2);
        maq.addFirst(d3);
        maq.addLast(d4);
        Dog maxDog = maq.max();
        Dog maxDog2 = maq.max(sc);
        maxDog.bark();
        maxDog2.bark();
    }
}