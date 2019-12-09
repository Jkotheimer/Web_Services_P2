package cs333.project_2.DOM.General;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Payment Info Class
 *
public class TestPaymentInfo {

	private PaymentInfo fixture;

	@Test
	public void test_Payinfo_Getters_N_Setters() {
		// Test Object Initialization
		fixture = new PaymentInfo("5463225300483912", "MasterCard", "04/23", 123, 2048);

		assertEquals("5463225300483912", fixture.getCreditCardNum());
		assertEquals("MasterCard", fixture.getCreditCardHolder());
		assertEquals("04/23", fixture.getExpDate());
		assertEquals(123, fixture.getCCV());
		assertEquals(2048, fixture.getBillingAddressID());
		

		// Test Updating Values

		fixture.setCreditCardNum("344523484649042");
		fixture.setCreditCardHolder("Visa");
		fixture.setExpDate("11/24");
		fixture.setCCV(543);
		fixture.setBillingAddress(4096);
		
		assertEquals("344523484649042", fixture.getCreditCardNum());
		assertEquals("Visa", fixture.getCreditCardHolder());
		assertEquals("11/24", fixture.getExpDate());
		assertEquals(543, fixture.getCCV());
		assertEquals(4096, fixture.getBillingAddressID());
    }
}
*/
