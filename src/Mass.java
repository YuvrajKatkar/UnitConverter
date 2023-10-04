import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Mass {
	static MathContext mathContext = new MathContext(6, RoundingMode.HALF_UP);
	public BigDecimal gramToSI(BigDecimal gram) {
		return gram.divide(new BigDecimal("1000"),mathContext);
	}
	public BigDecimal hectogramToSI(BigDecimal hectogram) {
		return hectogram.divide(new BigDecimal("10"),mathContext);
	}
	public BigDecimal kilogramToSI(BigDecimal kilogram) {
		return kilogram;
	}
	public BigDecimal tonToSI(BigDecimal ton) {
		return ton.multiply(new BigDecimal("1000"));
	}
	//
	public BigDecimal SIToGram(BigDecimal si) {
		return si.multiply(new BigDecimal("1000"));
	}
	public BigDecimal SITohectogram(BigDecimal si) {
		return si.multiply(new BigDecimal("10"));
	}
	public BigDecimal SIToKilogram(BigDecimal si) {
		return si;
	}
	public BigDecimal SIToTon(BigDecimal si) {
		return si.divide(new BigDecimal("1000"), mathContext);
	}
	public static void driver() {
		Mass mass = new Mass();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the unit from 'A' to 'B' unit");
		System.out.println("1: gram 2: hectogram 3: kilogram 4: ton");
		System.out.println("A: ");
		int a = scanner.nextInt(); String unit1="";
		System.out.println("Enter the value: ");
		String input = scanner.next();
		BigDecimal inputValue = new BigDecimal(input);
		System.out.println("1: gram 2: hectogram 3: kilogram 4: ton");
		System.out.println("B: ");
		int b = scanner.nextInt(); String unit2="";
		BigDecimal siValue =new BigDecimal("0.0");// would return si value from method
		
		switch (a) {
		case 1: siValue= mass.gramToSI(inputValue);unit1="gram"; break;
		case 2: siValue= mass.hectogramToSI(inputValue) ;unit1="hectogram"; break;
		case 3: siValue= mass.kilogramToSI(inputValue) ;unit1="kilogram"; break;
		case 4: siValue= mass.tonToSI(inputValue) ;unit1="ton"; break;
		default:break;
		}
//		System.out.println(siValue);
		BigDecimal outputValue=new BigDecimal("0.0");// si to output return from method
		switch (b) {
		case 1: outputValue= mass.SIToGram(siValue) ;unit2="gram"; break;
		case 2: outputValue= mass.SITohectogram(siValue) ;unit2="hectogram"; break;
		case 3: outputValue= mass.SIToKilogram(siValue) ;unit2="kilogram"; break;
		case 4: outputValue= mass.SIToTon(siValue) ;unit2="ton"; break;
		default:break;
		}
		System.out.println(inputValue+" "+unit1+" is " + outputValue+" "+unit2);
	}
}
