
public class LCDNumber {
	
	// -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
	
	/**
	 * Characters used to print numbers.
	 */
	private final static char VERTICAL = '|';
	
	private final static char HORIZONTAL = '_';
	
	private final static char SPACE = ' ';
	
	// -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

	/**
	 * Given size for the number.
	 */
	private int sizeN;
	
	/**
	 * Given number.
	 */
	private String strNumber;
	
	/**
	 * Matrix that describes which segments should be drawn. 
	 */
	private boolean [][] mDigits;
	
	/**
	 * Total rows that will be printed.
	 */
	private int totalRows;
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
	
	/**
	 * Creates a new LCDNumber.
	 * @param pSizeN Size from input.
	 * @param pStrNumber Number in String format from input.
	 */
	public LCDNumber (int pSizeN, String pStrNumber) {
		sizeN = pSizeN;
		strNumber = pStrNumber;
		mDigits = new boolean [strNumber.length()][7];
		totalRows = sizeN * 2 + 3;
	}
	
	// -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
	
	/**
	 * Prints each line according to values in teh matrix and total row size.
	 */
	public void printNumber () {
		createDigits();
		// Half indicates the row number where the middle horizontal segment should be drawn.
		int half = totalRows/2;
		// Characters between borders should have same size as input size.
		String horLine = new String(new char[sizeN]).replace("\0", Character.toString(HORIZONTAL));
		String horSpace = new String(new char[sizeN]).replace("\0", Character.toString(SPACE));
		// For each line that needs to be printed
		for (int i=0;i<totalRows;i++) {
			StringBuilder line = new StringBuilder();
			// For each digit
			for (int j=0;j<strNumber.length();j++) {
				boolean [] currDesc = mDigits[j];
				char beg = SPACE, end = SPACE;
				String mid = horSpace;
				if (i==0) {
					// Checks if number requires top segment
					if (currDesc[0]) mid = horLine;
				} else if (i<half) {
					// Checks if number requires top-left and top-right segments
					if (currDesc[5]) beg = VERTICAL;
					if (currDesc[1]) end = VERTICAL;
				} else if (i==half) {
					// Checks if number requires top-left, top-right and middle segments
					if (currDesc[5]) beg = VERTICAL;
					if (currDesc[1]) end = VERTICAL;
					if (currDesc[6]) mid = horLine;
				} else if (i>half && i<totalRows-1) {
					// Checks if number requires bottom-left and bottom-right segments
					if (currDesc[4]) beg = VERTICAL;
					if (currDesc[2]) end = VERTICAL;
				} else {
					// Checks if number requires bottom-left, bottom-right and bottom segments
					if (currDesc[4]) beg = VERTICAL;
					if (currDesc[2]) end = VERTICAL;
					if (currDesc[3]) mid = horLine;
				}
				String toAdd = join(beg,mid,end);
				line.append(toAdd);
			}
			System.out.println(line.toString());
		}
	}
	
	/**
	 * Fills the digit matrix with which segments should be drawn, according to each number.
	 * Positions in each row correspond to the following segments:
	 * 0: top, 1: top-right, 2: bottom-right, 3: bottom, 4: bottom-left, 5: top-left, 6: middle
	 */
	private void createDigits () {
		for (int i=0;i<strNumber.length();i++) {
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
				desc = new boolean [] {false, true, true, false, false, true, true};
			else if (dig==5)
				desc = new boolean [] {true, false, true, true, false, true, true};
			else if (dig==6)
				desc = new boolean [] {true, false, true, true, true, true, true};
			else if (dig==7)
				desc = new boolean [] {true, true, true, false, false, false, false};
			else if (dig==8)
				desc = new boolean [] {true, true, true, true, true, true, true};
			else
				desc = new boolean [] {true, true, true, true, false, true, true};
			mDigits[i] = desc;
		}
	}
	
	/**
	 * Joins the three parts of the line, and a final space to separate numbers.
	 * @param beg Beginning of the line.
	 * @param mid String that goes between the beginning and the end.
	 * @param end End of the line.
	 * @return The complete String.
	 */
	private String join(char beg, String mid, char end) {
		StringBuilder sb = new StringBuilder();
		sb.append(beg);
		sb.append(mid);
		sb.append(end);
		sb.append(SPACE);
		return sb.toString();
	}

}
