package cs333.project_2;

import cs333.project_2.Order.Product;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Product Class
 */
public class TestProduct {

	private Product fixture;

	@Test
	public void test_Product_Getters_N_Setters() {
		fixture = new Product(1089, 6354, 12, "A great product from Yokos");

        // Test Initialization
        assertEquals(1089, fixture.getID());
        assertEquals(6354, fixture.getSellerID()); 
        assertEquals(12, fixture.getPrice(), 0);
        assertEquals(-1, fixture.getRating(), 0);
        assertEquals("A great product from Yokos",fixture.getItemDescrip());

        //Test Updating Values
        fixture.setPrice(120);
        fixture.addRating(5);
		fixture.addRating(9);
        fixture.setItemDescrip("An even greater product from Bokos");
    
        assertEquals(120,fixture.getPrice(), 0);
        assertEquals(7,fixture.getRating(), 0);
        assertEquals("An even greater product from Bokos",fixture.getItemDescrip());
    }
}
