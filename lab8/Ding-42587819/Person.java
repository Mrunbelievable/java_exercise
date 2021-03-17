package labs.lab8;

/**
 * A person with a name.
 */
public class Person {
	private String name;

	public Person(String aName) {
		name = aName;
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + "]";
	}
}
