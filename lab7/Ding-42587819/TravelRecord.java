package labs.lab7;

import java.util.ArrayList;
import java.util.Collections;

public class TravelRecord {
	private ArrayList<Country> list;
	
	public TravelRecord() {
		list = new ArrayList<>();
	}
	
	public void addCountry(String name, int population) {
		Country country = new Country(name, population);
		list.add(country);
	}
	
	public boolean removeCountry(String name) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeCountry(int population) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPopulation() == population) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Country findCountryByName(String name) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public Country findCountryByPopulation(int population) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPopulation() == population) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public String getNamesOrderedByPopulation() {
		
		Collections.sort(list);
		
		String str = "";
		
		for(Country c: list) {
			str += c.getName();
			str += " ";
		}
		
		return str.trim();
	}
//	public static void main(String[] args) {
//		TravelRecord record = new TravelRecord();
//		record.addCountry("USA", 331002651);
//		record.addCountry("South Korea", 51269185);
//		record.addCountry("Greece", 10423054);
//		record.addCountry("Kenya", 53771296);
//		record.addCountry("Brazil", 212559417);
//		record.addCountry("Australia", 25499884);
//		record.addCountry("Antarctica", 1100);
//		System.out.println(record.getNamesOrderedByPopulation());
//		System.out.println(record.findCountryByPopulation(53771296).getName());
//		System.out.println(record.findCountryByName("Greece").getPopulation());
//		System.out.println(record.removeCountry(25499884));
//		System.out.println(record.removeCountry("Antarctica"));
//		System.out.println(record.getNamesOrderedByPopulation());
//	}
}
