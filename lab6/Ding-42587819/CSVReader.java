package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
	
	private File file1;
	private String fileName;
	
	public CSVReader(String fileName) {
		this.fileName = fileName;
		file1 = new File(fileName);
	}
	
	public int getNumberOfRows() {
		int count = 0;
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine()) {
				String line = inFile.nextLine();
				count++;
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
		return count;
	}
	
	public int getNumberOfFields(int row) {
		int count = 0;
		int fields = 0;
		String line = "";
		if(row > getNumberOfRows()) {
			throw new IllegalArgumentException();
		}
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine() && count<row+1 ) {
				line = inFile.nextLine();
				count++;
			}
			int signal = 1;
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i)==',' && signal==1) {
					fields ++;
				}
				//check if , in the "" 
				if(line.charAt(i)=='"') {
					signal = -signal;
				}
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
		return fields+1;
	}
	
	public ArrayList<String> getFields(int row) {
		ArrayList<String> res = new ArrayList<String>();
		String line = "";
		int count= 0;
		if(row > getNumberOfRows()) {
			throw new IllegalArgumentException();
		}
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine() && count<row+1 ) {
				line = inFile.nextLine();
				count++;
			}
			String [] words = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			for(int i=0; i<words.length; i++) {
				res.add(words[i].replaceAll("^\"|\"$", ""));
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}

		return res;
	}
	
	public String getField(int row, int column) {
		ArrayList<String> res = new ArrayList<String>();
		String line = "";
		int count= 0;
		if(row > getNumberOfRows()) {
			throw new IllegalArgumentException();
		}
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine() && count<row+1 ) {
				line = inFile.nextLine();
				count++;
			}
			String [] words = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//			for(int i =0; i<words.length; i++) {
//				System.out.println(words[i]);
//			}
			for(int i=0; i<words.length; i++) {
				if(words[i].charAt(0) == '"') {
					words[i] = words[i].substring(1, words[i].length()-1);
					res.add(words[i].replaceAll("^\"|\"$", ""));
				}else {
					res.add(words[i].replaceAll("^\"|\"$", ""));
				}
//				res.add(words[i].replaceAll("^\"|\"$", ""));
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
		
		return res.get(column);
	}
//	public static void main(String[] args) {
//		CSVReader reader1 = new CSVReader("att2007.csv");
//		CSVReader reader2 = new CSVReader("quotes.csv");
////		System.out.println(reader1.getNumberOfRows());
////		System.out.println(reader1.getNumberOfFields(10));
////		System.out.println(reader1.getFields(10));
////		System.out.println(reader1.getField(10, 2));
////		
////		System.out.println(reader2.getNumberOfRows());
////		System.out.println(reader2.getNumberOfFields(1));
////		System.out.println(reader2.getFields(1));
////		System.out.println(reader2.getField(1,2));
////		System.out.println(reader2.getField(1,3));
//		System.out.println(reader2.getField(0,3));
//	}
}
