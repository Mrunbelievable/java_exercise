package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest{
	@Test
	public void testPurchaseLessThan100() {
		Customer c = new Customer();
		c.makePurchase(75);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(75.0, c.getTotalAmountSpent());
	}
	
	@Test
	public void testPurchaseMoreThan100() {
		Customer c2 = new Customer();
		c2.makePurchase(75);
		c2.makePurchase(50.25);
		assertEquals(1, c2.getNumDiscountsToUse());
		assertEquals(125.25, c2.getTotalAmountSpent());
	}
	
	@Test
	public void testDiscountApplied() {
		Customer c3 = new Customer();
		c3.makePurchase(100);
		assertEquals(1, c3.getNumDiscountsToUse());
		c3.makePurchase(10);
		assertEquals(0, c3.getNumDiscountsToUse());
	}
	
	@Test
	public void testPurchaseEarningMultipleDiscounts() {
		Customer c4 = new Customer();
		c4.makePurchase(234.30);
		assertEquals(2, c4.getNumDiscountsToUse());
	}
	
	@Test
	public void testOnlyOneDiscountApplied() {
		Customer c5 = new Customer();
		c5.makePurchase(234.30);
		assertEquals(2, c5.getNumDiscountsToUse());
		c5.makePurchase(10);
		assertEquals(1, c5.getNumDiscountsToUse());
	}
}