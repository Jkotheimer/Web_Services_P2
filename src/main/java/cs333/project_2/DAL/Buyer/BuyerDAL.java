package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.UUID;

public class BuyerDAL {

	//Orders should not exist without Buyers, these can probably be separate files but for now they are one
	private static List<Buyer> BuyerDB = new ArrayList<Buyer>(Arrays.asList(new Buyer("acc1","jman","password1"),new Buyer("acc2","jmon","password2"),new Buyer("acc3","jmen","password3")));
	private static List<Order> OrderDB = new ArrayList<Order>();
	
	public static List<Buyer> getBuyers(){
		return BuyerDB;
	}
	
	public static List<Order> getOrders(){
		return OrderDB;
	}
	
	public static Buyer insertBuyer(String username, String password) {
		for(Buyer b : BuyerDB) if(b.getUsername().equals(username)) return null;
		String ID = UUID.randomUUID().toString();
		Buyer b = new Buyer(ID,username,password);
		BuyerDB.add(b);
		return b;
	}
	
	public static void insertOrder(String attachedBuyerID, String ID, List<Product> products) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID().equals(attachedBuyerID)) {
				Buyer selected = BuyerDB.get(i);
				Order newOrder = new Order(ID,selected,products);
				selected.addOrder(newOrder);
			}
		}
	}
	
	public static Buyer read(String username, String password) {
		for(Buyer b : BuyerDB) if(b.AuthenticateCred(username, password)) return b;
		return null;
	}

	public static Buyer read(String ID) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(Pattern.matches(ID,BuyerDB.get(i).getBuyerID())) {
				return BuyerDB.get(i);
			}
		}
		return new Buyer("acc1","NOTFOUND","password1");
	}
	
	public static Order readOrder(String ID) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getID().equals(ID)) {
				return OrderDB.get(i);
			}
		}
		return null;
	}

	public static int update(String ID, String oldPassword, String newPassword) {
	//SerialID is the primary key here which you enter as a parameter for the row you wish to change
		for(Buyer b : BuyerDB) {
			if(b.getBuyerID().equals(ID)) {
				if(b.setPassword(oldPassword, newPassword)) return 200;
				else return 401;
			}
		}
		return 404;
	}
	
	public static Buyer update(String ID, String newUsername) {
		for(Buyer b : BuyerDB) {
			if(b.getBuyerID().equals(ID)) {
				b.setUsername(newUsername);
				return b;
			}
		}
		return null;
	}
	
	public static void updateOrder(String ID, String status) {
		//SerialID is the primary key here which you enter as a parameter for the row you wish to change
			for(int i=0;i<OrderDB.size();i++) {
				if(OrderDB.get(i).getID().equals(ID)) {
					Order change = OrderDB.get(i);
					change.updateStatus(status);
				}
			}
		}
	
	public static void addOrder(String ID, Order ord) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID().equals(ID)) {
				Buyer change = BuyerDB.get(i);
				change.addOrder(ord);
			}
		}
	}

	public static Buyer addAddress(String ID, Address addr) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID().equals(ID)) {
				Buyer change = BuyerDB.get(i);
				change.addAddress(addr);
				return change;
			}
		}
		return null;
	}
	
	public static Buyer addPaymentInfo(String ID, PaymentInfo payinf) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID().equals(ID)) {
				Buyer change = BuyerDB.get(i);
				change.addPayInfo(payinf);
				return BuyerDB.get(i);
			}
		}
		return null;
	}
	
	public static void deleteBuyer(String ID) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				BuyerDB.remove(i);
			}
		}
	}
	
	public static void deleteOrder(String ID) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getID() == ID) {
				OrderDB.remove(i);
			}
		}
	}

}
