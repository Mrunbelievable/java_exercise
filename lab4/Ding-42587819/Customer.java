package labs.lab4;

class Customer{
	
	private double amount;
	private double amountForDiscount;
	private int discount_number;
	
	public Customer() {
		
	}
	
	public void makePurchase(double amount) {
		if(discount_number>0) {
			this.amount += amount*0.9;
			amountForDiscount += amount*0.9;
			discount_number --;
		}else {
			this.amount += amount;
			amountForDiscount += amount;
		}
	}
	
	public int getNumDiscountsToUse() {
		if(amountForDiscount>=100) {
			discount_number = (int)(amountForDiscount / 100);
			amountForDiscount -= discount_number * amountForDiscount;
		}
		return discount_number;
	}
	
	public double getTotalAmountSpent() {
		return amount;
	}
	
}