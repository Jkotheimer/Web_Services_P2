package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cs333.project_2.DOM.Seller.Seller;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRequest {
	
	private String productID;
	private double Price;
	private Seller seller;
	private String ItemDescrip;

	public ProductRequest() {
	
	}
	
	public ProductRequest(String ID, float price, String itemDescrip, Seller producer) {
		this.productID = ID;
		this.Price = price;
		this.ItemDescrip = itemDescrip;
		this.seller = producer;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */
	
	public void setproductID(String productId) {
		this.productID = productId;
	}

	public void setPrice(double price) {
		Price = price;
	}
	public void setItemDescrip(String itemdescrip) {
		this.ItemDescrip = itemdescrip;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */
	
	public String getProductID() {
		return this.productID;
	}

	public double getPrice() {
		return this.Price;
	}

	public String getItemDescrip() {
		return this.ItemDescrip;
	}

	public Seller getSeller() {
		return this.seller;
	}

}
