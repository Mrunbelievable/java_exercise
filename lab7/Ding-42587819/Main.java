package labs.lab7;

import java.util.Stack;
import java.util.Scanner;

public class Main {
	public static boolean problem1_contains6(int[] nums, int index) {
		if(index > nums.length-1) return false;
		if(nums[index] == 6) return true;
		return problem1_contains6(nums, index+1);
	}

	public static String problem2_parenPart(String str) {
		int x = 0;
		int y = str.length()-1;

		if(str.charAt(x) != '(' ) {
			x++;
		}
		if(str.charAt(y) != ')' ) {
			y--;
		}
		if(str.charAt(x) == '('  && str.charAt(y) == ')') return str.substring(x, y+1);
		
		return problem2_parenPart(str.substring(x, y+1));

	}

	public static String problem3_removeAdjacentDuplicates(String str) {
		if(str.length() == 0 || str.isEmpty()) return "";
		if(str.length() == 1 ) return str;
		
		if(str.charAt(0) == str.charAt(1)) {
			 return "" + problem3_removeAdjacentDuplicates(str.substring(1));
		}
		
		String temp = str.substring(0, 1);
		return temp + problem3_removeAdjacentDuplicates(str.substring(1));
		
	}

	public static String problem9_reverse(String sentences) {
		Stack<String> stack = new Stack<String>();
		Scanner in = new Scanner(sentences);
		String str = "";
		while(in.hasNext()) {
			String temp = in.next();
			if(temp.charAt(temp.length()-1) == '.') {
				temp = temp.replace(".",  "");
				String temp2 = temp.substring(0,1).toUpperCase() + temp.substring(1);
				str += temp2;
				str += " ";
				int size = stack.size();
				for(int i=0; i<size; i++) {
					if(i==size-1) {
						str += stack.pop();
						str += ".";
						str += " ";
					}else {
						str += stack.pop();
						str += " ";
					}
				}
			}else {
				stack.add(temp.toLowerCase());
			}
		}
		
		return str.trim();
	}
	
//	public static void main(String[] args) {
////		System.out.println(problem1_contains6(new int[] {1, 6, 4}, 0));
////		System.out.println(problem1_contains6(new int[] {1, 4}, 0));
////		System.out.println(problem1_contains6(new int[] {6}, 0));
////		System.out.println(problem1_contains6(new int[] {0}, 0));
////		System.out.println(problem2_parenPart("xyz(abc)123"));
////		System.out.println(problem2_parenPart("x(hello)"));
////		System.out.println(problem2_parenPart("(xy) 1"));
////		System.out.println(problem2_parenPart("()"));
////		System.out.println(problem3_removeAdjacentDuplicates("yyzzza"));
////		System.out.println(problem3_removeAdjacentDuplicates("abbbcdd"));
////		System.out.println(problem3_removeAdjacentDuplicates("Hello"));
////		System.out.println(problem3_removeAdjacentDuplicates("123"));
////		System.out.println(problem3_removeAdjacentDuplicates(""));
////		System.out.println(problem3_removeAdjacentDuplicates("  "));
////		System.out.println(problem9_reverse("Mary had afjdkslfaj874928374 888 little lamb. , s Its fleece was white as snow -."));
//	}
}
