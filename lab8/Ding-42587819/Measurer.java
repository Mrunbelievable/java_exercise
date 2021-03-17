package labs.lab8;

public interface Measurer<T> {
	/**
	 * Computes the measure of an object.
	 * 
	 * @param anObject the object to be measured
	 * @return the measure
	 */
	double measure(T anObject);
	
	public static <T> T max(T[] values, Measurer<T> meas) {
		if(values.length==0 || values ==null) return null;
		
		T res = values[0];
		for(T obj: values) {
			if(meas.measure(res) <= meas.measure(obj) ) res = obj;
		}
		return res;
	}
	

}
