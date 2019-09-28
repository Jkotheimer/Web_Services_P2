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
        fixture = new Order("test_01", new String[]{"1023","3029"},"helfman_09");

        assertEquals("test_01",fixture.getID());
        assertEquals("Order Placed",fixture.getStatus());
        assertEquals("helfman_09",fixture.getBuyerID());

        // Test updating
        fixture.updateStatus("OrderCANCELLED");

        assertEquals("OrderCANCELLED",fixture.getStatus());

    }
}
