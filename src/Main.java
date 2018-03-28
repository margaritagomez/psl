import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		InputReader ir = new InputReader();
		ArrayList<LCDNumber> lcdNumbers = ir.readInput();
		for (int i=0; i<lcdNumbers.size();i++) {
			LCDNumber currNumber = lcdNumbers.get(i);
			currNumber.printNumber();
		}
	}

}
