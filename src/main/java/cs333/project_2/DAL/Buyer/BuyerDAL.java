package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BuyerDAL {

	//Orders should not exist without Buyers, these can probably be separate files but for now they are one
	private static List<Buyer> BuyerDB = new ArrayList<Buyer>(Arrays.asList(new Buyer("acc1","jman","password1"),new Buyer("acc2","jmon","password2"),new Buyer("acc3","jmen","password3")));
	private static List<Order> OrderDB = new ArrayList<Order>();
	
	
	/**
	 * BUYER SPECIFIC DATABASE METHODS
	 */
	public static List<Buyer> getBuyers(){
		return BuyerDB;
	}
	
	public static Buyer insertBuyer(String username, String password) {
		for(Buyer b : BuyerDB) if(b.getUsername().equals(username)) return null;
		String ID = UUID.randomUUID().toString();
		Buyer b = new Buyer(ID,username,password);
		BuyerDB.add(b);
		return b;
	}
	
	public static Buyer login(String username, String password) {
		for(Buyer b : BuyerDB) if(b.AuthenticateCred(username, password)) return b;
		return null;
	}

	public static Buyer getBuyer(String ID) {
		for(Buyer b : BuyerDB) {
			if(b.getID().equals(ID)) {
				return b;
			}
		}
		return null;
	}

	public static int updateBuyer(String ID, String oldPassword, String newPassword) {
	//SerialID is the primary key here which you enter as a parameter for the row you wish to change
		for(Buyer b : BuyerDB) {
			if(b.getID().equals(ID)) {
				if(b.setPassword(oldPassword, newPassword)) return 200;
				else return 401;
			}
		}
		return 404;
	}
	
	public static Buyer updateBuyer(String ID, String newUsername) {
		for(Buyer b : BuyerDB) {
			if(b.getID().equals(ID)) {
				b.setUsername(newUsername);
				return b;
			}
		}
		return null;
	}

	public static Buyer addAddress(String ID, Address addr) {
		for(Buyer b : BuyerDB) {
			if(b.getID().equals(ID)) {
				b.addAddress(addr);
				return b;
			}
		}
		return null;
	}
	
	public static Buyer addPaymentInfo(String ID, PaymentInfo payinf) {
		for(Buyer b : BuyerDB) {
			if(b.getID().equals(ID)) {
				b.addPayInfo(payinf);
				return b;
			}
		}
		return null;
	}
	
	public static int deleteBuyer(String ID) {
		for(Buyer b : BuyerDB) {
			if(b.getID().equals(ID)) {
				BuyerDB.remove(b);
				return 200;
			}
		}
		return 404;
	}
	/**
	 * ORDER SPECIFIC DATABASE METHODS
	 */
	
	public static List<Order> getOrders(String buyerId) {
		List<Order> orders = new ArrayList<>();
		for(Order o : OrderDB) if(o.getBuyerID().equals(buyerId)) orders.add(o);
		return orders;
	}
	
	public static List<Order> getOrders(){
		return OrderDB;
	}
	
	public static Order getOrder(String ID) {
		for(Order o : OrderDB) if(o.getID().equals(ID)) return o;
		return null;
	}
	
	public static Order createOrder(String buyerID, List<String> products) {
		Order o = new Order(UUID.randomUUID().toString(), buyerID, products);
		OrderDB.add(o);
		return o;
	}
	
	public static Order updateOrder(String ID, String status) {
		for(Order o : OrderDB) {
			if(o.getID().equals(ID)) {
				o.updateStatus(status);
				return o;
			}
		}
		return null;
	}
	
	public static int deleteOrder(String ID) {
		for(Order o : OrderDB) {
			if(o.getID().equals(ID)) {
				OrderDB.remove(o);
				return 200;
			}
		}
		return 404;
	}
}
