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

    public Order createOrder(String[] ProductID, String customer){
        Order newOrder = new Order();
        newOrder.UpdateStatus("Order Placed");
        newOrder.setCustomer(customer);
        return newOrder;
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