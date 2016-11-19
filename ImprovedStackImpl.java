public class ImprovedStackImpl implements ImprovedStack {

  private List internalList;
  /**
   *constructor taking @param list type to build this version of the stack
   */
  public ImprovedStackImpl(List list) {
    this.internalList = list;
  }

  /**
   * Returns true if the stack is empty, false otherwise.
   * @see Stack#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    if (this.internalList.isEmpty()) {
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
    return this.internalList.size();
  }

  /**
   * Adds an element at the top of the stack.
   * if internalList is empty, uses the add(item) method of the internalList
   * otherwise adding at index position 0 will trigger an EMPTY_STRUCTURE error and push will
   * be unsuccessful
   * @see Stack#push
   * uses super's internalList to add an item at index position 0
   */
  @Override
  public void push(Object item) {
    if (isEmpty()) {
      this.internalList.add(item);
    } else {
      this.internalList.add(0, item);
    }
  }

  /**
   * @see Stack#top
   * uses the internalList's get(int index) method at index position 0.
   */
  @Override
  public ReturnObject top() {
    return this.internalList.get(0);
  }

  /**
   * @see Stack#pop
   * uses the internalList's remove(int index) method at index position 0.
   */
  @Override
  public ReturnObject pop() {
    return this.internalList.remove(0);
  }

  /**
   * @see ImprovedStack#reversed
   * @return a copy of this stack with the items reversed.
   */
  public ImprovedStack reverse() {
    ImprovedStack deconstructor = new ImprovedStackImpl(this.internalList);
    LinkedList list = new LinkedList();
    ImprovedStack reversedStack = new ImprovedStackImpl(list);
    while (!deconstructor.top().hasError()) {
      reversedStack.push(deconstructor.pop().getReturnValue());
    }
    return reversedStack;
  }

  /**
   * @see ImprovedStack#remove 
   * @param object the object to remove
   */
  public void remove(Object object) {
    LinkedList newList = new LinkedList();
    ImprovedStack stackWithoutRemovedObject = new ImprovedStackImpl(newList);
    while (!this.isEmpty()) {
      ReturnObject objectToExamine = this.pop(); // removes item from top of this Stack
      if (!objectToExamine.getReturnValue().equals(object)) { // gets that item's value, checks if it's removable value
        stackWithoutRemovedObject.push(objectToExamine.getReturnValue()); // if it's NOT equal, adds it to new stack
      }
    }
    while (!stackWithoutRemovedObject.isEmpty()) {
      this.push(stackWithoutRemovedObject.pop().getReturnValue());
    }
  }

}
