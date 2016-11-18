/**
* A type of stack extending @see AbstractStack. Regardless of the type of list used, the top
* of the stack will be considered as index position 0.
*/

public class StackImpl extends AbstractStack implements Stack {

  public StackImpl(List list) {
    super(list);
  }

  /**
   * Returns true if the stack is empty, false otherwise.
   * @see Stack#isEmpty()
   */
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
  public int size() {
    return internalList.size();
  }

  /**
   * Adds an element at the top of the stack.
   * @see Stack#push
   */
  public void push(Object item) {
    internalList.add(0, item);
  }

  /**
   * @see Stack#top
   * uses the internalList's get(int index) method at index position 0.
   */
  public ReturnObject top() {
    return internalList.get(0);
  }

  /**
   * @see Stack#pop
   * uses the internalList's get(int index) method at index position 0.
   */
  public ReturnObject pop() {
    return internalList.remove(0);
  }

}
