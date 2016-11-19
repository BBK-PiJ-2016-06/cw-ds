/**
 * An implementation of @see FunctionalList that extends @see ArrayList
 * @author NathanHanak
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

    /**
     * Returns the element at the beginning of the list. Using @see ArrayList#get to return
     * the element at index position 0
     * @see FunctionalList#head
     */
    @Override
    public ReturnObject head() {
      return get(0);
    }

    /**
     * Returns a list with the elements in this list except the
     * head.
     * @ see FunctionalList#rest
     */
    @Override
    public FunctionalList rest() {
      FunctionalArrayList newFunctList = this;
      newFunctList.remove(0);
      FunctionalList result = newFunctList;
      return result;
    }
}
