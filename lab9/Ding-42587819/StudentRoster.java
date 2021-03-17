package labs.lab9;

public class StudentRoster {
	private String name;
	private int index;
	private String number;
	private String tuition;
	private String type;
	private String notes;
	private boolean agility;
	private boolean obedience1;
	private boolean obedience2;
	private boolean puppy;
	private boolean tricks;
	
	public StudentRoster() {
		
	}
	
	public StudentRoster(String name, String number, String tuition, String type) {
		this.name = name;
		this.number = number;
		this.tuition = tuition;
		this.type = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBreed(int index) {
		this.index = index;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void setAgility(boolean agility) {
		this.agility = agility;
	}
	
	public void setObedience1(boolean obedience1) {
		this.obedience1 = obedience1;
	}
	
	public void setObedience2(boolean obedience2) {
		this.obedience2 = obedience2;
	}
	
	public void setPuppy(boolean puppy) {
		this.puppy = puppy;
	}
	
	public void setTricks(boolean tricks) {
		this.tricks = tricks;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBreed() {
		return index;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getTuition() {
		return tuition;
	}
	
	public String getType() {
		return type;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public boolean getAgility() {
		return agility;
	}
	
	public boolean getObedience1() {
		return obedience1;
	}
	
	public boolean getObedience2() {
		return obedience2;
	}
	
	public boolean getPuppy() {
		return puppy;
	}
	
	public boolean getTricks() {
		return tricks;
	}
	
}
