package labs.lab4;

class Toy{
	private String name;
	private String description;
	private boolean destroyed;
	
	public Toy(String name, String description, boolean destroyed) {
		this.name = name;
		this.description = description;
		this.destroyed = destroyed;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isDestroyed() {
		if(destroyed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
}