import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	
	/**
	 * Scanner that reads input data.
	 */
	private Scanner scanner;
	
	/**
	 * Creates new Scanner.
	 */
	public InputReader () {
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Creates an ArrayList of objects that include their size and digits to be printed.
	 * Checks if input has appropiate structure.
	 * @return ArrayList of LCDNumbers read from input.
	 */
	public ArrayList<LCDNumber> readInput () throws Exception {
		ArrayList<LCDNumber> numberList = new ArrayList<LCDNumber>();
		String line = scanner.nextLine();
		while (!line.equals("0,0")) {
			String [] parts = line.split(",");
			if (parts.length != 2) throw new Exception("Input does not have expected structure");
			int size = Integer.parseInt(parts[0]);
			if(size < 1 || size > 10) throw new Exception("Size should be between 1 and 10");
			int number = Integer.parseInt(parts[1]);
			if(number < 0) throw new Exception("Number should be positive");
			numberList.add(new LCDNumber(size, parts[1]));
			line = scanner.nextLine();
		}
		return numberList;
	}

}
