package labs.lab4;

class Student{
	private String name;
	private int id;
	private double gpa;
	private boolean honorsStudent;
	private static int count = 1;
	public Student(String name) {
		this.name = name;
		id = count;
		gpa = 0.0;
		honorsStudent = false;
		count ++;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(!this.name.isEmpty()) {
			this.name = name;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public boolean isHonorsStudent() {
		if(gpa>=3.5) {
			honorsStudent = true;
		}else {
			honorsStudent = false;
		}
		return honorsStudent;
	}
}