package cs333.project_2.Profile;

import java.util.ArrayList;
import cs333.project_2.Product.Product;

/**
 * The profile interface for user profiles
 *
 */
public interface Profile
{
	/**
	 * GETTERS
	 * ________________________________________________________________
	 */

	public ArrayList<String> getOrders();
	public String getUsername();
	public String getID();
	public Address getAddress();
	public String geturlAddress();
	public int getRating();
	public ArrayList<Product> getProducts();
	public Product getProduct(String ID);

	/**
	 * SETTERS
	 * _________________________________________________________________
	 */

	public boolean setUsername(String username);
	public boolean setPassword(String password);
	public boolean setAddress(Address address);
	public boolean addOrder(String orderID);
	public boolean seturlAddress(String url);
	public boolean addRating(int ratingnum);
	public boolean addProduct(Product product);

	/**
	 * GENERIC METHODS
	 * _________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password);
}
