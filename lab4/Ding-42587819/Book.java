package labs.lab4;

public abstract class Book extends LibraryItem{
	private String author = "";
	
	public Book(String title, String author) {
		super(title);
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		
		if(otherObject instanceof Book) {
			Book other = (Book) otherObject;
			return author == other.getAuthor();
		}
		
		return false;
	}
}