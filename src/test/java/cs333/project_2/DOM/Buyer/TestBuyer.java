package cs333.project_2.DOM.Buyer;

import cs333.project_2.DOM.General.Address;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Buyer class
 */
public class TestBuyer {

	private Buyer fixture = new Buyer("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", 123456789);

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
		assertTrue(fixture.AuthenticateCred("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD"));

		// Make some changes with the setters and retest
		assertTrue(fixture.setUsername("anotherUsername"));
		assertFalse(fixture.setPassword("S0M3R@ND0M3H@$3DP@$SW0RD"));
		assertTrue(fixture.setPassword("@N0743RR@ND0M3H@$3DP@$SW0RD"));
		
		assertEquals("anotherUsername", fixture.getUsername());
		assertTrue(fixture.AuthenticateCred("anotherUsername", "@N0743RR@ND0M3H@$3DP@$SW0RD"));
	}
}
