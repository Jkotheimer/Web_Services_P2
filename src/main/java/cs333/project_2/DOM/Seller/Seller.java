package cs333.project_2.DOM.Seller;
import cs333.project_2.DOM.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Seller {
	
	private String username;
	private String password;
	private String ID;
	
	public Seller() {
		
	}

	public Seller(String ID, String username, String password) {
		this.username = username;
		this.password = password;	
		this.ID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()				{ return this.username;	}

	public String getID()						{ return this.ID;		}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
		return true;
	}
	
	public boolean setPassword(String oldPassword, String newPassword) {
		// If the password has been used before, inform the user and have them change it to something else
		if(this.password.equals(oldPassword)) {
			this.password = newPassword;
			return true;
		}
		return false;
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */
	
	public boolean AuthenticateCred(String username, String password) {
		// TODO possibly add another hash algorithm here for safety
		if(this.username.equals(username) && this.password.equals(password)) return true;
		else return false;
	}
}
