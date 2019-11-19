package cs333.project_2.DOM.General;

public class PaymentInfo {    

    private String CreditCardNum;
    private String CreditCardHolder;
    private String ExpDate;
    private int CCV;
    private int billingAddressID;

    public PaymentInfo(String creditcardnum, String creditcardholder, String expdate, int ccv, int billingAddressID) {
        this.CreditCardNum = creditcardnum;
        this.CreditCardHolder = creditcardholder;
        this.ExpDate = expdate;
        this.CCV = ccv;
        this.billingAddressID = billingAddressID;
    }

	/**
	 * GETTERS
	 * ________________________________________________________________________
	 */

    public String getCreditCardNum() {
        return this.CreditCardNum;
    }

    public String getCreditCardHolder() {
        return this.CreditCardHolder;
    }

    public String getExpDate() {
        return this.ExpDate;
    }

    public int getCCV() {
        return this.CCV;
    }
 
    public int getBillingAddressID() {
        return this.billingAddressID;
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

    public void setBillingAddress(int billingaddress) {
        this.billingAddressID = billingaddress;
    }
}
