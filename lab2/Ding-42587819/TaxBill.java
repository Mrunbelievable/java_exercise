package labs.lab2;

public class TaxBill {
	private boolean married;
	private double income;
	/**
	 * Constructs a TaxBill
	 * 
	 * @param married is whether the person is married (true) or not (false)
	 * @param income is the person's taxable income
	 */
	public TaxBill(boolean married, double income) {
		this.married = married;
		this.income = income;
	}
	
	/**
	 * Gets the amount of tax due
	 * 
	 * @return the amount of tax due
	 */
	public double getAmountDue() {
		double amount;
		if(married == false) {
			if(income>=0 && income<=8000) {
				amount = income*0.1;
			}
			else if(income>8000 && income<=32000) {
				amount = (income-8000)*0.15+800;
			}
			else {
				amount = (income-32000)*0.25+4400;
			}
		}
		else {
			if(income>=0 && income<=16000) {
				amount = income*0.1;
			}
			else if(income>16000 && income<=64000) {
				amount = (income-16000)*0.15+1600;
			}
			else {
				amount = (income-64000)*0.25+8800;
			}
		}
		return amount;
	}
}