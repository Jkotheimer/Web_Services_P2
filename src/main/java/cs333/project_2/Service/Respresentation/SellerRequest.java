package cs333.project_2.Service.Respresentation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cs333.project_2.DOM.Product.Product;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class SellerRequest {
	
	private String username;
	private String password;
	private String sellerID;
	private List<Product> products = new ArrayList<Product>();
	
	public SellerRequest() {
		
	}

	public SellerRequest(String ID, String username, String password) {
		this.username = username;
		this.password = password;	
		this.sellerID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getUsername()				{ return this.username;	}
	
	public String getPassword()				{ return this.password;	}

	public String getsellerID()						{ return this.sellerID;		}

	public List<Product> getProducts()			{ return this.products;	}

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
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product productID) {
		this.products.add(productID);	
	}

	/**
	 * GENERAL METHODS
	 * ________________________________________________________________________
	 */
	
	public boolean removeProduct(Product ID) {
		return this.products.remove(ID);
	}

}
