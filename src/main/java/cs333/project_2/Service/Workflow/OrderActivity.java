package cs333.project_2.Service.Workflow;

import java.util.ArrayList;

import java.util.List;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Order.OrderManager;
import cs333.project_2.Service.Link;
import cs333.project_2.Service.Representation.OrderRepresentation;
import cs333.project_2.Service.Representation.ProductRepresentation;
/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the OrderDAL object.  
 *
 */
public class OrderActivity {
	
	public List<OrderRepresentation> getOrders() {
		
		List<Order> orders = OrderManager.getOrders();
		List<OrderRepresentation> orderRepresentations = new ArrayList<OrderRepresentation>();
		if(orders.size() == 0) return null;
		
		for(Order o : orders) {
          List<ProductRepresentation> products = convertToProductList(o.getProductIDs());
          OrderRepresentation orderRepresentation = new OrderRepresentation(o.getID(), o.getBuyerID(), products);
          orderRepresentation.updateStatus(o.getStatus());
          setLinks(orderRepresentation);
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public List<OrderRepresentation> getOrders(String buyerId) {
		
		List<Order> orders = OrderManager.getOrders(buyerId);
		List<OrderRepresentation> oReps = new ArrayList<>();
		
		for(Order o : orders) {
			List<ProductRepresentation> products = convertToProductList(o.getProductIDs());
			OrderRepresentation oRep = new OrderRepresentation(o.getID(), o.getBuyerID(), products);
			oRep.updateStatus(o.getStatus());
			setLinks(oRep);
			oReps.add(oRep);
		}
		return oReps;
	}
	
	public OrderRepresentation createOrder(String buyerID, List<String> productIDs) {
		
		Order o = OrderManager.createOrder(buyerID, productIDs);
		if(o == null) return null;
		List<ProductRepresentation> products = convertToProductList(productIDs);
		OrderRepresentation oRep = new OrderRepresentation(o.getID(), o.getBuyerID(), products);
		oRep.updateStatus(o.getStatus());
		setLinks(oRep);
		
		return oRep;
	}
	
	public OrderRepresentation updateOrder(String ID, String status) {
		
		Order o = OrderManager.updateOrder(ID, status);
		if(o == null) return null;
		List<ProductRepresentation> products = convertToProductList(o.getProductIDs());
		OrderRepresentation oRep = new OrderRepresentation(o.getID(), o.getBuyerID(), products);
		oRep.updateStatus(o.getStatus());
		setLinks(oRep);
		
		return oRep;
	}
	
	public int deleteOrder(String id) {
		return OrderManager.deleteOrder(id);
	}
	
	private List<ProductRepresentation> convertToProductList(List<String> productIDs) {
		List<ProductRepresentation> products = new ArrayList<>();
		ProductActivity pa = new ProductActivity();
		for(String productID : productIDs) {
			products.add(pa.getProductById(productID));
		}
		return products;
	}
	
	private void setLinks(OrderRepresentation order) {
		// Set up the activities that can be performed on orders
		Link[] buy = new Link[] {
				new Link("Update", "http://localhost:8081/orders/" + order.getID() + "?status="),
				new Link("Delete", "http://localhost:8081/orders/" + order.getID())
		};
		order.setLinks(buy);
	}
	
}
