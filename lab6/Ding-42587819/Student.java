package labs.lab6;

public class Student {
	private String name;
	private int id;
	private String course;
	private double tuition;
	private String date;
	
	public Student(String name, int id, String course, double tuition, String date) {
		this.name = name;
		this.id = id;
		this.course = course;
		this.tuition = tuition;
		this.date  = date;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCourse() {
		return course;
	}
	
	public double getTuition() {
		return tuition;
	}
	
	public String getDate() {
		return date;
	}
}
