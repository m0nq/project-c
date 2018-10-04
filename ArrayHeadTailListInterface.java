/**
 * Authors: Monk Wellington, Luke Evans, Ayesha Chattopadhyay, Josh Hansen
 */
public class ArrayHeadTailListInterface<T> implements HeadTailListInterface<T> {

  private T[] listArray;
  private int numberOfElements;

  // Luke Evans

  public ArrayHeadTailListInterface(int initialCapacity) {
    if (initialCapacity < 1) {
      initialCapacity = 1;
    }

    listArray = (T[]) new Object[initialCapacity];
    numberOfElements = 0;
  }

  public int contains(T anEntry) {
    for (int i = 0; i < numberOfElements; i++) {
      if (listArray[i].equals(anEntry)) {
        return i;
      }
    }

    return -1;
  }

  public T removeFront() {
    if (numberOfElements > 0) {
      T removedElement = listArray[0];
      for (int i = 0; i < numberOfElements; i++) {
        if (i + 1 != numberOfElements) {
          listArray[i] = listArray[i + 1];
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

  // Monk Wellington

  @Override
  public void addFront(T newEntry) {

    if (newEntry != null) {
      if (numberOfElements == 0) {
        listArray[0] = newEntry;
        numberOfElements++;
      } else if (numberOfElements == listArray.length) {
        T[] interimList = (T[]) new Object[numberOfElements * 2];

        interimList[0] = newEntry;

        for (int i = 0; i < listArray.length; i++) {
          interimList[i + 1] = listArray[i];
        }

        listArray = interimList;

        numberOfElements++;
      } else {

        for (int i = numberOfElements; i >= 0; i--) {
          listArray[i + 1] = listArray[i];
        }

        listArray[0] = newEntry;
        numberOfElements++;
      }
    }
  }

  @Override
  public void display() {

  }

  @Override
  public T removeBack() {
    return null;
  }

  //  Ayesha Chattopadhyay

  @Override
  public void addBack(T newEntry) {

  }

  @Override
  public T getEntry(int givenPosition) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  // Joshua Hansen

  //  @SuppressWarnings(“unchecked”)
  public void clear() {
    listArray = (T[]) new Object[numberOfElements]; // listArray retains its current length
    numberOfElements = 0;
  }

  public boolean isEmpty() {
    return (numberOfElements == 0);
  }
}