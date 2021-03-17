package labs.lab2;

public class Rectangle {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	/**
	 * Constructs a Rectangle
	 * 
	 * @param x1 is the upper-left corner x-value
	 * @param y1 is the upper-left corner y-value
	 * @param x2 is the lower-right corner x-value
	 * @param y2 is the lower-right corner y-value
	 */
	public Rectangle(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/**
	 * Gets the orientation of this rectangle
	 * 
	 * @return "square", "portrait", or "landscape"
	 */
	public String getOrientation() {
		String str;
		if(Math.abs(x2-x1) == Math.abs(y2-y1)) {
			str = "square";
		}
		else if(Math.abs(x2-x1) < Math.abs(y2-y1)) {
			str = "portrait";
		}
		else {
			str = "landscape";
		}
		return str;
	}
}
