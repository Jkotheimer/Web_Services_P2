package cs333.project_2.Profile;

import java.util.ArrayList;
import cs333.project_2.Order.*;

/**
 * The profile interface for user profiles
 *
 */
public abstract class Profile
{
	/**
	 * GETTERS
	 * ________________________________________________________________
	 */

	abstract public String getUsername();
	abstract public String getID();
	abstract public String geturlAddress();
	abstract public Address getAddress();
	abstract public float getRating();
	abstract public ArrayList<String> getOrders();
	abstract public ArrayList<Product> getProducts();
	abstract public Product getProduct(String ID);

	/**
	 * SETTERS
	 * _________________________________________________________________
	 */

	abstract public boolean setUsername(String username);
	abstract public boolean setPassword(String password);
	abstract public boolean setAddress(Address address);
	abstract public boolean addOrder(String orderID);
	abstract public boolean seturlAddress(String url);
	abstract public boolean addRating(float ratingnum);
	abstract public boolean addProduct(Product product);

	/**
	 * GENERIC METHODS
	 * _________________________________________________________________
	 */

	abstract public boolean AuthenticateCred(String username, String password);
}
