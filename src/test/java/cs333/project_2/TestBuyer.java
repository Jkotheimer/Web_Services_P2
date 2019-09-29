package cs333.project_2;

import java.util.ArrayList;
import cs333.project_2.Profile.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Buyer class
 */
public class TestBuyer {

	private Buyer fixture = new Buyer("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", 123456789, 
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
		assertEquals(123456789, fixture.getID());
		assertEquals("123 Main St.", fixture.getAddress().getStreet());
		assertTrue(fixture.AuthenticateCred("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.addPayInfo(new PaymentInfo("9988776655443322","MasterCard","05/24",123, fixture.getAddress())));
		assertTrue(fixture.addPayInfo(new PaymentInfo("2233445566778899","Visa","09/23",321, fixture.getAddress())));
		assertEquals(fixture.getAddress().getStreet(), fixture.getPayInfos().get(0).getBillingAddress().getStreet());

		// Make some changes with the setters and retest
		assertTrue(fixture.setUsername("anotherUsername"));
		assertFalse(fixture.setPassword("S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setPassword("@N0743RR@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setAddress(new Address("456 Second Ave.", "Seattle", "WA", 22222)));
		assertTrue(fixture.deletePayInfo(fixture.getPayInfos().get(1)));
		
		assertEquals("anotherUsername", fixture.getUsername());
		assertEquals("456 Second Ave.", fixture.getAddress().getStreet());
		assertEquals(123, fixture.getPayInfos().get(0).getCCV());
		assertEquals(1, fixture.getPayInfos().size());
		assertTrue(fixture.AuthenticateCred("anotherUsername", "@N0743RR@ND0M3H@$3DP@$SW0RD"));
	}
	
	@Test
	public void test_DBOperations() {
		
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
		ArrayList<String> fixture_orders = fixture.getOrderIDs();
		for(int i = 0; i < fixture_orders.size() - 1; i++) 
			if(fixture_orders.get(i).compareTo(fixture_orders.get(i + 1)) > 0) 
				fail();
		
		// Cancel a few orders and retest
		fixture.cancelOrder("j503M82u");
		fixture.cancelOrder("QnVHEA8X");
		fixture_orders = fixture.getOrderIDs();
		assertEquals(fixture_orders.size(), 6);
		assertFalse(fixture_orders.contains("j503M82u"));
		assertFalse(fixture_orders.contains("QnVHEA8X"));
		for(int i = 0; i < fixture_orders.size() - 1; i++) 
			if(fixture_orders.get(i).compareTo(fixture_orders.get(i + 1)) > 0) 
				fail();
	}
}
