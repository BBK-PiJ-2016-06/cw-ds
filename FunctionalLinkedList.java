/**
 * An implementation of @see FunctionalList that extends @see LinkedList
 * @author NathanHanak
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

  /**
   * Returns the element at the beginning of the list.
   *
   * If the list is empty, an appropriate error is returned.
   *
   * @return a copy of the element at the beginning of the list or
   *         an error if the list is empty.
   */
  @Override
  public ReturnObject head() {
    return get(0);
  }

  /**
   * Returns a list with the elements in this list except the
   * head. The elements must be in the same order. The original list
   * must not change or be affected by changes in the new list.
   *
   * If the list is empty, another empty list is returned.
   */
  @Override
  public FunctionalList rest() {
      FunctionalLinkedList newFunctList = this;
      newFunctList.remove(0);
      FunctionalList result = newFunctList;
      return result;
  }
  
}
