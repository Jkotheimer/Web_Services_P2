package cs333.project_2.Service.Respresentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation {
	
	private int price;
	private String itemdescrip;
	private int Id;

	public ProductRepresentation() {}

	public String getItemDescrip() {
		return itemdescrip;
	}

	public void setItemDescrip(String desc) {
		this.itemdescrip = desc;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int Price) {
		this.price = Price;
	}

}
