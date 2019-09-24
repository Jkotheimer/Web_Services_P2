package cs333.project_2;

import cs333.project_2.Order.*;
import cs333.project_2.Profile.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Seller and Buyer classes under the Profile interface
 */
public class TestProfile {

	private Profile fixture;

	@Test
	public void test_Seller_Getters_N_Setters() {
		fixture = new Seller("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", new Address("123 Main St.", "Chicago", "IL", 66666));

		// Quick test for initial values
		assertEquals("testSeller", fixture.getUsername());
		assertEquals("1234567890", fixture.getID());
		assertSame("123 Main St.", fixture.getAddress().getStreet());
		assertTrue(fixture.AuthenticateCred("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD"));

		// Make some changes with the setters and retest
		assertTrue(fixture.setUsername("anotherUsername"));
		assertFalse(fixture.setPassword("S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setPassword("@N0743RR@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setAddress(new Address("456 Second Ave.", "Seattle", "WA", 22222)));
		assertEquals("anotherUsername", fixture.getUsername());
		assertEquals("456 Second Ave.", fixture.getAddress().getStreet());
		assertTrue(fixture.AuthenticateCred("anotherUsername", "@N0743RR@ND0M3H@$3DP@$SW0RD"));
	}

	@Test
	public void test_Seller_Order_Operations() {
		fixture = new Seller("testSeller", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", new Address("123 Main St.", "Chicago", "IL", 66666));

		// Add a few orders and test order test_Seller_Order_Operations
		assertTrue(fixture.addOrder("AO37F834D"));
		assertTrue(fixture.addOrder("RV47D416N"));
		assertTrue(fixture.addOrder("PW77X366L"));
		assertFalse(fixture.addOrder("AO37F834D"));
	}
}
