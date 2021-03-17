package labs.lab4;

public abstract class LibraryItem {
	private String title = "";
	private boolean checkedOut;
	
	
	public LibraryItem(String title) {
		this.title = title;
		checkedOut = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	public abstract String checkOut();
	
	public void checkIn() {
		checkedOut = false;
	}
	
	public String toString() {
		return title;
	}
	
	public boolean equals(Object otherObject) {
		LibraryItem other = (LibraryItem) otherObject;
		return title.equals(other.title) && checkedOut == other.checkedOut;
	}
}