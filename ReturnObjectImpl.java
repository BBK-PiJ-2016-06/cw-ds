/**
class which defines all methods used by the ReturnObject interface
Authored by Nathan Hanak
*/

public class ReturnObjectImpl implements ReturnObject {

    private Object returnValue;
    private ErrorMessage errorState;


    /**
  	 * Returns whether there has been an error
  	 * @return whether there has been an error
  	 */
    @Override
  	public boolean hasError() {
      if (errorState != ErrorMessage.NO_ERROR) {
        returnValue = null;
        return true;
      } else {
        return false;
      }
    }

  	/**
  	 * Returns the error message.
  	 *
  	 * This method must return NO_ERROR if and only if
  	 * {@hasError} returns false.
  	 *
  	 * @return the error message
  	 */
    @Override
  	public ErrorMessage getError() {
      return errorState;
    }

  	/**
  	 * Returns the object wrapped in this ReturnObject, i.e. the
  	 * result of the operation if it was successful, or null if
  	 * there has been an error.
  	 *
  	 * Note that the output of this method must be null if {@see
  	 * hasError} returns true, but the opposite is not true: if
  	 * {@see hasError} returns false, this method may or may not
  	 * return null.
  	 *
  	 * @return the return value from the method or null if there has been an error
  	 */
    @Override
  	public Object getReturnValue() {
      if (hasError()) {
        returnValue = null;
      }
      return returnValue;
    }

    /** 1/2 Constructor methods for class
     * Takes @param of an object class and intializes ReturnObjectImpl's member field for successful operations.
     * If operation is successful, it can be assumed the errorState is NO_ERROR
     */
    public ReturnObjectImpl(Object value) {
      returnValue = value;
      errorState = ErrorMessage.NO_ERROR;
    }

    /** 2/2 Constructor methods for class
     * takes @param of an ErrorMessage for failed classes.
     * since operation is unsuccessful, it can be assumed that the object field is null.
     */
    public ReturnObjectImpl(ErrorMessage message) {
      returnValue = null;
      errorState = message;
    }

    /* setter which changes the value of returnValue in this object
     *
     */
    public void setReturnValue(Object newValue) {
      returnValue = newValue;
    }

    /* setter which changes the value of errorState in this object
     */
    public void setErrorMessage(ErrorMessage newMessage) {
      errorState = newMessage;
    }

}
