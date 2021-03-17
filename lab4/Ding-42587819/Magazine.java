package labs.lab4;

public class Magazine extends LibraryItem{
	private int issueNumber;
	private String publicationDate = "";
	
	public Magazine(String title, int issueNumber, String publicationDate) {
		super(title);

		this.issueNumber = issueNumber;
		this.publicationDate = publicationDate;
	}
	
	public int getIssueNumber() {
		return this.issueNumber;
	}
	
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}
	
	public String getPublicationDate() {
		return this.publicationDate;
	}
	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
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
		
		if(otherObject instanceof Magazine) {
			Magazine other = (Magazine) otherObject;
			return issueNumber == other.getIssueNumber()
					&& publicationDate.equals(other.getPublicationDate());
		}
		return false;
	}
}