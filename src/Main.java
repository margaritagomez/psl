import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<LCDNumber> lcdNumbers = InputReader.readInput();
		for (LCDNumber currNumber : lcdNumbers) {
			currNumber.printNumber();
		}
	}
	
}
