package cs333.project_2.Profile;

public class Seller 
{
	private String username;
	private String password;
	private String ID;
	private String[] orders;
	private Address address;
	
	public Seller(String username, String password, String ID, Address address)
	{
		this.username = username;
		this.password = password;
		this.ID = ID;
		this.address = address;
	}
	
	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	
	public String getUsername()	{ return this.username;	}
	public String getID()		{ return this.ID;		}
	public String[] getOrders()	{ return this.orders;	}
	public Address getAddress()	{ return this.address;	}
	
	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public boolean setUsername(String username)
	{
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}
	public boolean setAddress(Address address)
	{
		// TODO - possibly do some sort of regex check or Google maps check on the Address to see if it's valid
		this.address = address;
		return true;
	}
	public boolean addOrder()
	{
		// TODO - implement this
		return true;
	}
}
