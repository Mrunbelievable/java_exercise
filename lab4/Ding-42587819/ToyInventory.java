package labs.lab4;
import java.util.ArrayList;

class ToyInventory{
	
	ArrayList<Toy> list;
	
	public ToyInventory(){
		list = new ArrayList<>();
	}
	
	public void addToy(Toy toy) {
		list.add(toy);
	}
	
	public void removeToy(String name) {
		for(Toy toy: list) {
			String s = toy.getName();
			if(s.equals(name)) {
				int i = list.indexOf(toy);
				list.remove(i);
				break;
			}
		}
	}
	
	public String getInventoryReport() {
		String str = "";
		
		for(Toy toy : list) {
			str += toy.getName();
			str += '\n';
			str += toy.getDescription();
			str += '\n';
			if(toy.isDestroyed()) {
				str += "DESTROYED";
			}
			else {
				str += "NOT DESTROYED";
			}
			str += '\n';
		}
		
		return str.substring(0,str.length()-1);
	}
}