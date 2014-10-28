
public class FractionCalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionCalculator myCalc = new FractionCalculator();
		
		System.out.println("Welcome to Fraction Calculator by Elmario Husha");
		myCalc.begin();
		
		
	}
	
    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }

}
