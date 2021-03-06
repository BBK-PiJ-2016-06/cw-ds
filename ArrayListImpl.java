/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 *
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 *
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we have not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}).
 *
 * @author PiJ
 */
public class ArrayListImpl implements List {

	private Object[] objectArray = null;
	private int itemsInArray;

	/**
	 * constructor method initializing the array and setting values to null
	 * @param an int which determines the size of the current object arraySize
	 */
	public ArrayListImpl(int arraySize) {
		objectArray = new Object[arraySize];
		itemsInArray = 0;
	}

	/**
	 * Returns true if the list is empty, false otherwise.
	 *
	 * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty(); {
		if (itemsinArray == 0) {
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
	public int size(); {
		return itemsInArray;
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
	public ReturnObject get(int index); {
		ReturnObjectImpl implObject = ParameterVerifier.verifyIndex(itemsInArray, index);
		if (!implObject.hasError()) {
			implObject.setReturnValue(objectArray[index]);
		}
		ReturnObject result = new ReturnObject();
		result = implObject;
		return result;
	}

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
	public ReturnObject remove(int index); {
		ReturnObjectImpl returnObject = ParameterVerifier.verifyIndex(itemsInArray, index);
		if (!returnObject.hasError()) {
			returnObject.setReturnValue(objectArray[index]);
			objectArray[index] = null; // CHECK THIS- ASK ABOUT ARRAY STRUCTURE. CANNOT HOLD NULL - THEN HOW DO I
			itemsInArray--;						// SHIFT ITS VALUE? MOVE REST OF ELEMENTS DOWN ONE?
		}
		return result;
	}

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordingly.
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
	public ReturnObject add(int index, Object item); {
		ReturnObject returnObject = new returnObject();
		returnObject.set
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
	public ReturnObject add(Object item); {}


}
