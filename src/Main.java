import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Welcome to unit conversion app :)");
		while (true) {
			System.out.println("Select the which physical property do want to ");
			System.out.println("1: Length 2: Mass 3: Temperature 4: Speed ");
			System.out.println("10: Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Length.driver();
				break;
			case 2:
				Mass.driver();
				break;
			case 3:
				Temperature.driver();
				break;
			case 4:
				Speed.driver();
				break;
			default:
				return;
			}
		}
	}
}
