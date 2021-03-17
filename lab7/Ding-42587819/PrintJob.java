package labs.lab7;

/**
 * Class for creating a priority print queue.
 */
public class PrintJob implements Comparable {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String employeeType;
	private String description;
	/**
	 * Constructor.
	 * 
	 * @param employeeType   The type of employee requesting the print job
	 * @param description    The description of the print job.
	 */
	public PrintJob(String employeeType, String description) {
		this.employeeType = employeeType;
		this.description = description;
	}

	public int getPriority() {
		String type = getEmployeeType();
		int n = 0;
		switch(type) {
			case "CEO":
				n = 1;
				break;
			case "Vice-President":
				n = 2;
				break;
			case "Executive-Manager":
				n = 3;
				break;
			case "Manager":
				n = 4;
				break;
			case "Senior-Associate":
				n = 5;
				break;
			case "Associate":
				n = 6;
				break;
			case "Junior-Associate":
				n = 7;
				break;
			case "Clerical":
				n = 8;
				break;
			case "Intern":
				n = 9;
				break;
			case "Volunteer":
				n = 10;
				break;
		}
		
		return n;
	}

	public String getEmployeeType() {
		
		return employeeType;
	}
	
	public String getDescription() {

		return description;
	}

	@Override
	public int compareTo(Object otherObject) {
		
		PrintJob other = (PrintJob)otherObject;
		
		if( employeeType.equals(other.getEmployeeType()) && description.equals(other.getDescription())) {
			return 0;
		}

		return -1; 
	}
}