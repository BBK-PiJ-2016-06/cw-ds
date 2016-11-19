/**
* A type of stack extending @see AbstractStack. Regardless of the type of list used, the top
* of the stack will be considered as index position 0.
*/

public class StackImpl extends AbstractStack implements Stack {

  /**
   *constructor taking @param list type to build this version of the stack
   */
  public StackImpl(List list) {
    super(list);
  }

  /**
   * Returns true if the stack is empty, false otherwise.
   * @see Stack#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    if (internalList.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the number of items currently in the stack.
   * @see  Stack#size
   */
  @Override
  public int size() {
    return internalList.size();
  }

  /**
   * Adds an element at the top of the stack.
   * if internalList is empty, will need to use the add(item) method of the internalList
   * otherwise adding at index position 0 will trigger an EMPTY_STRUCTURE error and push will
   * be unsuccessful
   * @see Stack#push
   * uses super's internalList to add an item at index position 0
   */
  @Override
  public void push(Object item) {
    if (isEmpty()) {
      internalList.add(item);
    } else {
      internalList.add(0, item);
    }
  } 

  /**
   * @see Stack#top
   * uses the internalList's get(int index) method at index position 0.
   */
  @Override
  public ReturnObject top() {
    return internalList.get(0);
  }

  /**
   * @see Stack#pop
   * uses the internalList's remove(int index) method at index position 0.
   */
  @Override
  public ReturnObject pop() {
    return internalList.remove(0);
  }

}
