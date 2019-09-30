package cs333.project_2;

import java.util.ArrayList;
import cs333.project_2.Profile.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Seller class
 */
public class TestSeller {

	private Seller fixture = new Seller("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD", 12432, 
										new Address("123 Main St.", "Chicago", "IL", 66666), "testCompany.com"
										);

	/**
	 * Coverage:
	 * - username
	 * - password
	 * 		+ Authentication
	 * - ID
	 * - address
	 * - urlAddress
	 * - rating average
	 */
	@Test
	public void test_Getters_N_Setters() {

		// Quick test for initial values
		assertEquals("testSeller", fixture.getUsername());
		assertEquals(12432, fixture.getID());
		assertEquals("123 Main St.", fixture.getAddress().getStreet());
		assertEquals("testCompany.com", fixture.geturlAddress());
		assertTrue(fixture.AuthenticateCred("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD"));

		// Make some changes with the setters and retest
		assertTrue(fixture.setUsername("anotherUsername"));
		assertFalse(fixture.setPassword("S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setPassword("@N0743RR@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.seturlAddress("differentWebsite.com"));
		assertTrue(fixture.setAddress(new Address("456 Second Ave.", "Seattle", "WA", 22222)));
		
		assertEquals("anotherUsername", fixture.getUsername());
		assertEquals("456 Second Ave.", fixture.getAddress().getStreet());
		assertEquals("differentWebsite.com", fixture.geturlAddress());
		assertTrue(fixture.AuthenticateCred("anotherUsername", "@N0743RR@ND0M3H@$3DP@$SW0RD"));
		
		// Test the rating system to make sure it averages out all of the ratings
		assertTrue(fixture.addRating(7f));
		assertTrue(fixture.addRating(10f));
		assertFalse(fixture.addRating(11f));
		assertTrue(fixture.addRating(4f));
		assertEquals(7f, fixture.getRating(), 0);
		assertTrue(fixture.addRating(6f));
		assertEquals(6.75f, fixture.getRating(), 0);
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

		// Cancel a few orders and retest
		fixture.cancelOrder("j503M82u");
		fixture.cancelOrder("QnVHEA8X");
		fixture_orders = fixture.getOrders();
		assertEquals(fixture_orders.size(), 6);
		assertFalse(fixture_orders.contains("j503M82u"));
		assertFalse(fixture_orders.contains("QnVHEA8X"));
		for(int i = 0; i < fixture_orders.size() - 1; i++) 
			if(fixture_orders.get(i).compareTo(fixture_orders.get(i + 1)) > 0) 
				fail();
	}
	
	/**
	 * Coverage
	 * - addProduct/getProduct
	 * 		+ properly sorted
	 * 		+ does not allow duplicates
	 */
	@Test
	public void test_Product_Operations() {
		// Add a few orders and test order functions
		String[] products = {"j503M82u","MTOByHhO","LoXCvQdh","D9GTuE1a","Qr05vUwJ","QnVHEA8X","fGo0eUv4","jIzYXe4r"};
		
		for(String p: products) assertTrue(fixture.addProduct(p));
		for(String p: products) assertFalse(fixture.addProduct(p));
		
		// make sure the list is sorted
		ArrayList<String> fixture_products = fixture.getProducts();
		for(int i = 0; i < fixture_products.size() - 1; i++) 
			if(fixture_products.get(i).compareTo(fixture_products.get(i + 1)) > 0) 
				fail();
			
		// Remove a few products and retest
		fixture.removeProduct("j503M82u");
		fixture.removeProduct("QnVHEA8X");
		fixture_products = fixture.getProducts();
		assertEquals(fixture_products.size(), 6);
		assertFalse(fixture_products.contains("j503M82u"));
		assertFalse(fixture_products.contains("QnVHEA8X"));
		for(int i = 0; i < fixture_products.size() - 1; i++) 
			if(fixture_products.get(i).compareTo(fixture_products.get(i + 1)) > 0) 
				fail();
	}
}
