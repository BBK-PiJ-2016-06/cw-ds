public class LinkedList implements List {

  private LinkedListNode head = null;
  private int linkedListSize = 0;

  	/**
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
  	 * @return the number of items currently in the list.
  	 */
  	public int size() {
      return linkedListSize;
    }

  	/**
  	 * Returns the element at the given position.
  	 * @see List#get
  	 */
  	public ReturnObject get(int index) {
      ReturnObjectImpl myObject = ParameterVerifier.verifyIndex(linkedListSize, index);
      ReturnObject result;
      if (!myObject.hasError()) {
        if (index == 0) {
          myObject = new ReturnObjectImpl(head.getValue());
        } else {
          LinkedListNode current = head;
          while (current.getNextNode().getIndex() != index) {
            current = current.getNextNode();
          }
          myObject = new ReturnObjectImpl(current.getNextNode().getValue());
        }
      }
      result = myObject;
      return result;
    }

  	/**
  	 * Returns the elements at the given position and removes it
  	 * from the list.
     * @see List#remove(int index)
  	 */
  	public ReturnObject remove(int index) {
      ReturnObjectImpl myObject = ParameterVerifier.verifyIndex(linkedListSize, index);
      if (!myObject.hasError()) {
        if (index == 0) {
          myObject = new ReturnObjectImpl(head.getValue());
          head = head.getNextNode();
        } else {
          LinkedListNode current = head;
          while (current.getNextNode().getIndex() != index ) { // finds the value of current.getNext() that equals
            current = current.getNextNode();        // the desired index to remove
          }
          myObject = new ReturnObjectImpl(current.getNextNode().getValue());
          if (current.getNextNode().getIndex() == (linkedListSize-1)) {
            current.setNextNode(null);
          } else {
            current.setNextNode(current.getNextNode().getNextNode());
          }
        }
        linkedListSize--;
      }
      reWriteIndex();
      ReturnObject result = myObject;
      return result;
    }

  	/**
  	 * Adds an element to the list, inserting it at the given
  	 * position.
     * @see List#add(int index, Object item)
  	 */
  	public ReturnObject add(int index, Object item) {
      LinkedListNode newNode;
      ReturnObjectImpl myObject = new ReturnObjectImpl(ParameterVerifier.verifyObject(item));
      if (!myObject.hasError()) {
        myObject = ParameterVerifier.verifyIndex(linkedListSize, index);
        if(index == 0 && isEmpty()) { // if trying to add an item at index 0 to an empty list, calls on add(item);
          add(item);
        } else {
            if (!myObject.hasError()) {
              newNode = new LinkedListNode(item, index);
              if (newNode.getIndex() == 0) {
                newNode.setNextNode(head);
                head = newNode;
              } else {
                LinkedListNode current = head;
                while ( current.getNextNode().getIndex() != index) {
                  current = current.getNextNode();
                }
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
              }
              linkedListSize++;
            }
          }
      }
      reWriteIndex();
      ReturnObject result = myObject;
      return result;
    }

  	/**
  	 * Adds an element at the end of the list.
  	 * @see List#add(Object item)
  	 */
  	public ReturnObject add(Object item) {
      ReturnObject myObject = new ReturnObjectImpl(ParameterVerifier.verifyObject(item));
      LinkedListNode newNode;
      if (!myObject.hasError()) {
        if (linkedListSize == 0 ) { // if head is null, this item becomes first node
          head = new LinkedListNode(item, linkedListSize);
        } else {
          newNode = new LinkedListNode(item, linkedListSize);
          LinkedListNode current = head;
          while (current.getNextNode() != null ) { // this finds the last item in list
            current = current.getNextNode();
          }
          current.setNextNode(newNode);
        }
        linkedListSize++;
      }
      return myObject;
    }

    /**
     * re-writes the index for all objects by starting at the first element and going to the end.
     * called whenever an object is removed or added to the linked list
     */
    public void reWriteIndex() {
      LinkedListNode current = head;
      int whate;
      for (int i = 0; i < linkedListSize; i++) {
        current.setIndex(i);
        if (current.getNextNode() != null) {
          current = current.getNextNode();
        }
      }
    }


}
