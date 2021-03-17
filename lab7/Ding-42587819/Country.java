package labs.lab7;


public class Country implements Comparable {
	private String name;
	private int population;

	public Country(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		
		return name;
	}
	
	public int getPopulation() {

		return population;
	}
	
	public int compareTo(Object otherObject) {
		Country other = (Country)otherObject;
		if(this.getPopulation() > other.getPopulation()) return 1;
		if(this.getPopulation() < other.getPopulation()) return -1;
		else return 0;
	}
}
