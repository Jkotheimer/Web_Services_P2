package cs333.project_2.DOM.General;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;



//@Entity
//@Table(name="address")
@Embeddable
public class Address {
	@Column(name="Address_id")
	private int Id;
	@Column(name = "street")
	private String Street;
	@Column(name = "city")
    private	String City;
	@Column(name = "state")
	private String State;
	@Column(name = "zipcode")
	private int Zipcode;

	//constructor 
	
	public Address(String street, String city, String state, int zipcode) {
		this.Street = street;
		this.City = city;
		this.State = state;
		this.Zipcode = zipcode;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getStreet()	{ return this.Street;	}
	public String getCity()		{ return this.City;		}
	public String getState()	{ return this.State;	}
	public int getZipcode()		{ return this.Zipcode;	}

	public String ConvertAddresstoString() {
    	return this.Street + ", " + this.City + ", " + this.State + " " + this.Zipcode;
	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setStreet(String street)	{ this.Street = street;		}
	public void setCity(String city)		{ this.City = city;			}
	public void setState(String state)		{ this.State = state;		}
	public void setZipcode(int zipcode)		{ this.Zipcode = zipcode;	}
}
