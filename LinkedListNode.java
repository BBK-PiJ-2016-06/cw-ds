public class LinkedListNode {

  private Object value;
  private int index;
  private LinkedListNode nextNode = null;

  /*constructor method for LinkedListNode taking @param of an object to initialize
  */
  public LinkedListNode(Object value, int index) {
    this.value = value;
    this.index = index;
  }

  public Object getValue() {
    return value;
  }

  public LinkedListNode getNextNode() {
    return nextNode;
  }

  public void setValue(Object newValue) {
    value = newValue;
  }

  public void setNextNode(LinkedListNode newNext) {
    nextNode = newNext;
  }

  public int getIndex() {
    return index;
  }

  public void increaseIndexbyOneUntilEndofList(LinkedListNode node) {
    this.index++;
    while ( !nextNode.equals(null)) {
      increaseIndexbyOneUntilEndofList(nextNode);
    }
  }

  public void decreaseIndexbyOneUntilEndofList(LinkedListNode node) {
    this.index--;
    while ( !nextNode.equals(null)) {
      decreaseIndexbyOneUntilEndofList(nextNode);
    }
  }


  /*wraps this node of LinkedListNode
   * @return this node as a returnObject THIS MAY BE EXCESSIVE
   */
  public ReturnObject wrapNode() {
    ReturnObject nodeAsReturnObject;
    if (getValue().equals(null)) {
      nodeAsReturnObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
    } else {
        nodeAsReturnObject = new ReturnObjectImpl(this.value);
    }
    return nodeAsReturnObject;
  }

}
