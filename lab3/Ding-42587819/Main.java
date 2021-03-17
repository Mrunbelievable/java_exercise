package labs.lab3;

import java.util.ArrayList;

class Main {

	public static int problem1_maxBlock(String str) {
		
		if(str.length()==0 || str==null) return 0;
		int final_max = 0;
		int current_max = 1;
		for(int i=0; i<str.length(); i++) {
			if((i+1)<str.length() && str.charAt(i)==str.charAt(i+1)) {
				current_max = current_max + 1;
				final_max = Math.max(final_max, current_max);
			}
			else {
				current_max = 1;
			}
		}
		
		return final_max;
	}
	
	public static String problem2_sameEnds(String str) {
		int mid = str.length()/2;
		int left_pointer = mid; 
		int right_pointer = mid;
		while(left_pointer>0) {
			String left; // left contain left substring
			String right;// right contain right substring
			if(str.length()%2 == 0 ) {
				left = str.substring(0, left_pointer);
				right = str.substring(right_pointer,str.length());
			}
			else {
				left = str.substring(0, left_pointer);
				right = str.substring(right_pointer+1,str.length());
			}
			if(left.compareTo(right)==0) {
				return left;
			}
			else {
				left_pointer--;
				right_pointer++;
			}
		}
		
		
		return "";
	}
	
	public static boolean problem3_rHappy(String str) {
		
		if(str.indexOf("r")==-1 || str.length()==0) {
			return true;
		}
		else {
			for(int i=0; i<str.length(); i++) {
				int j = i +1;
				if(str.charAt(i)=='r' && str.charAt(j)!='r' && j<str.length()) {
					return false;
				}
				i++;
			}
		}
		
		return true; 
	}
	
	public static int[] problem6_post3(int[] nums) {
		
		int last_index = 0;
		for(int i=0; i<nums.length;i++) {
			if(nums[i]==3) last_index = i;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i=last_index+1; i<nums.length; i++) {
			res.add(nums[i]);
		}
		
		int[] arr = new int[res.size()];
		
		for(int i=0; i<res.size();i++) {
			arr[i] = res.get(i);
		}

		return arr;
	}
	
	public static int problem7_countClumps(int[] nums) {
		
		int clump = 0;
		int series = 1;
		for(int i=0; i<nums.length; i++) {
			int j = i+1;
			if(j<nums.length && (nums[i] == nums[j])) {
				series++;
			}
			else {
				if(series>=2) {
					clump++;
				}
				series = 1;
			}
		}
		
		return clump;
	}

	public static void main(String[] args) {
//		System.out.println(problem1_maxBlock("abbCCCddBBBxx"));
//		System.out.println(problem1_maxBlock("hoopla"));
//		System.out.println(problem2_sameEnds("abcSsabc"));
//		System.out.println(problem3_rHappy(""));
//		System.out.println(problem6_post3(new int[] {1,3,3}));
//		System.out.println(problem7_countClumps(new int[] {1,1,1}));
//		DataSet data = new DataSet();
//		data.add(40);
//		data.add(12.5);
//		data.add(-280.887);
//		data.add(9);
//		System.out.println(data.getSum());
//		System.out.println(data.getAverage());
//		System.out.println(data.getSmallest());
//		System.out.println(data.getLargest());
//		System.out.println(data.getRange());
//		System.out.println(data.getCount());
//		data.add(10);
//		System.out.println(data.getSum());
//		System.out.println(data.getCount());
//		ExperimentData data1 = new ExperimentData(new double[] {3.2, 4.5, 8.0, 9.34, 10.0, 0.75});
//		System.out.println(data1.getValues());

	}
}
