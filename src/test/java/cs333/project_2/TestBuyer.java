package cs333.project_2;

import java.util.ArrayList;
import cs333.project_2.Profile.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Buyer class
 */
public class TestBuyer {

	private Buyer fixture = new Buyer("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", 
										new Address("123 Main St.", "Chicago", "IL", 66666)                              
										);

	/**
	 * Coverage:
	 * - username
	 * - password
	 * 		+ Authentication
	 * - ID
	 * - address
	 * - Payment Info
	 */
	@Test
	public void test_Getters_N_Setters() {

		// Quick test for initial values
		assertEquals("testCustomer", fixture.getUsername());
		assertEquals("1234567890", fixture.getID());
		assertEquals("123 Main St.", fixture.getAddress().getStreet());
		assertTrue(fixture.AuthenticateCred("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD"));

		// Make some changes with the setters and retest
		assertTrue(fixture.setUsername("anotherUsername"));
		assertFalse(fixture.setPassword("S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setPassword("@N0743RR@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setAddress(new Address("456 Second Ave.", "Seattle", "WA", 22222)));
		assertTrue(fixture.setPayInfo(new PaymentInfo("9988776655443322","MasterCard","05/24",123, fixture.getAddress())));
		
		assertEquals("anotherUsername", fixture.getUsername());
		assertEquals("456 Second Ave.", fixture.getAddress().getStreet());
		assertEquals(123, fixture.getPayInfo().getCCV()); // further testing of the payment info class will occur elsewhere
		assertEquals(fixture.getAddress(), fixture.getPayInfo().getBillingAddress());
		assertTrue(fixture.AuthenticateCred("anotherUsername", "@N0743RR@ND0M3H@$3DP@$SW0RD"));
	}

	/**
	 * Coverage
	 * - addOrder/getOrders
	 * 		+ properly sorted
	 * 		+ does not allow duplicates
	 */
	@Test
	public void test_Order_Operations() {
		// Add a few orders and test order functions
		String[] orders = {"LoXCvQdh","D9GTuE1a","QnVHEA8X","fGo0eUv4","jIzYXe4r","j503M82u","MTOByHhO","Qr05vUwJ"};
		
		for(String o: orders) assertTrue(fixture.addOrder(o));
		for(String o: orders) assertFalse(fixture.addOrder(o));
		
		// make sure the list is sorted
		ArrayList<String> fixture_orders = fixture.getOrders();
		for(int i = 0; i < fixture_orders.size() - 1; i++) 
			if(fixture_orders.get(i).compareTo(fixture_orders.get(i + 1)) > 0) 
				fail();
	}
}
