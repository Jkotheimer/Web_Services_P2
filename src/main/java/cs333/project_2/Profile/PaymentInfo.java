package cs333.project_2.Profile;

<<<<<<< HEAD
public class PaymentInfo {

	String CreditCardNum;
	String CreditCardHolder;
	String ExpDate;
	int CCV;
	Address BillingAddress;

	//constructor
	public PaymentInfo(String creditcardnum, String creditcardholder, String expdate, int ccv, Address billingaddress) {

		this.CreditCardNum = creditcardnum;
		this.CreditCardHolder = creditcardholder;
		this.ExpDate = expdate;
		this.CCV = ccv;
		this.BillingAddress = billingaddress;
	}

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

	public String getCreditCardNum()	{ return this.CreditCardNum;	}
	public String getCreditCardHolder()	{ return this.CreditCardHolder;	}
	public String getExpDate()			{ return this.ExpDate;			}
	public int getCCV()					{ return this.CCV;				}
	public Address getBillingAddress()	{ return this.BillingAddress;	}

	/**
	 * SETTERS
	 * ________________________________________________________________________
	 */

	public void setCreditCardNum(String creditcardnum) {
		this.CreditCardNum = creditcardnum;
	}

	public void setCreditCardHolder(String creditcardholder) {
		this.CreditCardHolder = creditcardholder;
	}

	public void setExpDate(String expdate) {
		this.ExpDate = expdate;
	}

	public void setCCV(int ccv){
		this.CCV = ccv;
	}

	public void setBillingAddress(Address billingaddress) {
		this.BillingAddress = billingaddress;
	}
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymentinfo")
public class PaymentInfo
{    

    private int CreditCardNum;
    private String CreditCardHolder;
    private String ExpDate;
    int CCV;
    private String BillingAddress;

    //constructor

    public PaymentInfo(int creditcardnum,String creditcardholder,String expdate,int ccv, String billingaddress){
        this.CreditCardNum = creditcardnum;
        this.CreditCardHolder = creditcardholder;
        this.ExpDate = expdate;
        this.CCV = ccv;
        this.BillingAddress = billingaddress;
    }
    
    public PaymentInfo() {
    	
    }

    //getters
    @Id
    @Column(name="creditcardno")
    public int getCreditCardNum(){
        return this.CreditCardNum;
    }
    @Column(name="cardholder")
    public String getCreditCardHolder(){
        return this.CreditCardHolder;
    }
    @Column(name="expirydate")
    public String getExpDate(){
        return this.ExpDate;
    }
    @Column(name="cvv")
    public int getCCV(){
        return this.CCV;
    }
    @Column(name="billingaddress")
    public String getBillingAddress(){
        return this.BillingAddress;
    }

    //setters

    public void setCreditCardNum(int creditcardnum){
        this.CreditCardNum = creditcardnum;
    }

    public void setCreditCardHolder(String creditcardholder){
        this.CreditCardHolder = creditcardholder;
    }

    public void setExpDate(String expdate){
        this.ExpDate = expdate;
    }

    public void setCCV(int ccv){
        this.CCV = ccv;
    }

    public void setBillingAddress(String billingaddress){
        this.BillingAddress = billingaddress;
    }

>>>>>>> 5702834c98956e625b6dc1671306b5afd4b8d612
}
