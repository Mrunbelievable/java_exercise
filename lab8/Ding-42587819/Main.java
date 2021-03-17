package labs.lab8;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static <T, S> Pair problem1_swap(Pair<T, S> obj) {
		
		T t = obj.getFirst();
		S s = obj.getSecond();
		
		return new Pair<>(s, t);
	}
	
	
	public static <T extends Comparable<T>> Pair problem5_minmax(T[] array) {
		
		T max = array[0];
		T min = array[0];
		
		for(T t: array) {
			if(t.compareTo(max)>0) {
				max = t;
			}
		}
		for(T t: array) {
			if(t.compareTo(min)<0) {
				min = t;
			}
		}
		return new Pair<>(min, max);
	}
	
	public static <T, U> void problem3_append(ArrayList<T> obj, ArrayList<U> obj2){
		T t = obj.get(0);
		Class c = t.getClass();

		U s = obj2.get(0);
		Class c2 = s.getClass();
		
		if(c.isAssignableFrom(c2)) {
			for(U item : obj2) {
				obj.add((T) item);
			}
		}
	}
	
	public static <T> ArrayList problem4_reverse(ArrayList<T> list) {
		
		Stack<T> stack = new Stack<>();
		for(T item: list) {
			stack.add(item);
		}
		int n = stack.size();
		ArrayList<T> res = new ArrayList<>();
		for(int i=0; i<n; i++) {
			res.add(stack.pop());
		}
		return res;
	}
	
}
