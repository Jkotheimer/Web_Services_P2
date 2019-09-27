package cs333.project_2;

import cs333.project_2.Order.Product;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Seller and Buyer classes under the Profile interface
 */
public class TestProduct {

	private Product fixture;

	@Test
	public void test_Product_Getters_N_Setters() {
        fixture = new Product("1089",12,"Yokos",0,"A great product from Yokos");

        // Test Initialization
        assertEquals("1089",fixture.getID());
        assertEquals("Yokos",fixture.getsellerID()); 
        assertEquals(12,fixture.getPrice());
        assertEquals(0,fixture.getRating());
        assertEquals("A great product from Yokos",fixture.getItemDescrip());

        //Test Updating Values
        fixture.setID("1087");
        fixture.setsellerID("Bokos");
        fixture.setPrice(120);
        fixture.setRating(5);
        fixture.setItemDescrip("An even greater product from Bokos");
    
        assertEquals("1087",fixture.getID());
        assertEquals("Bokos",fixture.getsellerID()); 
        assertEquals(120,fixture.getPrice());
        assertEquals(5,fixture.getRating());
        assertEquals("An even greater product from Bokos",fixture.getItemDescrip());
    }
}