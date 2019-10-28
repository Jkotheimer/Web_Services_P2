package cs333.project_2.DOM.Order;

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
		fixture = new Order(1987324,1346134);

		assertEquals("Order initiated",fixture.getStatus());

		// Test updating
		fixture.updateStatus("OrderCANCELLED");

		assertEquals("OrderCANCELLED",fixture.getStatus());
	}
}
