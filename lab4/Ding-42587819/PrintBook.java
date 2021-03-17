package labs.lab4;

public class PrintBook extends Book{
	private  int numPages;
	
	public PrintBook(String title, String author, int numPages) {
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
		String str;
		if(!super.isCheckedOut()) {
			str = "21 days";
			super.setCheckedOut(true);
		}
		else {
			str = "NOT ALLOWED";
		}
		
		return str;
	}
	
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		
		if(otherObject instanceof PrintBook) {
			PrintBook other = (PrintBook) otherObject;
			return numPages == other.getNumPages();
		}
		return false;
	}
}