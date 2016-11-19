/**
* class that has the specific purpose of checking the validity of indexes and objects
* all lists involved needed to verify if the object is null
* all requested index positions must be a valid position for the list they are being requested against
* all methods made static so no new object of this class for every test is needed
*/

public final class ParameterVerifier {


  /**
	 * @param  int indexSize is size of data structure
	 * @param int indexPosition is position which will interact with previous data structure
	 * checks to make sure indexPosition is not negative, or of a number that is larger size than the data structure
	 * @return the appropriate ReturnObject to be used by other methods
	 */
	public static ReturnObjectImpl verifyIndex(int indexSize, int indexPosition) {
		ReturnObjectImpl myObject;
		if (indexSize == 0) {
			myObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (indexPosition < 0 || indexPosition >= indexSize) {
			myObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			myObject = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		return myObject;
	}

	/**
	 * takes @param of an object. Checks if value of item is null, if so
	 * will @return ErrorMessage.INVALID_ARGUMENT
	 * if not, @return ErrorMessage.NO_ERROR
	 */
	public static ErrorMessage verifyObject(Object item) {
		ErrorMessage message;
		if (item.equals(null)) {
			message = ErrorMessage.INVALID_ARGUMENT;
		} else {
			message = ErrorMessage.NO_ERROR;
		}
		return message;
	}



}
