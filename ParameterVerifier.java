/**
* class that has the specific purpose of checking the validity of indexes and objects
* all lists involved needed to verify if the object is null
* all lists involved needed to verify if their indexess were valid values
* made static so no new object of this class for every test is needed
*/

public final class ParameterVerifier {


  /**
	 * takes @param index value and checks for any error value
	 * creates and initializes new returnObject accordingly
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
	 * takes @param index value and an Object. Checks if value of item is null, if so
	 * will @return ErrorMessage that has an INVALID_ARGUMENT
	 * if not, it calls upon the simpler verifyIndex method to check validity of
	 */
	public static ErrorMessage verifyObject(Object item) {
		ErrorMessage message;
		if (item == null) {
			message = ErrorMessage.INVALID_ARGUMENT;
		} else {
			message = ErrorMessage.NO_ERROR;
		}
		return message;
	}



}
