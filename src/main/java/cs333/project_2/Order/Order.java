package cs333.project_2.Order;

public class Order
{
    String ID;
    String Status;
    String[] OrderedProd;
    String Producer;
    String Customer;

    public Order creatOrder(String[] ProductID, String customer){
        Order newOrder = new Order();
        newOrder.UpdateStatus("Order Placed");
        newOrder.setCustomer(customer);
        return newOrder;
    };

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
}