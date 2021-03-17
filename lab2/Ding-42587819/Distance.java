package labs.lab2;

public class Distance {
	
	private double distance;
	
	public Distance(double meters) {
		distance = meters;
	}
	
	public double getMeters() {
		return distance; 
	}
	
	public double getKilometers() {
		return distance/1000; 
	}
	
	public double getCentimeters() {
		return distance*100;
	}
	
	public double getFeet() {
		return distance*3.2808;
	}
	public double getMiles() {
		return distance*0.000621;
	}
	
	public double getInches() {
		return distance*39.3700; 
	}
}