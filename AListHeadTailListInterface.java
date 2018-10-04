
import java.util.Arrays;

/**
 *
 * For extra credit, this class is an implementation of HeadTailListInterface that uses an AList as its
 * main data type for processing data.
 *
 * This implementation deviates from the HeadTailListInterface interface in that the capacity of the list doubles
 * rather than triples when the inner array's capacity is met.
 *
 * @param <T> This class will take in any comparable as its type parameter
 * @author Joshua Hansen
 */

public class AListHeadTailListInterface<T extends Comparable<? super T>> implements HeadTailListInterface<T> {
    private ListInterface<T> aList;

    public AListHeadTailListInterface(int initialCapacity) {
        aList = new AList<>(initialCapacity);
    }

    public void addFront(T newEntry) {
        aList.add(1, newEntry);
    }

    public void addBack(T newEntry) {
        aList.add(newEntry);
    }

    public T removeFront() {
        // Must catch exceptions since no @throws is defined in the interface
        try {
            return aList.remove(1);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public T removeBack() {
        // Must catch exceptions since no @throws is defined in the interface
        try {
            return aList.remove(aList.getLength());
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void clear() {
        aList.clear();
    }

    public T getEntry(int givenPosition) {
        // Must catch exceptions since no @throws is defined in the interface
        // Add one because this class' index will start at zero, unlike the inner aList object
        try {
            return aList.getEntry(givenPosition + 1);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    public void display() {
        System.out.println(Arrays.toString(aList.toArray()));
    }

    public int contains(T anEntry) {

        for (int i = 1; i <= aList.getLength(); i++) {
            if (aList.getEntry(i).equals(anEntry)) {
                return (i - 1);
            }
        }

        return -1;
    }

    public int size() {
        return aList.getLength();
    }

    public boolean isEmpty() {
        return aList.isEmpty();
    }
}
