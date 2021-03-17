package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentRoster {
	
	private File file1;
	private String rosterFileName;
	
	public StudentRoster(String rosterFileName) {
		this.rosterFileName = rosterFileName;
		file1 = new File(rosterFileName);
	}
	
	public double getCourseTotalTuition(String course) {
		double total = 0;
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine()) {
				String line = inFile.nextLine();
				String [] words = line.split(";");
				if(words[2].equals(course)) {
					double val = Double.parseDouble(words[3]);
					total += val;
				}
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+ rosterFileName +" not found");
		}
		
		
		return total;
	}
	
	public int getNumStudentsInCourse(String course) {
		int total = 0;
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine()) {
				String line = inFile.nextLine();
				String [] words = line.split(";");
				if(words[2].equals(course)) {
					total ++;
				}
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+ rosterFileName +" not found");
		}
		
		
		return total;
	}
	
//	public static void main(String[] args) {
//		StudentRoster roster = new StudentRoster("roster.txt");
//		System.out.println(roster.getCourseTotalTuition("Agility Training"));
//		System.out.println(roster.getNumStudentsInCourse("Agility Training"));
//		System.out.println(roster.getNumStudentsInCourse("Obedience 101")); 
//	}
}
