package cs333.project_2;

import cs333.project_2.Order.Order;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Order Class
 */
public class TestOrder {

	private Order fixture;

	@Test
	public void test_Order_Getters_N_Setters() {
		// Test Object Initialization
		fixture = new Order(1987324, new int[]{61435,614315},1346134);

		assertEquals(1987324,fixture.getID());
		assertEquals("Order initiated",fixture.getStatus());
		assertEquals(1346134,fixture.getCustomerID());

		// Test updating
		fixture.updateStatus("OrderCANCELLED");

		assertEquals("OrderCANCELLED",fixture.getStatus());
	}
}
