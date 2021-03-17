package labs.lab1;

public class Microwave{
	private int timer;
	private int power;
	public Microwave() {
		timer = 0;
		power = 1;
	}
	
	public void increaseTime() {
		timer += 30;
	}
	
	public void switchPower() {
		if(power==1) {
			power = 2;
		}
		else {
			power = 1;
		}
	}
	
	
	public void reset() {
		timer = 0;
		power = 1;
	}
	
	public String start() {
		return "Cooking for " + String.valueOf(timer) +" seconds at level " + String.valueOf(power);
	}
}