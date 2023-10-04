import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Temperature {
	static MathContext mathContext = new MathContext(6, RoundingMode.HALF_UP);

	public BigDecimal celsiusToSI(BigDecimal celsius) {
		if (celsius.compareTo(BigDecimal.valueOf(-273.15)) < 0) {
			throw new IllegalArgumentException("Celsius temperature cannot be below absolute zero.");
		}
		BigDecimal kelvin;
		if (celsius.compareTo(BigDecimal.ZERO) >= 0) {
			kelvin = celsius.add(BigDecimal.valueOf(273.15));
		} else {
			kelvin = BigDecimal.valueOf(273.15).subtract(celsius.abs());
		}
		return kelvin;
	}

	public BigDecimal fahrenheitToSI(BigDecimal fahrenheit) {
		BigDecimal num32 = new BigDecimal("32");
		BigDecimal division = new BigDecimal("5").divide(new BigDecimal("9"));
		BigDecimal celsius = fahrenheit.subtract(num32).multiply(division);
		return celsius;
	}

	public BigDecimal kelvinToSI(BigDecimal kelvin) {
		return kelvin;
	}

	//
	public BigDecimal siToCelsius(BigDecimal si) {
		if (si.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Kelvin temperature cannot be below absolute zero.");
		}
		BigDecimal celsius;
		if (si.compareTo(BigDecimal.valueOf(273.15)) >= 0) {
			celsius = si.subtract(BigDecimal.valueOf(273.15));
		} else {
			celsius = BigDecimal.valueOf(273.15).subtract(si);
		}
		return celsius;
	}

	public BigDecimal siToFahrenheit(BigDecimal si) {
		BigDecimal division = new BigDecimal("9").divide(new BigDecimal("5"));
        BigDecimal constant = new BigDecimal("459.67");
        BigDecimal fahrenheit = si.multiply(division).subtract(constant);
        return fahrenheit;
	}

	public BigDecimal siToKelvin(BigDecimal si) {
		return si;
	}
	
	public static void driver() {
		try {
			Temperature temperature = new Temperature();
			Mass mass = new Mass();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select the unit from 'A' to 'B' unit");
			System.out.println("1: celsius 2: fahrenheit 3: kelvin ");
			System.out.println("A: ");
			int a = scanner.nextInt(); String unit1="";
			System.out.println("Enter the value: ");
			String input = scanner.next();
			BigDecimal inputValue = new BigDecimal(input);
			System.out.println("1: celsius 2: fahrenheit 3: kelvin ");
			System.out.println("B: ");
			int b = scanner.nextInt(); String unit2="";
			BigDecimal siValue =new BigDecimal("0.0");// would return si value from method
			
			switch (a) {
			case 1: siValue= temperature.celsiusToSI(inputValue);unit1="celsius"; break;
			case 2: siValue= temperature.fahrenheitToSI(inputValue) ;unit1="fahrenheit"; break;
			case 3: siValue= temperature.kelvinToSI(inputValue) ;unit1="kelvin"; break;
			default:break;
			}
//			System.out.println(siValue);
			BigDecimal outputValue=new BigDecimal("0.0");// si to output return from method
			switch (b) {
			case 1: outputValue= temperature.siToCelsius(siValue) ;unit2="celsius"; break;
			case 2: outputValue= temperature.siToFahrenheit(siValue) ;unit2="fahrenheit"; break;
			case 3: outputValue= temperature.kelvinToSI(siValue) ;unit2="kelvin"; break;
			default:break;
			}
			System.out.println(inputValue+" "+unit1+" is " + outputValue+" "+unit2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some thing went wrong try again");
		}
		
	}
}
