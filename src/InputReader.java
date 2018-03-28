import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	
	private Scanner scanner;
	
	public InputReader () {
		scanner = new Scanner(System.in);
	}
	
	public ArrayList<LCDNumber> readInput() throws Exception {
		ArrayList<LCDNumber> numberList = new ArrayList<LCDNumber>();
		String line = scanner.nextLine();
		while (!line.equals("0,0")) {
			String [] parts = line.split(",");
			if (parts.length != 2) throw new Exception("Input does not have expected structure");
			int size = Integer.parseInt(parts[0]);
			if(size < 1 || size > 10) throw new Exception("Size should be between 1 and 10");
			int number = Integer.parseInt(parts[1]);
			if(number < 0) throw new Exception("Number should be positive");
			numberList.add(new LCDNumber(size, number));
			line = scanner.nextLine();
		}
		return numberList;
	}

}
