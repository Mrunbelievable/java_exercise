package labs.lab1;
import java.time.LocalDate;
import java.util.Random;
//Copy and paste this template into your Main.java file
class Main {
	public static String problem1_firstLastN(String str, int n) {
		String s1 = str.substring(0,n);
		String s2 = str.substring(str.length()-1-(n-1),str.length());
		return s1+s2; 
	}
	
	public static String problem2_middle(String str) {
		int mid = str.length()/2;
		
		return str.substring(mid-1,mid+1); 
	}
	
	public static String problem3_rollDie() {
		Random rand = new Random();
		int bound = 7;
		String str = "";
		for(int i =0; i<5; i++) {
			int rand_number = rand.nextInt(bound);
			str += String.valueOf(rand_number);
			str += " ";
		}
		return str.substring(0,9); 
	}
	
	public static String problem4_reverseAndInsert(String str1, int num) {
		String s1 = str1.substring(str1.length()-1,str1.length()) + String.valueOf(num);
		StringBuilder input = new StringBuilder();
		input.append(str1.substring(0,str1.length()-1));
		input = input.reverse();
		return s1+input; 
	}
	
	public static String problem5_getDayOfWeek(int month, int day, int year) {
		String str = "";
		if(month<10 && day<10) {
			 str = String.valueOf(year) + "-0" + String.valueOf(month) + "-0" + String.valueOf(day);
		}
		else if(month>=10 && day<10) {
			 str = String.valueOf(year) + "-" + String.valueOf(month) + "-0" + String.valueOf(day);
		}else if(month<10 && day>=10) {
			 str = String.valueOf(year) + "-0" + String.valueOf(month) + "-" + String.valueOf(day);
		}else {
			 str = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
		}
		LocalDate date = LocalDate.parse(str);
		return date.getDayOfWeek().toString();
	}

	public static void main(String[] args) {

	}
}
