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

  public void setIndex(int newIndex) {
    this.index = newIndex;
  }


}
