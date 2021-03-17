package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * A program that reads text from a file and breaks it up into individual
 * words, inserts the words into a tree set, and allows you to get stats
 * about the words. 
 */
public class WordCounter {
	private TreeSet<String> uniqueWords;
	// FILL IN ANY OTHER PRIVATE INSTANCE VARIABLES YOU NEED HERE
	private File file;
	private String filename;
	
	public WordCounter(String filename) {
		file = new File(filename);
		this.filename = filename;
		uniqueWords = new TreeSet<>();
	}
	
	public int getNumUniqueWords() {
		int count = 0;
		List<String> temp = getUniqueWords();
		return temp.size();
	}
	
	public int getNumWords() {
		int count = 0;
		try(Scanner inFile = new Scanner(file)){
			while(inFile.hasNext()) {
				String word = inFile.next();
				count++;
			}
		}catch(FileNotFoundException exception){
			System.out.println("File: "+filename+" not found");
		}
		return count;
	}
	
	// returns a list of the unique words with all non-letter and non-digit characters removed, 
	// all in lower case, as a List in alphabetical order
	public List<String> getUniqueWords() {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		try(Scanner inFile = new Scanner(file)){
			while(inFile.hasNextLine()) {
				String temp = inFile.nextLine().replace("-", "");
				temp = temp.replace("'", "");
				temp = temp.replaceAll("[^a-zA-Z0-9]", " ");
				String[] words = temp.split("\\s+");
				for(int i=0; i<words.length; i++) {
					uniqueWords.add(words[i].toLowerCase());
				}
			}

			for(String str : uniqueWords) {
				if(str.length()!=0 && !str.isEmpty()) res.add(str);
			}
			
		}catch(FileNotFoundException exception){
			System.out.println("File: "+filename+" not found");
		}
		return res;
	}
	
//	public static void main(String[] args) {
////		WordCounter wc1 = new WordCounter("test1.txt");
////		System.out.println(wc1.getNumUniqueWords());
////		System.out.println(wc1.getNumWords());
////		System.out.println(wc1.getUniqueWords());
////		
////		WordCounter wc2 = new WordCounter("test2.txt");
////		System.out.println(wc2.getNumUniqueWords());
////		System.out.println(wc2.getNumWords());
////		System.out.println(wc2.getUniqueWords());
//		
//		WordCounter wc3 = new WordCounter("test3.txt");
//		System.out.println(wc3.getNumUniqueWords());
//		System.out.println(wc3.getNumWords());
//		System.out.println(wc3.getUniqueWords());
//	}
}
