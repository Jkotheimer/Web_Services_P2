package cs333.project_2.DOM.Order;

import java.util.List;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;

public class OrderManager {
	
	public List<Order> getOrders(){
		return BuyerDAL.getOrders();
	}
	
	public void addOrder(String attachedBuyerID, String ID, List<String> products) {
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
