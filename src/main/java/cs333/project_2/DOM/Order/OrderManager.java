package cs333.project_2.DOM.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;

public class OrderManager {
	
	public Set<Order> getOrders(){
		return BuyerDAL.getOrders();
	}
	
	public void addOrder(String attachedBuyerID, String ID, List<Product> products) {
		BuyerDAL.insertOrder(attachedBuyerID, ID, products);
	}
	
	public Order readOrder(String ID) {
		return BuyerDAL.readOrder(ID);
	}
	
	public void updateOrder(String ID, String newStatus) {
		BuyerDAL.updateOrder(ID, newStatus);
	}
	
	public void deleteOrder(String ID) {
		BuyerDAL.deleteOrder(ID);
	}

}
