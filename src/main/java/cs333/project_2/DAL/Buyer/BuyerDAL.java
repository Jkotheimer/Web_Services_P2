package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyerDAL {

	//Orders should not exist without Buyers, these can probably be separate files but for now they are one
	private static List<Buyer> BuyerDB = new ArrayList<Buyer>(Arrays.asList(new Buyer("acc1","jman","password1"),new Buyer("acc2","jmon","password2"),new Buyer("acc3","jmen","password3")));
	private static List<Order> OrderDB = new ArrayList<Order>();
	
	public BuyerDAL() {}
	
	public static List<Buyer> getBuyers(){
		return BuyerDB;
	}
	
	public static List<Order> getOrders(){
		return OrderDB;
	}
	
	public static void insertBuyer(String ID, String username, String password) {
		BuyerDB.add(new Buyer(ID,username,password));
	}
	
	public static void insertOrder(String attachedBuyerID, String ID, List<String> products) {
		for(Buyer b : BuyerDB)
			if(b.getBuyerID() == attachedBuyerID)
				OrderDB.add(new Order(ID,b.getBuyerID(),products));
	}

	public static Buyer read(String ID) {
		for(Buyer b : BuyerDB) if(b.getBuyerID() == ID) return b;
		return null;
	}
	
	public static Order readOrder(String ID) {
		for(Order o : OrderDB) if(o.getID() == ID) return o;
		return null;
	}

	public static void update(String ID,String username, String password) {
		for(Buyer b : BuyerDB) {
			if(b.getBuyerID() == ID) {
				b.setPassword(password);
				b.setUsername(username);
			}
		}
	}
	
	public static void updateOrder(String ID, String status) {
		for(Order o : OrderDB) if(o.getID() == ID) o.updateStatus(status);
	}
	
	public static void addOrder(String ID, Order ord) {
		for(Buyer b : BuyerDB) if(b.getBuyerID() == ID) b.addOrder(ord);
	}

	public static void addAddress(String ID, Address addr) {
		for(Buyer b : BuyerDB) if(b.getBuyerID() == ID) b.addAddress(addr);
	}
	
	public static void addPaymentInfo(String ID, PaymentInfo payinf) {
		for(Buyer b : BuyerDB) if(b.getBuyerID() == ID) b.addPayInfo(payinf);
	}
	
	public static void deleteBuyer(String ID) {
		for(Buyer b : BuyerDB) if(b.getBuyerID() == ID) BuyerDB.remove(b);
	}
	
	public static void deleteOrder(String ID) {
		for(Order o : OrderDB) if(o.getID() == ID) OrderDB.remove(o);
	}

}
