import java.util.Scanner;
/**
 * 
 * @author mario
 *
 */
public class FractionCalculator {
	private Fraction value;
	private boolean run;
	private String operation;
	
	/**
	 * 
	 * @param initialValue
	 */
	public FractionCalculator() {
		this.run = true;
	}
	
	/**
	 * 
	 * @param input
	 */
	public void evaluate(String input) {
		String[] bits = input.split("/");
		
		int n = Integer.parseInt(bits[0]);
		int d = Integer.parseInt(bits[1]);
		
		if(this.value instanceof Fraction) {
			switch(this.operation) {
				case "+":
					this.value = this.value.add(new Fraction(n, d));
					break;
				case "-":
					this.value = this.value.subtract(new Fraction(n, d));
					break;
				case "/":
					this.value = this.value.divide(new Fraction(n, d));
					break;
				case "*":
					this.value = this.value.multiply(new Fraction(n, d));
					break;
			}
		} else {
			this.value = new Fraction(n, d);
		}
	}
	
	public void begin() {
		Scanner scan = new Scanner(System.in);
		while(this.run) {
			System.out.println("Please enter a command");
			this.run = this.processCommand(scan.nextLine());
		}
	}

	public boolean processCommand(String command) {
		boolean q = false;
		switch(command) {
			case "a":
			case "A":
			case "abs":
				this.value = this.value.absValue(new Fraction(this.value.getNumerator(), this.value.getDenominator()));
				break;
			case "c":
			case "C":
			case "clear":
				this.value = null;
				break;
			case "n":
			case "N":
			case "neg":
				this.value = this.value.negate(new Fraction(this.value.getNumerator(), this.value.getDenominator()));
				break;
			case "q":
			case "Q":
			case "quit":
				q = true;
				break;
			case "+":
			case "-":
			case "/":
			case "*":
				this.operation = command;
				break;
			default:
				if(command.length() == 1) {
					if(Integer.parseInt(command) > 0) {
						Fraction f = new Fraction(Integer.parseInt(command), 1);
						this.evaluate(f.toString());
					}
				} else {
					this.evaluate(command);
				}
				break;
		}
		return q;
	}
}
