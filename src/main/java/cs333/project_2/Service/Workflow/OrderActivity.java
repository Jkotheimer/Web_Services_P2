package cs333.project_2.Service.Workflow;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Order.OrderManager;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.Service.Link;
import cs333.project_2.Service.Respresentation.OrderRepresentation;
/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the OrderDAL object.  
 *
 */
public class OrderActivity {
	
	public List<OrderRepresentation> getOrders() {
		
		List<Order> orders = new ArrayList<Order>();
		List<OrderRepresentation> orderRepresentations = new ArrayList<OrderRepresentation>();
		orders = OrderManager.getOrders();
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order o = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
          orderRepresentation.setOrderID(o.getID());
          orderRepresentation.updateStatus(o.getStatus());
          orderRepresentation.setOrderedProductIDs(o.getOrderedProductIDs());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(String id) {
		
		Order o = OrderManager.readOrder(id);
		
		OrderRepresentation oRep = new OrderRepresentation();
		oRep.setOrderedProductIDs(o.getOrderedProductIDs());
		oRep.updateStatus(o.getStatus());
		oRep.setOrderID(o.getID());
		setLinks(oRep);
		return oRep;
	}
	
	public OrderRepresentation createOrder(String ID, String purchaserID, List<Product> productIDs) {
		
		OrderManager.addOrder(ID,purchaserID,productIDs);
		Order o = new Order(ID,BuyerDAL.read(purchaserID),productIDs);
		
		OrderRepresentation oRep = new OrderRepresentation();
		oRep.setOrderID(o.getID());
		oRep.updateStatus(o.getStatus());
		oRep.setOrderedProductIDs(o.getOrderedProductIDs());
		
		return oRep;
	}
	
	public String deleteOrder(String id) {
		
		//dao.deleteOrder(id);
		OrderManager.deleteOrder(id);
		
		return "OK";
	}
	
	private void setLinks(OrderRepresentation order) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("buy", 
			"http://api.mississippi.com:8080/bookstore/books/order?book_id=" + order.getID());	
		order.setLinks(buy);
	}
	
}
