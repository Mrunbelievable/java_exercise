package labs.lab3;

import java.util.ArrayList;

public class Sequence {
	private ArrayList<Integer> values;

	public Sequence() {
		values = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getValues() {
		return values;
	}

	public void add(int n) {
		values.add(n);
	}

	public String toString() {
		return values.toString();
	}
	
	public Sequence append(Sequence s) {
		
		Sequence res = new Sequence();
		
		ArrayList<Integer> arr = s.values;
		
		for(int i=0; i<values.size(); i++) {
			res.add(values.get(i));
		}
		for(int i=0; i<arr.size(); i++) {
			res.add(arr.get(i));
		}
		return res;
	}
	
	public Sequence merge(Sequence other) {
		Sequence res = new Sequence();
		
		int len1 = values.size(); // 4
		int len2 = other.values.size(); // 5
		
		if(len1 < len2) {
			int count = 0;
			for(int i=0; i<len1; i++) {
				res.add(values.get(i));
				res.add(other.values.get(i));
				count=i;
			}
			while(count+1<len2) {
				res.add(other.values.get(count+1));
				count++;
			}
		}
		else if( len1 == len2) {
			for(int i=0; i<len1; i++) {
				res.add(values.get(i));
				res.add(other.values.get(i));
			}
		}
		else {
			int count = 0;
			for(int i=0; i<len2; i++) {
				res.add(values.get(i));
				res.add(other.values.get(i));
				count=i;
			}
			while(count+1<len1) {
				res.add(values.get(count+1));
				count++;
			}
		}
		
		return res;
	}
}