package cs333.project_2;

import cs333.project_2.Order.Order;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Seller and Buyer classes under the Profile interface
 */
public class TestOrder {

	private Order fixture;

	@Test
	public void test_Order_Getters_N_Setters() {
        // Test Object Initialization
        fixture = fixture.createOrder(new String[] {"1023","3029"},"helfman_09");
        fixture.setID("test_01");

        assertEquals("",fixture.getID());
        assertEquals("Order Placed",fixture.getStatus());
        assertEquals("helfman_09",fixture.getCustomer());

        // Test updating
        fixture.UpdateStatus("OrderCANCELLLED");
        fixture.setCustomer("newman_02");

        assertEquals("OrderCANCELLED",fixture.getStatus());
        assertEquals("newman_02",fixture.getCustomer());

    }
}