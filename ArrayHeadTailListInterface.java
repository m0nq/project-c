/**
 * Authors: Monk Wellington, Luke Evans, Ayesha Chattopadhyay, Josh Hansen
 */
public class ArrayHeadTailListInterface<T> implements HeadTailListInterface<T> {

  private T[] listArray;
  private int numberOfElements;

  // Luke Evans
  public ArrayHeadTailListInterface(int initialCapacity) {
    if(initialCapacity < 1) {
      initialCapacity = 1;
    }

    @SuppressWarnings(“unchecked”)
    listArray = (T) new Object[initialCapacity];
    numberOfElements = 0;
  }

  public int contains(T anEntry) {
    for(int i=0; i < numberOfElements; i++) {
      if(listArray[i].equals(anEntry)) {
        return i;
      }
    }

    return -1;
  }

  public T removeFront() {
    if(numberOfElements > 0) {
      T removedElement = listArray[0];
      for(int i=0; i < numberOfElements; i++) {
        if(i + 1 != numberOfElements) {
          listArray[i] = listArray[i+1];
        } else {
          listArray[i] = null;
        }
      }
      numberOfElements -= 1;
      return removedElement;
    } else {
      return null;
    }
  }

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