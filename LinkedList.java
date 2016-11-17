public class LinkedList implements List {

  private LinkedListNode head = null;
  private int linkedListSize = 0;

  	/**
  	 * Returns true if the list is empty, false otherwise.
  	 *
  	 * @return true if the list is empty, false otherwise.
  	 */
  	public boolean isEmpty() {
      if (linkedListSize == 0) {
        return true;
      } else {
        return false;
      }
    }

  	/**
  	 * Returns the number of items currently in the list.
  	 *
  	 * @return the number of items currently in the list
  	 */
  	public int size() {
      return linkedListSize;
    }

  	/**
  	 * Returns the element at the given position.
  	 *
  	 * If the index is negative or greater or equal than the size of
  	 * the list, then an appropriate error must be returned.
  	 *
  	 * @param index the position in the list of the item to be retrieved
  	 * @return the element or an appropriate error message,
  	 *         encapsulated in a ReturnObject
  	 */
  	public ReturnObject get(int index);

  	/**
  	 * Returns the elements at the given position and removes it
  	 * from the list. The indeces of elements after the removed
  	 * element must be updated accordignly.
  	 *
  	 * If the index is negative or greater or equal than the size of
  	 * the list, then an appropriate error must be returned.
  	 *
  	 * @param index the position in the list of the item to be retrieved
  	 * @return the element or an appropriate error message,
  	 *         encapsulated in a ReturnObject
  	 */
  	public ReturnObject remove(int index);

  	/**
  	 * Adds an element to the list, inserting it at the given
  	 * position. The indeces of elements at and after that position
  	 * must be updated accordignly.
  	 *
  	 * If the index is negative or greater or equal than the size of
  	 * the list, then an appropriate error must be returned.
  	 *
  	 * If a null object is provided to insert in the list, the
  	 * request must be ignored and an appropriate error must be
  	 * returned.
  	 *
  	 * @param index the position at which the item should be inserted in
  	 *              the list
  	 * @param item the value to insert into the list
  	 * @return an ReturnObject, empty if the operation is successful
  	 *         or containing an appropriate error message otherwise
  	 */
  	public ReturnObject add(int index, Object item) {
      LinkedListNode newNode;
      ReturnObjectImpl myObject = new ReturnObjectImpl(ParameterVerifier.verifyObject(item));
      if (!myObject.hasError()) {
        myObject = ParameterVerifier.verifyIndex(linkedListSize, index);
        if (!myObject.hasError()) {
          newNode = new LinkedListNode(item, index);
          LinkedListNode current = head;
          while (!current.getNextNode().getIndex().equals(index)) {
            current = current.getNextNode();
          }
          newNode.setNextNode(current.getNextNode());
          current.setNextNode(newNode);
          newNode.increaseIndexbyOneUntilEndofList(newNode.getNextNode());
          linkedListSize++;
        }
      }
      ReturnObject result = myObject;
      return result;
    }

  	/**
  	 * Adds an element at the end of the list.
  	 *
  	 * If a null object is provided to insert in the list, the
  	 * request must be ignored and an appropriate error must be
  	 * returned.
  	 *
  	 * @param item the value to insert into the list
  	 * @return an ReturnObject, empty if the operation is successful
  	 *         or containing an appropriate error message otherwise
  	 */
  	public ReturnObject add(Object item) {
      ReturnObject myObject = new ReturnObjectImpl(ParameterVerifier.verifyObject(item));
      LinkedListNode newNode;
      if (!myObject.hasError()) {
        if (head.equals(null)) { // if head is null, this item becomes first node
          head = new LinkedListNode(item, linkedListSize);
        } else {
          newNode = new LinkedListNode(item, linkedListSize);
          LinkedListNode current = head;
          while (!current.getNextNode().equals(null)) { // this finds the last item in list
            current = current.getNextNode();
          }
          current.setNextNode(newNode);
        }
        linkedListSize++;
      }
      return myObject;
    }


}
