package cs333.project_2.Service.Workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	
	public Set<OrderRepresentation> getOrders() {
		
		Set<Order> orders = new HashSet<Order>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
		orders = ord.getOrders();
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order p = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
          orderRepresentation.setId(p.getOrderID());
          orderRepresentation.setStatus(p.getStatus());
          orderRepresentation.setProductId((int)p.getOrderedProductIDs());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(int id) {
		
		Order p = ord.readOrder(id);
		
		OrderRepresentation pRep = new OrderRepresentation();
		pRep.setProductId((int)p.getOrderedProductIDs());
		pRep.setStatus(p.getStatus());
		pRep.setId(p.getOrderID());
		
		return pRep;
	}
	
	public OrderRepresentation createOrder(int ID,int ProductID) {
		
		ord.addOrder(ID,ProductID);
		Order p = new Order(ID,ProductID);
		
		OrderRepresentation pRep = new OrderRepresentation();
		pRep.setId(p.getOrderID());
		pRep.setStatus(p.getStatus());
		pRep.setProductId((int)p.getOrderedProductIDs());
		
		return pRep;
	}
	
	public String deleteOrder(int id) {
		
		//dao.deleteOrder(id);
		ord.deleteOrder(id);
		
		return "OK";
	}
	
}
