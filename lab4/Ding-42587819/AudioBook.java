package labs.lab4;

public class AudioBook extends Book{
	private double playingTime;
	private static int check_max=0;
	
	public AudioBook(String title, String author, double playingTime) {
		super(title, author);
		this.playingTime = playingTime;
	}
	
	public double getPlayingTime() {
		return playingTime;
	}
	
	public void setPlayingTime(double playingTime) {
		this.playingTime = playingTime;
	}
	
	public String checkOut() {
		String str = "";
		if(check_max <3) {
			super.setCheckedOut(true);
			check_max++;
			str = "28 days";
		}
		else {
			str = "NOT ALLOWED";
		}
		return str;
	}
	
	public void checkIn() {
		super.checkIn();
		check_max--;
	}
	
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		
		if(otherObject instanceof AudioBook) {
			AudioBook other = (AudioBook) otherObject;
			return playingTime == other.getPlayingTime();
		}
		return false;
	}
}