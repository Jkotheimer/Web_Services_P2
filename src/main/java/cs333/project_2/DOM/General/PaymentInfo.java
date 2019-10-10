package cs333.project_2.DOM.General;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymentinfo")
public class PaymentInfo {    

    private String CreditCardNum;
    private String CreditCardHolder;
    private String ExpDate;
    private int CCV;
    private Address BillingAddress;

    public PaymentInfo(String creditcardnum, String creditcardholder, String expdate, int ccv,  Address billingaddress) {
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

    @Id
    @Column(name="creditcardno")
    public String getCreditCardNum() {
        return this.CreditCardNum;
    }
    @Column(name="cardholder")
    public String getCreditCardHolder() {
        return this.CreditCardHolder;
    }
    @Column(name="expirydate")
    public String getExpDate() {
        return this.ExpDate;
    }
    @Column(name="cvv")
    public int getCCV() {
        return this.CCV;
    }
    @Column(name="billingaddress")
    public Address getBillingAddress() {
        return this.BillingAddress;
    }

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

    public void setCCV(int ccv) {
        this.CCV = ccv;
    }

    public void setBillingAddress(Address billingaddress) {
        this.BillingAddress = billingaddress;
    }
}
