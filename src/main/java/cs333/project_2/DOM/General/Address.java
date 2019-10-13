package cs333.project_2.DOM.General;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	String Street;
	String City;
	String State;
	int Zipcode;
	int profileID;
	int ID;

	//constructor     
	public Address(String street, String city, String state, int zipcode, int profileID, int ID) {
		this.Street = street;
		this.City = city;
		this.State = state;
		this.Zipcode = zipcode;
		
		this.profileID = profileID;
		this.ID = ID;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	@Column(name = "street")
	public String getStreet()	{ return this.Street;	}
	
	@Column(name = "city")
	public String getCity()		{ return this.City;		}
	
	@Column(name = "state")
	public String getState()	{ return this.State;	}
	
	@Column(name = "zip")
	public int getZipcode()		{ return this.Zipcode;	}
	
	@Column(name = "profileID")
	public int getProfileID()	{ return this.profileID;}
	
	@Id
	@Column(name = "ID")
	public int getID()			{ return this.ID;		}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setStreet(String street)	{ this.Street = street;		}
	public void setCity(String city)		{ this.City = city;			}
	public void setState(String state)		{ this.State = state;		}
	public void setZipcode(int zipcode)		{ this.Zipcode = zipcode;	}
}
