
public class LCDDigit {
	
	private int digit;
	
	/**
	 * Top, top-right, bottom-right, bottom, bottom-left, top-left, middle
	 */
	private boolean [] description;
	
	public LCDDigit (int pDigit, boolean [] pDescription) {
		digit = pDigit;
		description = pDescription;
	}
	
	public int getDigit () {
		return digit;
	}
	
	public boolean [] getDescription () {
		return description;
	}

}
