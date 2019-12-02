package cs333.project_2.Service.Respresentation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cs333.project_2.DOM.Product.Product;
import cs333.project_2.Service.AbstractRepresentation;

@XmlRootElement(name = "Seller")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class SellerRepresentation extends AbstractRepresentation{

	private final String accountType = "seller";
	private String username;
	private String sellerID;
	private List<Product> products = new ArrayList<Product>();
	
	public SellerRepresentation() {
		
	}

	public SellerRepresentation(String ID, String username) {
		this.username = username;	
		this.sellerID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getAccountType()			{ return this.accountType; }
	
	public String getUsername()				{ return this.username;	}

	public String getsellerID()				{ return this.sellerID;		}

	public List<Product> getProducts()		{ return this.products;	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public boolean setUsername(String username) {
		// TODO - possibly add a database check for other profiles with the given username
		this.username = username;
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
