package labs.lab7;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {
	private Queue<Block> blocks;

	/**
	 * Constructor.
	 */
	public StockSimulator() {
		blocks = new LinkedList<>();
	}

	/**
	 * Handle a user buying a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to buy.
	 * @param price    the price to buy at.
	 * 
	 * @throws IllegalArgumentException if the requested quantity/price cannot be sold
	 * i.e., quantity <= 0 or price < 0
	 */
	public void buy(int quantity, int price) throws IllegalArgumentException {
		if(quantity<=0 || price<0) {
			throw new IllegalArgumentException();
		}else {
			Block b = new Block(quantity, price);
			blocks.add(b);	
		}
	}

	/**
	 * Handle a user selling a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to sell.
	 * @param price    the price to sell.
	 * 
	 * @return the gain (can be positive or negative)
	 * 
	 * @throws IllegalArgumentException if the requested quantity cannot be sold
	 * e.g., quantity exceeds quantity owned, quantity < 1, price < 0
	 */
	public int sell(int quantity, int price) throws IllegalArgumentException {
		
		if( quantity<1 || price<0) throw new IllegalArgumentException();
		
		int res = 0;
		while(!blocks.isEmpty() && quantity >0){
			Block temp = blocks.peek();
			if(temp.getQuantity() >= quantity){
				res += quantity * (price - temp.getPrice());
				temp.sell(quantity);
				return res;
			}else{
				res += temp.getQuantity() * (price - temp.getPrice());
				quantity -= temp.getQuantity();
				blocks.poll();
			}
		}

		return -1; 
	}
	
	/**
	 * This is a method for us to test your class
	 * 
	 * @return a List of Blocks owned
	 */
	public List<Block> getBlocks() {
		
		List<Block> list = new ArrayList<>();
		
		for(Block b: blocks) {
			list.add(b);
		}
		
		return list;
	}
}
