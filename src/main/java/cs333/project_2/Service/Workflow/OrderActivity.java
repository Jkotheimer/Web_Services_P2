package cs333.project_2.Service.Workflow;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Order.OrderManager;
import cs333.project_2.Service.Respresentation.OrderRepresentation;;
/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the OrderDAL object.  
 *
 */
public class OrderActivity {

	private static OrderManager ord = new OrderManager();
	
	public List<OrderRepresentation> getOrders() {
		
		List<Order> orders = new ArrayList<Order>();
		List<OrderRepresentation> orderRepresentations = new ArrayList<OrderRepresentation>();
		orders = ord.getOrders();
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order p = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
          orderRepresentation.setId(p.getID());
          orderRepresentation.setStatus(p.getStatus());
          orderRepresentation.setProducts(p.getOrderedProducts());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(String id) {
		
		Order p = ord.readOrder(id);
		
		OrderRepresentation pRep = new OrderRepresentation();
		pRep.setProducts(p.getOrderedProducts());
		pRep.setStatus(p.getStatus());
		pRep.setId(p.getID());
		
		return pRep;
	}
	
	public OrderRepresentation createOrder(String ID, String buyerID, List<String> Products) {
		
		ord.addOrder(buyerID, ID, Products);
		Order p = new Order(ID, buyerID, Products);
		
		OrderRepresentation pRep = new OrderRepresentation();
		pRep.setId(p.getID());
		pRep.setStatus(p.getStatus());
		pRep.setProducts(p.getOrderedProducts());
		
		return pRep;
	}
	
	public String deleteOrder(String id) {
		
		//dao.deleteOrder(id);
		ord.deleteOrder(id);
		
		return "OK";
	}
	
}
