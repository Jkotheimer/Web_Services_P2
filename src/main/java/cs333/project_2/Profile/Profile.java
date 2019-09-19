package cs333.project_2.Profile;

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

	public String[] getOrders();
	public String getUserName();
	public String getID();
	// public Address getAddress();

	/**
	 * SETTERS
	 * _________________________________________________________________
	 */

	public boolean setUserName();
	public boolean setPassword();
	public boolean setAddress();
	public boolean addOrder();

	/**
	 * GENERIC METHODS
	 * _________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password);
}
