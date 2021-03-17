package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCounter {
	
	private File file1;
	private String fileName;
	
	public FileCounter(String fileName) {
		this.fileName = fileName;
		file1 = new File(fileName);
	}
	
	public int getWordCount() {
		int count = 0;
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNext()) {
				String word = inFile.next();
				count++;
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
		return count;
	}
	
	public int getLineCount() {
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
	
	public int getCharacterCount() {
		int count = 0;
		try(Scanner inFile = new Scanner(file1)) {
			while(inFile.hasNextLine()) {
				String line = inFile.nextLine();
				count += line.length();
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
		return count;
	}
//	public static void main(String[] args) {
//		FileCounter doc1 = new FileCounter("doc1.txt");
//		System.out.println(doc1.getWordCount());
//		System.out.println(doc1.getLineCount());
//		System.out.println(doc1.getCharacterCount());
//	}
}
