package cs333.project_2.General;

import cs333.project_2.Profile.*;
import cs333.project_2.Order.*;

/**
 * The Utility class will act as our persistence layer - all other classes will call their essential getters and setters
 * from here to retrieve objects from ID's. Essentially, we are converting ID's into objects and returning the objects.
 * 
 * There are also general functionality methods.
 */
public class Utility
{
	public Utility() {}
	
    public static String generateID(){
        //TODO make this generate random? string
        return "test";
    }

    public static String searchProduct(String productname){
        //TODO search database for product with same name
        return "found";
    }

    public static boolean checkAvailability(String productname){
        //TODO check that a product is available in database
        return true;
    }
    
    public Buyer getBuyer(String ID) {
		// TODO grab the corresponding buyer object from the database
		return new Buyer("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", 
							new Address("123 Main St.", "Chicago", "IL", 66666)                              
						);
	}
	public Seller getSeller(String ID) {
		// TODO grab the corresponding seller object from the database
		return new Seller("testCustomer", "S0M3R@ND0M3H@$3DP@$SW0RD", "1234567890", 
							new Address("123 Main St.", "Chicago", "IL", 66666), "website.com"                         
						);
	}
	public Product getProduct(String ID) {
		// TODO grab the corresponding product object from the database
		return new Product("aaidsucvh98", 44.98f, "aliusycvewuih", 0f, "a new product");
	}
	public Order getOrder(String ID) {
		// TODO grab the corresponding order object from the database
		return new Order("aivchiauld", null, "8xcpovyeu");
	}
}
