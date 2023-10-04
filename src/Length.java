import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Length {
	static MathContext mathContext = new MathContext(6, RoundingMode.HALF_UP	);
	public BigDecimal mmToSI(BigDecimal mm) {
		return mm.divide(new BigDecimal("1000"),10, RoundingMode.HALF_UP);
	}
	public BigDecimal cmToSI(BigDecimal mm) {
		return mm.divide(new BigDecimal("100"),10, RoundingMode.HALF_UP);
	}
	public BigDecimal umToSI(BigDecimal mm) {
		return mm.divide(new BigDecimal("1000000"),10, RoundingMode.HALF_UP);
	}
	public BigDecimal mToSI(BigDecimal mm) {
		return mm;
	}
	public BigDecimal siToMm(BigDecimal m) {
		return m.multiply(new BigDecimal("1000"));
	}
	public BigDecimal siToCm(BigDecimal m) {
		return m.multiply(new BigDecimal("100"));
	}
	public BigDecimal siToUm(BigDecimal m) {
		return m.multiply(new BigDecimal("1000000"));
	}
	public BigDecimal siToM(BigDecimal m) {
		return m;
	}
	
	public static void driver() {
		Length length = new Length();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the unit from 'A' to 'B' unit");
		System.out.println("1: mm 2: cm 3: um 4: m");
		System.out.println("A: ");
		int a = scanner.nextInt(); String unit1="";
		System.out.println("Enter the value: ");
		String input = scanner.next();
		BigDecimal inputValue = new BigDecimal(input);
		System.out.println("1: mm 2: cm 3: um 4: m");
		System.out.println("B: ");
		int b = scanner.nextInt(); String unit2="";
		BigDecimal siValue =new BigDecimal("0.0");// would return si value from method
		
		switch (a) {
		case 1: siValue= length.mmToSI(inputValue) ;unit1="mm"; break;
		case 2: siValue= length.cmToSI(inputValue) ;unit1="cm"; break;
		case 3: siValue= length.umToSI(inputValue) ;unit1="um"; break;
		case 4: siValue= length.mToSI(inputValue) ;unit1="m"; break;
		default:break;
		}
//		System.out.println(siValue);
		BigDecimal outputValue=new BigDecimal("0.0");// si to output return from method
		switch (b) {
		case 1: outputValue= length.siToMm(siValue) ;unit2="mm"; break;
		case 2: outputValue= length.siToCm(siValue) ;unit2="cm"; break;
		case 3: outputValue= length.siToUm(siValue) ;unit2="um"; break;
		case 4: outputValue= length.siToM(siValue) ;unit2="m"; break;
		default:break;
		}
		System.out.println(inputValue+" "+unit1+" is " + outputValue+" "+unit2);
	}
}
