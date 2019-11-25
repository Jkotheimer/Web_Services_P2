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
	
	public static void addOrder(String attachedBuyerID, String ID, List<Product> products) {
		BuyerDAL.insertOrder(attachedBuyerID, ID, products);
	}
	
	public static Order readOrder(String ID) {
		return BuyerDAL.readOrder(ID);
	}
	
	public static List<Order> getBuyersOrders(String Id){
		Buyer currentBuy = BuyerDAL.read(Id);
		return currentBuy.getOrders();
	}
	
	public static void updateOrder(String ID, String newStatus) {
		BuyerDAL.updateOrder(ID, newStatus);
	}
	
	public static void deleteOrder(String ID) {
		BuyerDAL.deleteOrder(ID);
	}

}
