package deque;
import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        //assume nobody is messing up and giving us
        //something that isn't a dog.
        return size - uddaDog.size;
    }

    public static class NamedComparator implements Comparator<Dog> {
        public int compare(Dog d1, Dog d2) {
            return d1.name.compareTo(d2.name);
        }
    }

    public static class SizeComparator implements Comparator<Dog> {
        public int compare(Dog d1, Dog d2) {
            return d1.compareTo(d2);
        }
    }

    public Comparator<Dog> getNamedComparator(){
        return new NamedComparator();
    }

    public Comparator<Dog> getSizeComparator(){
        return new SizeComparator();
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }
}
