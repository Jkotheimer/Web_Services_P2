package cs333.project_2;

import java.util.ArrayList;
import java.util.Arrays;

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
        fixture = new Order(new String[] {"1023","3029"},"helfman_09","Yokos");
        fixture.setID("test_01");

        assertEquals("test_01",fixture.getID());
        assertEquals("Order Placed",fixture.getStatus());
        assertEquals("helfman_09",fixture.getCustomer());
        assertEquals("Yokos",fixture.getProducer());
        assertEquals("1023",fixture.getItemsOrdered()[0]);
        assertEquals("3029",fixture.getItemsOrdered()[1]);

        // Test updating
        fixture.UpdateStatus("OrderCANCELLLED");
        fixture.setCustomer("newman_02");
        fixture.setProducer("Bokos");
        ArrayList<String> changed = new ArrayList<String>(Arrays.asList(fixture.getItemsOrdered()));
        changed.add("4009");
        String[] myArray = new String[3];
        myArray = changed.toArray(myArray);
        fixture.setItemsOrdered(myArray);

        assertEquals("OrderCANCELLLED",fixture.getStatus());
        assertEquals("newman_02",fixture.getCustomer());
        assertEquals("Bokos",fixture.getProducer());
        assertEquals("4009",fixture.getItemsOrdered()[2]);

    }
}