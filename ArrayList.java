/**
 * @see List
 * @author NathanHanak
 */
public class ArrayList implements List {

	private Object[] objectArray = new Object[0];
	private int itemsInArray = 0;

	/**
	 * @see List#isEmpty
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @see List#size
	 */
	@Override
	public int size() {
		return itemsInArray;
	}

	/**
	 *
	 *@see List#get(int index);
	 */
	@Override
	public ReturnObject get(int index) {
		ReturnObjectImpl implObject = ParameterVerifier.verifyIndex(itemsInArray, index);
		if (!implObject.hasError()) {
			implObject.setReturnValue(objectArray[index]);
		}
		ReturnObject result = implObject;
		return result;
	}

	/**
	 * Returns the element wrapped in a ReturnObject at the given position and removes it
	 * @see List#remove
	 */
	@Override
	public ReturnObject remove(int index) {
		ReturnObjectImpl myObject = ParameterVerifier.verifyIndex(itemsInArray, index);
		if (!myObject.hasError()) {
			myObject.setReturnValue(objectArray[index]);
			for (int i = index; i <  (itemsInArray - 1); i++) { // moves all elements of array after removed element down
				objectArray[i] = objectArray[i + 1];	//  one. Leaving last two index positions to be the same.
			}
			itemsInArray--;
			Object[] replacementArray = new Object[itemsInArray]; // create a new temporary array 1 size smaller to hold
			for (int i = 0; i < replacementArray.length; i++) { // same values of original array minus deleted element
				replacementArray[i] = objectArray[i];
			}
			objectArray = replacementArray; // the original array is replaced with shorter array
		}
		ReturnObject result = myObject;
		return result;
	}

	/**
	 * adds an element of @param (Object Item) at a location of (int index);
	 * @see List#add(int index, Object item);
	 */
  @Override
	public ReturnObject add(int index, Object item) {
		ReturnObjectImpl myObject = new ReturnObjectImpl(ParameterVerifier.verifyObject(item));
		ReturnObject result;
			if (!myObject.hasError()) {
				myObject = ParameterVerifier.verifyIndex(itemsInArray, index);
				if (!myObject.hasError()) {
					Object[] replacementArray = new Object[itemsInArray + 1];
					for (int i = 0; i < index; i++) {
						replacementArray[i] = objectArray[i];
					}
					replacementArray[index] = item;
					for (int i = index; i < itemsInArray; i++) {
						replacementArray[i + 1] = objectArray[i];
					}
					objectArray = replacementArray;
					itemsInArray++;
				}
			}
			result = myObject;
		}
		return result;
	}

	/**
	 * Adds an element at the end of the list.
	 *@see List#add(Object item);
	 */
	@Override
	public ReturnObject add(Object item) {
		ReturnObjectImpl myObject =  new ReturnObjectImpl(ParameterVerifier.verifyObject(item));
		if (!myObject.hasError()) {
			Object[] replacementArray = new Object[itemsInArray + 1];
			for (int i = 0; i < itemsInArray; i++) {
				replacementArray[i] = objectArray[i];
			}
			replacementArray[itemsInArray] = item;
			objectArray = replacementArray;
			itemsInArray++;
		}
		ReturnObject result = myObject;
		return result;
	}

}
