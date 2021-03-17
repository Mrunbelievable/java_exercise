package labs.lab1;

public class Bug{
	private int position;
	private int direction = 1; // 1 means direction to right, -1 means to left
	public Bug(int initialPosition) {
		position = initialPosition;
	}
	
	public void turn() {
		direction = -direction;
	}
	
	public void move() {
		if(direction ==1 ) {
			position +=1;
		}
		else {
			position -=1;
		}
	}
	
	public int getPosition() {
		
		return position;
	}
	
}