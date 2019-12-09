package cs333.project_2.DOM.Order;

import java.util.List;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;

public class OrderManager {
	
	public static List<Order> getOrders(){
		return BuyerDAL.getOrders();
	}
	
	public static List<Order> getOrders(String buyerId) {
		return BuyerDAL.getOrders(buyerId);
	}
	
	public static Order getOrder(String ID) {
		return BuyerDAL.getOrder(ID);
	}
	
	public static Order createOrder(String buyerID, List<String> products) {
		return BuyerDAL.createOrder(buyerID, products);
	}
	
	public static Order updateOrder(String ID, String newStatus) {
		return BuyerDAL.updateOrder(ID, newStatus);
	}
	
	public static int deleteOrder(String ID) {
		return BuyerDAL.deleteOrder(ID);
	}

}
