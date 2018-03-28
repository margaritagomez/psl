
public class LCDNumber {
	
	/**
	 * Characters used to print numbers
	 */
	private final static char VERTICAL = '|';
	
	private final static char HORIZONTAL = '_';
	
	private final static char SPACE = ' ';
	
	/**
	 * Given size for the number
	 */
	private int sizeN;
	
	/**
	 * Given number
	 */
	private String strNumber;
	
	/**
	 * Matrix that describes which segments should be drawn. 
	 */
	private boolean [][] mDigits;
	
	/**
	 * Total rows that will be printed
	 */
	private int totalRows;
	
	/**
	 * Creates a new LCDNumber 
	 * @param pSizeN
	 * @param pStrNumber
	 */
	public LCDNumber (int pSizeN, String pStrNumber) {
		sizeN = pSizeN;
		strNumber = pStrNumber;
		mDigits = new boolean [strNumber.length()][7];
		totalRows = sizeN * 2 + 3;
	}
	
	public void printNumber () {
		createDigits();
		int half = totalRows/2;
		String horLine = new String(new char[sizeN]).replace("\0", Character.toString(HORIZONTAL));
		String horSpace = new String(new char[sizeN]).replace("\0", Character.toString(SPACE));
		for (int i=0;i<totalRows;i++) {
			StringBuilder line = new StringBuilder();
			for (int j=0;j<strNumber.length();j++) {
				boolean [] currDesc = mDigits[j];
				char beg = SPACE, end = SPACE;
				String mid = horSpace;
				if (i==0) {
					// Si es 0, miro si se necesita top
					if (currDesc[0]) mid = horLine;
				} else if (i<half) {
					// Si es menos de la mitad miro top-right y top-left
					if (currDesc[5]) beg = VERTICAL;
					if (currDesc[1]) end = VERTICAL;
				} else if (i==half) {
					// Si es la mitad miro mid, top-right y top-left
					if (currDesc[5]) beg = VERTICAL;
					if (currDesc[1]) end = VERTICAL;
					if (currDesc[6]) mid = horLine;
				} else if (i>half && i<totalRows-1) {
					//Si es más de la mitad, miro bottom-right y bottom-left
					if (currDesc[4]) beg = VERTICAL;
					if (currDesc[2]) end = VERTICAL;
				} else {
					//Si es el último, miro bottom, bottom-right y bottom-left
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
	 * 0 Top, 1 top-right, 2 bottom-right, 3 bottom, 4 bottom-left, 5 top-left, 6 middle
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
	
	private String join(char beg, String mid, char end) {
		StringBuilder sb = new StringBuilder();
		sb.append(beg);
		sb.append(mid);
		sb.append(end);
		sb.append(SPACE);
		return sb.toString();
	}

}
