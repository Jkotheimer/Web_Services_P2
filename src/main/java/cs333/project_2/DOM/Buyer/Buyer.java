package cs333.project_2.DOM.Buyer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyer")
public class Buyer {
	
	private String username;
	private String password;
	private int ID;
	
	public Buyer() {}

	public Buyer(String username, String password, int ID) {
		this.username = username;
		this.password = password;
		this.ID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	
	@Column(name = "buyerusername")
	public String getUsername()					{ return this.username;	}
	
	@Column(name = "buyerpassword")
	public String getPassword() 				{ return this.password;	}
	
	@Id
	@Column(name = "buyerID", updatable = false,  nullable = false)
	public int getID()						    { return this.ID;		}
	


	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}

	public boolean setPassword(String password) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password == password) return false;
		this.password = password;
		return true;
	}
	
	public boolean setID(int ID) {
		// I don't think it would be smart to have dynamic IDs
		return false;
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */

	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safetyaaaaa
		if(this.username == username && this.password == password) return true;
		else return false;
	}
}
