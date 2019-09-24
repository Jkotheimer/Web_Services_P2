package cs333.project_2.Profile;
import java.util.ArrayList;

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

	/**
	 * SETTERS
	 * _________________________________________________________________
	 */

	public boolean setUsername(String username);
	public boolean setPassword(String password);
	public boolean setAddress(Address address);
	public boolean addOrder(String orderID);

	/**
	 * GENERIC METHODS
	 * _________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password);
}
