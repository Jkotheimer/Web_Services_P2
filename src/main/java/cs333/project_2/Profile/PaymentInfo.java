package cs333.project_2.Profile;
import cs333.project_2.Profile.Address;

public class PaymentInfo
{    

    String CreditCardNum;
    String CreditCardHolder;
    String ExpDate;
    int CCV;
    Address BillingAddress;

    //constructor

    public PaymentInfo(String creditcardnum,String creditcardholder,String expdate,int ccv, Address billingaddress){
        this.CreditCardNum = creditcardnum;
        this.CreditCardHolder = creditcardholder;
        this.ExpDate = expdate;
        this.CCV = ccv;
        this.BillingAddress = billingaddress;
    }

    //getters

    public String getCreditCardNum(){
        return this.CreditCardNum;
    }

    public String getCreditCardHolder(){
        return this.CreditCardHolder;
    }

    public String getExpDate(){
        return this.ExpDate;
    }

    public int getCCV(){
        return this.CCV;
    }

    public Address getBillingAddress(){
        return this.BillingAddress;
    }

    //setters

    public void setCreditCardNum(String creditcardnum){
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

    public void setBillingAddress(Address billingaddress){
        this.BillingAddress = billingaddress;
    }

}