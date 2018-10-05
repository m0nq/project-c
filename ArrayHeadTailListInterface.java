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

        for (int i = numberOfElements; i > 0; i--) {
          listArray[i] = listArray[i - 1];
        }

        listArray[0] = newEntry;
        numberOfElements++;
      }
    }
  }

  @Override
  public void display() {
    if (numberOfElements != 0) {
      String consoleList = "";
      for (int i = 0; i < numberOfElements; i++) {
        if (listArray[i] instanceof String)
          consoleList += listArray[i] + " ";
        else {
          consoleList += listArray[i].toString() + ", ";

          if (i == numberOfElements - 1)
            consoleList = consoleList.substring(0, consoleList.length() - 1);
        }
      }
      consoleList = consoleList.substring(0, consoleList.length() - 1);
      System.out.println(consoleList);
    }
  }

  @Override
  public T removeBack() {
    return numberOfElements != 0 ? listArray[numberOfElements - 1] : null;
  }

  //  Ayesha Chattopadhyay

  @Override
  public void addBack(T newEntry) {

  }

  @Override
  public T getEntry(int position) {
    if (position >= 0 && position <= numberOfElements) {
      assert !isEmpty();
      return listArray[position];
    } else {
      throw new IndexOutOfBoundsException("Error: Illegal position.");
    }
  }

  @Override
  public int size() {
    return numberOfElements;
  }

  // Joshua Hansen

  //  @SuppressWarnings(“unchecked”)
  public void clear() {
    // listArray retains its current length
    listArray = numberOfElements == 0 ? (T[]) new Object[1] : (T[]) new Object[numberOfElements];
    numberOfElements = 0;
  }

  public boolean isEmpty() {
    return (numberOfElements == 0);
  }
}