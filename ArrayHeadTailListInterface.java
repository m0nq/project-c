/**
 * Authors: Monk Wellington, Luke Evans, Ayesha Chattopadhyay, Josh Hansen
 */
public class ArrayHeadTailListInterface<T> implements HeadTailListInterface<T> {

  private T[] listArray;
  private int numberOfElements;

  // Joshua Hansen

  public boolean isEmpty() {
    return (numberOfElements == 0);
  }

  @SuppressWarnings(“unchecked”)
  public void clear() {
    listArray = (T[]) new Object[numberOfElements]; // listArray retains its current length
    numberOfElements = 0;
  }

}