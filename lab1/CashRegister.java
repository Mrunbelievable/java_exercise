package labs.lab1;

/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private int count;
	private String receipt;
	private int numberOfSale;
	private double saleTotal;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
		count = 0;
		receipt = "";
		numberOfSale = 0;
		saleTotal = 0.0;
	}

	/**
	 * Records the sale of an item.
	 * 
	 * @param amount the price of the item
	 */
	public void recordPurchase(double amount) {
		purchase = purchase + amount;
		count +=1;
		receipt += String.valueOf(amount);
		receipt += '\n';
		saleTotal += amount;
	}

	/**
	 * Processes a payment received from the customer.
	 * 
	 * @param amount the amount of the payment
	 */
	public void receivePayment(double amount) {
		payment = payment + amount;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public double giveChange() {
		double change = payment - purchase;
		purchase = 0;
		payment = 0;
		count = 0;
		receipt = "";
		numberOfSale +=1;
		return change;
	}
	

	/**
	 * Returns count of items purchased.
	 * 
	 * @return count of items purchased
	 */
	public int getItemCountInPurchase() {
		return count;
	}

	/**
	 * Get the total amount of all sales for the day.
	 * 
	 * @return the total amount of all sales for the day
	 */
	public double getSalesTotal() {
		return saleTotal;
	}

	/**
	 * Get the total number of sales for the day.
	 * 
	 * @return the number of sales for the day
	 */
	public int getSalesCount() {
		return numberOfSale;
	}

	/**
	 * Reset counters and totals for the next day's sales.
	 */
	public void reset() {
		numberOfSale = 0;
		saleTotal = 0.0;
	}

	public String getReceipt() {
		receipt += String.valueOf(purchase);
		return receipt; 
	}
}
