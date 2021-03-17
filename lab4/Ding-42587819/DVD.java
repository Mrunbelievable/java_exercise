package labs.lab4;
import java.util.ArrayList;


public class DVD extends LibraryItem{
	private ArrayList<String> actors;
	
	public DVD(String title, ArrayList<String> actors){
		super(title);
		this.actors = new ArrayList<String>(actors);
	}
	
	public ArrayList<String> getActors(){
		
		return this.actors;
	}
	
	public void setActors(ArrayList<String> actors) {
		this.actors = new ArrayList<String>(actors);
	}
	
	public String checkOut() {
		
		String str = "";
		
		if(!super.isCheckedOut()) {
			super.setCheckedOut(true);
			str = "7 days";
		}
		else {
			str = "NOT ALLOWED";
		}
		
		return str;
	}
	
	public boolean equals(Object otherObject) {
		
		if(!super.equals(otherObject)) return false;
		
		if(otherObject instanceof DVD) {
			DVD other = (DVD) otherObject;
			return actors.equals(other.getActors());
		}
		
		return false;
	}
}