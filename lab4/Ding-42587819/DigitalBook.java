package labs.lab4;

public class DigitalBook extends Book{
	private String title = "";
	private String author = "";
	private  int numPages;
	private static int check_max=0;
	
	public DigitalBook(String title, String author, int numPages) {
		super(title, author);
		this.numPages = numPages;
	}
	
	public int getNumPages() {
		return numPages;
	}
	
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}
	
	public String checkOut() {
		String str = "";
		
		if(check_max <3) {
			super.setCheckedOut(true);
			check_max++;
			str = "14 days";
		}
		else {
			str = "NOT ALLOWED";
		}
		return str;
	}
	
	public void CheckIn() {
		super.checkIn();
		check_max--;
	}
	
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		
		if(otherObject instanceof DigitalBook) {
			DigitalBook other = (DigitalBook) otherObject;
			return title.equals(other.getTitle()) && author.equals(other.getAuthor()) 
					&& numPages == other.getNumPages();
		}
		return false;
	}
}