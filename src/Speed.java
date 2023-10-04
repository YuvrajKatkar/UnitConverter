import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Speed {
	static MathContext mathContext = new MathContext(6, RoundingMode.HALF_UP);
	
	public BigDecimal meterspersecToSi(BigDecimal meterspersec) {
		return meterspersec;
	}
	public BigDecimal kilometerperhourToSI(BigDecimal kilometerperhour) {
		 BigDecimal factor = new BigDecimal("5").divide(new BigDecimal("18"),mathContext);
		return kilometerperhour.multiply(factor);
	}
	public BigDecimal milesperhourToSi(BigDecimal milesperhour) {
		return milesperhour.multiply(new BigDecimal("0.44704"));
	}
	public BigDecimal feetpersecToSi(BigDecimal feetpersec) {
		return feetpersec.multiply(new BigDecimal("0.3048"));
	}
	//
	public BigDecimal siToMeterpersec(BigDecimal si) {
		return si;
	}
	public BigDecimal siToKilometerperhour(BigDecimal si) {
		return si.multiply(new BigDecimal("3.6"));
	}
	public BigDecimal siToMilesperhour(BigDecimal si) {
		return  si.multiply(new BigDecimal("2.23694"));
	}
	public BigDecimal siToFeetpersec(BigDecimal si) {
		return si.multiply( new BigDecimal("3.28084"));
	}
	public static void driver() {
		Speed speed = new Speed();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the unit from 'A' to 'B' unit");
		System.out.println("1: m/s 2: km/hr 3: miles/hr 4: feet/sec");
		System.out.println("A: ");
		int a = scanner.nextInt(); String unit1="";
		System.out.println("Enter the value: ");
		String input = scanner.next();
		BigDecimal inputValue = new BigDecimal(input);
		System.out.println("1: m/s 2: km/hr 3: miles/hr 4: feet/sec");
		System.out.println("B: ");
		int b = scanner.nextInt(); String unit2="";
		BigDecimal siValue =new BigDecimal("0.0");// would return si value from method
		
		switch (a) {
		case 1: siValue= speed.meterspersecToSi(inputValue) ;unit1="m/s"; break;
		case 2: siValue= speed.kilometerperhourToSI(inputValue) ;unit1="km/hr"; break;
		case 3: siValue= speed.milesperhourToSi(inputValue) ;unit1="miles/hr"; break;
		case 4: siValue= speed.feetpersecToSi(inputValue) ;unit1="feet/sec"; break;
		default:break;
		}
//		System.out.println(siValue);
		BigDecimal outputValue=new BigDecimal("0.0");// si to output return from method
		switch (b) {
		case 1: outputValue= speed.siToMeterpersec(siValue) ;unit2="m/s"; break;
		case 2: outputValue= speed.siToKilometerperhour(siValue) ;unit2="km/hr"; break;
		case 3: outputValue= speed.siToMilesperhour(siValue) ;unit2="miles/hr"; break;
		case 4: outputValue= speed.siToFeetpersec(siValue) ;unit2="feet/sec"; break;
		default:break;
		}
		System.out.println(inputValue+" "+unit1+" is " + outputValue+" "+unit2);
	}
}
