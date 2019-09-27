package cs333.project_2.Order;

public class Order
{
    String ID;
    String Status;
    String[] OrderedProd;
    // TODO Producer and Consumer as actual objects
    String Producer;
    String Customer;
    // TODO payment info

    public Order(String[] ProductID, String customer){
		this.OrderedProd = ProductID;
        this.Status = "Order Placed";
		this.Customer = customer;
    };

    //setters
    public void setID(String id){
        this.ID = id;
    }

    public boolean UpdateStatus(String status){
        this.Status = status;
        return true;
    }

    public void setCustomer(String customer){
        this.Customer = customer;
    }

    // getters
    public String getID(){
        return this.ID;
    }

    public String getStatus(){
        return this.Status;
    }

    public String getCustomer(){
        return this.Customer;
    }

}
