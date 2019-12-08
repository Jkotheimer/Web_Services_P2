package cs333.project_2.Service.Respresentation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement
public class SellerRepresentation extends AbstractRepresentation{

	private final String accountType = "seller";
	private String username;
	private String ID;
	
	public SellerRepresentation() {}

	public SellerRepresentation(String ID, String username) {
		this.username = username;	
		this.ID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getAccountType()			{ return this.accountType; }
	
	public String getUsername()				{ return this.username;	}

	public String getID()					{ return this.ID;		}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
}
