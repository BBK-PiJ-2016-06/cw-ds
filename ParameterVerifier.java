/**
* class that has the specific purpose of checking the validity of indexes and objects
* all lists involved needed to verify if the object is null
* all lists involved needed to verify if their indexess were valid values
* made static so no new object of this class for every test is needed
*/

public static class ParameterVerifier {


  /**
	 * takes @param index value and checks for any error value
	 * creates and initializes new returnObject accordingly
	 * @return the appropriate ReturnObject to be used by other methods
	 */
	public ReturnObject verifyIndex(int indexSize, int indexPosition) {
		ReturnObject returnObject;
		if (indexSize == 0) {
			returnObject = new ReturnObject(indexPosition, ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index >= indexSize) {
			returnObject = new ReturnObject(indexPosition, ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			returnObject = new ReturnObject(indexPosition, ErrorMessage.NO_ERROR);
		}
		return returnObject;
	}

	/**
	 * takes @param index value and an Object. Checks if value of item is null, if so
	 * will @return returnObject that has an INVALID_ARGUMENT
	 * if not, it calls upon the simpler verifyIndex method to check validity of
	 */
	public ErrorMessage verifyObject(Object item) {
		ErrorMessage message;
		if (item == null) {
			message = ErrorMessage.INVALID_ARGUMENT;
		} else {
			message = ErrorMessage.NO_ERROR;
		}
		return message;
	}



}
