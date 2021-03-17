package labs.lab6;
import java.util.Scanner;
import java.io.*;
public class Files {
	
	// Removes blank lines from the file given as argument and writes the non-blank lines back to the file
	public static void removeBlankLines(String fileName){
		File file1 = new File( fileName);
		File temp = new File("temp.txt");
		try(Scanner inFile = new Scanner(file1)) {
			try(PrintWriter out = new PrintWriter(temp)){
				while(inFile.hasNextLine()) {
					String line = inFile.nextLine();
					if(!line.isEmpty()) {
						out.write(line+'\n');
					}
				}
				//change the temp file to original name
				temp.renameTo(file1);
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
	}
	
	public static void addLineNumbers(String fileName) {
		File file1 = new File( fileName);
		File temp = new File("temp.txt");
		try(Scanner inFile = new Scanner(file1)) {
			try(PrintWriter out = new PrintWriter(temp)){
				int n = 1;
				while(inFile.hasNextLine()) {
					String line = inFile.nextLine();
					String actual_line = "/* " + n + " */ " + line;
					if(!line.isEmpty()) {
						out.write(actual_line+'\n');
					}
					n++;
				}
				//change the temp file to original name
				temp.renameTo(file1);
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
	}
	
	public static void reverse(String fileName) {
		File file1 = new File( fileName);
		File temp = new File("temp.txt");
		try(Scanner inFile = new Scanner(file1)) {
			try(PrintWriter out = new PrintWriter(temp)){
				while(inFile.hasNextLine()) {
					String line = inFile.nextLine();
					if(!line.isEmpty()) {
						out.write(reverse_line(line)+'\n');
					}
				}
				//change the temp file to original name
				temp.renameTo(file1);
			}
		}catch(FileNotFoundException exception) {
			System.out.println("File: "+fileName+" not found");
		}
	}
	public static String reverse_line(String line) {
		StringBuilder sb = new StringBuilder();
		for(int i=line.length()-1; i>=0; i--) {
			sb.append(line.charAt(i));
		}
		return sb.toString();
	}
	
//	public static void main(String[] args) {
////		removeBlankLines("lines.txt");
//		addLineNumbers("lines.txt");
////		reverse("lines.txt");
//	}
	
}
