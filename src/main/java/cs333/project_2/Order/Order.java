package cs333.project_2.Order;

/**
 * Hello world!
 *
 */
public class Order
{
    String ID;
    String Status;
    String[] OrderedProd;
    String Producer;
    String Customer;

    public Order creatOrder(String[] ProductID, String cust){
        Order newOrder = new Order();
        newOrder.UpdateStatus("Order Placed");
        newOrder.setCustomer(cust);
        return newOrder;
    };

    public void setID(String ident){
        this.ID = ident;
    }

    public boolean UpdateStatus(String stat){
        this.Status = stat;
        return true;
    }

    public void setCustomer(String cust){
        this.Customer = cust;
    }
}