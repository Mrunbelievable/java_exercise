package labs.lab1;

/**
 * The class represents an ant population that may breed and that may be
 * controlled by insecticide.
 */
public class AntPopulation {
	private int population;
	
	/**
	 * Create an initial ant population with given size.
	 * 
	 * @param size initial population
	 */
	public AntPopulation(int size) {
		population = size;
	}

	/**
	 * Simulates a breeding period increasing the population.
	 */
	public void breed() {
		population = population * 2;
	}

	/**
	 * Spray the population with insecticide.
	 * 
	 * @param percent percent of population eradicated
	 */
	public void spray(double percent) {
		double reduce_number = population*(percent / 100);
		population = population - (int) reduce_number;
	}

	/**
	 * Returns the current population size.
	 * 
	 * @return current population size
	 */
	public int getAnts() {
		return population; 
	}
}
