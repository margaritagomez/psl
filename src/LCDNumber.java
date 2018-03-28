
public class LCDNumber {
	
	private final static String VERTICAL = "|";
	
	private final static String HORIZONTAL = "-";
	
	private int sizeN;
	
	private int prNumber;
	
	private String strNumber;
	
	private LCDDigit [] digits;
	
	private int totalRows;
	
	public LCDNumber (int pSizeN, int pPrNumber) {
		sizeN = pSizeN;
		prNumber = pPrNumber;
		strNumber = String.valueOf(prNumber);
		digits = new LCDDigit [strNumber.length()];
		totalRows = sizeN * 2 + 3;
	}
	
	public void printNumber () {
		createDigits();
		int half = (int) Math.ceil((double)totalRows/2);
		for (int i=0;i<totalRows;i++) {
			String line = "";
			for (int j=0;j<digits.length;j++) {
				int currDigit = digits[i].getDigit();
				boolean [] currDesc = digits[i].getDescription();
				if (i==0) {
					// Si es 0, miro si se necesita top
				} else if (i<half) {
					// Si es menos de la mitad miro top-right y top-left
				} else if (i==half) {
					// Si es la mitad miro mid, top-right y top-left
				} else if (i>half) {
					//Si es más de la mitad, miro bottom-right y bottom-left
				} else {
					//Si es el último, miro bottom, bottom-right y bottom-left
				}
			}
		}
	}
	
	/**
	 * 0 Top, 1 top-right, 2 bottom-right, 3 bottom, 4 bottom-left, 5 top-left, 6 middle
	 */
	private void createDigits () {
		for (int i=0;i<digits.length;i++) {
			int dig = Character.getNumericValue(strNumber.charAt(i));
			boolean [] desc; 
			if (dig==0)
				desc = new boolean [] {true, true, true, true, true, true, false};
			else if (dig==1) 
				desc = new boolean [] {false, true, true, false, false, false, false};
			else if (dig==2)
				desc = new boolean [] {true, true, false, true, true, false, true};
			else if (dig==3)
				desc = new boolean [] {true, true, true, true, false, false, true};
			else if (dig==4)
				desc = new boolean [] {false, true, true, false, true, false, true};
			else if (dig==5)
				desc = new boolean [] {true, false, true, true, false, true, true};
			else if (dig==6)
				desc = new boolean [] {true, false, true, true, true, true, true};
			else if (dig==7)
				desc = new boolean [] {true, true, true, true, false, true, true};
			else if (dig==8)
				desc = new boolean [] {true, true, true, true, true, true, true};
			else
				desc = new boolean [] {true, true, true, true, false, true, true};
			LCDDigit newDigit = new LCDDigit(dig,desc);
			digits[i] = newDigit;
		}
	}

}
