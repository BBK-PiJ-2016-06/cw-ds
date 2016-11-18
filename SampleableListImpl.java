/**
 * An implementation of interface @see SampleableList
 *
 * @author NathanHanak
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

	/**
	 * Creates a new Sampleable list based on the current SampleableList by taking
	 * values from the index of 0 and even numbers (index 0 is the first, index 2 is the third item, etc.)
	 * and adding them to a new list
	 * @see SampleableList#sample
	 *
	 * @return a list containing the first, third, fifth... items of this list
	 */
	@Override
	public SampleableList sample() {
		SampleableList result = new SampleableListImpl();
		if (!this.isEmpty()) {
			for (int indexLocation = 0; indexLocation < this.size(); indexLocation++) {
				if (indexLocation == 0 || indexLocation % 2 == 0) {
					result.add(this.get(indexLocation).getReturnValue());
				}
			}
		}
		return result;
	}

}
