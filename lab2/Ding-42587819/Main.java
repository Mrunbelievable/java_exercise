package labs.lab2;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Arrays;
//Copy and paste this template into your Main.java file
class Main {

	/**
	 * Returns a string representing the number of hours and minutes between two
	 * military times.
	 * 
	 * @param time1 first time in military format
	 * @param time2 second time in military format
	 */
	public static String problem1_militaryTimeDifference(int time1, int time2) {
		int diff = 0;
		if(time1==time2) return "0 hours 0 minutes";
		
		if(time1<time2) {
			diff = time2 - time1;
		}
		else {
			diff = 2360 - time1 + time2;
		}
		int hours = diff / 100;
		int minutes = (int)(((diff / 100.0) - (diff / 100) ) * 100 );
		
		return hours + " hours " + minutes + " minutes";
	}

	public static void problem2_calculateTotal() {
		Scanner input = new Scanner(System.in); 
		
		System.out.print("Enter price per mask: ");
		double price = input.nextDouble();
		System.out.print("Enter the number of masks: ");
		int number = input.nextInt();
		
		double total = (price * number) * (1+ 7.5/100) + 0.25 * number;
		
		System.out.print("Your total is: $" + total);
		
		input.close();
		
	}

	public static String problem3_getDollarsAndCents(double amount) {
		int dollars = (int) amount;
		

		int cents = (int)(amount*100 - dollars*100);
		
		
		String str = "dollars: " + dollars + '\n' + "cents: " + cents;
		
		return str; 
	}

	public static int problem4_getDiscount(int numMasksBought, int numClientsReferred) {
		if(numMasksBought==0 && numClientsReferred ==0) return 0;
		int total = 0;
		if((numMasksBought + numClientsReferred)>= 75) {
			total = 75;
		}
		else {
			total = (numMasksBought + numClientsReferred);
		}
		
		return total;
	}

	public static void problem5_giveChange() {
		Scanner input = new Scanner(System.in); 
		
		System.out.printf("Enter amount due in cents: ");
		int amount_due = input.nextInt();
		System.out.printf("Enter amount received in cents: ");
		int amount_received = input.nextInt();
		
		int change = amount_received-amount_due;
		
		int dollars = change / 100;
		int quarters = (change - dollars * 100) / 25;
		int dimes = (change - dollars*100 - quarters*25) /10;
		int nickels = (change - dollars*100 - quarters*25 - dimes*10) / 5;
		int pennies = (change - dollars*100 - quarters*25 - dimes*10 - nickels*5) / 1;
		
		System.out.printf("Give the following change: \n");
		System.out.printf("Dollars: %14d\n", dollars);
		System.out.printf("Quarters: %13d\n", quarters);
		System.out.printf("Dimes: %16d\n", dimes);
		System.out.printf("Nickels: %14d\n", nickels);
		System.out.printf("Pennies: %14d\n", pennies);
		
		input.close();
	}

	public static boolean problem6_evenlySpaced(int a, int b, int c) {
		
		int [] array = new int[3];
		array[0] = a;
		array[1] = b;
		array[2] = c;
		Arrays.sort(array);
		
		if((array[1]-array[0])==(array[2]-array[1])) return true;
		return false; 
	}

	public static int problem8_specialSum(int a, int b, int c) {
		
		int result = 0;
		int [] array = new int[3];
		array[0] = a;
		array[1] = b;
		array[2] = c;
		
		for(int i=0; i<3; i++) {
			if(array[i]==13) return result;
			else result += array[i];
		}
		return result; 
	}

	public static void main(String[] args) {
		System.out.println(problem1_militaryTimeDifference(900,1730));
		System.out.println(problem1_militaryTimeDifference(1730,900));
		System.out.println(problem1_militaryTimeDifference(630,731));
		System.out.println(problem1_militaryTimeDifference(603,400));
		System.out.println(problem1_militaryTimeDifference(630,630));
	}
}
