package labs.lab3;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;
class DataSet{
	private ArrayList<Double> data;

	public DataSet() {
		data = new ArrayList<Double>();
	}
	
	public void add(double value) {
		data.add(value);
	}
	
	public double getSum() {
		BigDecimal sum = new BigDecimal(0);
		for(int i=0; i<data.size(); i++) {
			BigDecimal val = new BigDecimal(data.get(i));
			sum = sum.add(val);
		}
		return sum.doubleValue();
	}
	
	public double getAverage() {
		return getSum() / (data.size());
	}
	
	public double getSmallest() {
		
		Collections.sort(data);
		
		return data.get(0);
	}
	
	public double getLargest() {
		
		Collections.sort(data);
		
		return data.get(data.size()-1);
	}
	
	public double getRange() {
		
		return getLargest() - getSmallest();
	}
	
	public int getCount() {
		return data.size();
	}
}