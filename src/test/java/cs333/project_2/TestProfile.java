package cs333.project_2;

import java.util.ArrayList;
import cs333.project_2.Profile.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Seller and Buyer classes under the Profile interface
 */
public class TestProfile {

	private Profile fixture;

	/**
	 * Coverage:
	 * - Seller getters
	 * - Seller Setters
	 */
	@Test
	public void test_Seller_Getters_N_Setters() {
		fixture = new Seller("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", 
							 new Address("123 Main St.", "Chicago", "IL", 66666), "testCompany.com"
							);

		// Quick test for initial values
		assertEquals("testSeller", fixture.getUsername());
		assertEquals("1234567890", fixture.getID());
		assertEquals("123 Main St.", fixture.getAddress().getStreet());
		assertTrue(fixture.AuthenticateCred("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD"));

		// Make some changes with the setters and retest
		assertTrue(fixture.setUsername("anotherUsername"));
		assertFalse(fixture.setPassword("S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setPassword("@N0743RR@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setAddress(new Address("456 Second Ave.", "Seattle", "WA", 22222)));
		assertEquals("anotherUsername", fixture.getUsername());
		assertEquals("456 Second Ave.", fixture.getAddress().getStreet());
		assertTrue(fixture.AuthenticateCred("anotherUsername", "@N0743RR@ND0M3H@$3DP@$SW0RD"));
		
		// Test the rating system to make sure it averages out all of the ratings
		assertTrue(fixture.addRating(7f));
		assertTrue(fixture.addRating(10f));
		assertFalse(fixture.addRating(11f));
		assertTrue(fixture.addRating(4f));
		assertEquals(7f, fixture.getRating());
		assertTrue(fixture.addRating(6f));
		assertEquals(6.75f, fixture.getRating());
	}

	@Test
	public void test_Seller_Order_Operations() {
		fixture = new Seller("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", 
							 new Address("123 Main St.", "Chicago", "IL", 66666), "testCompamy.com"
							);

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
