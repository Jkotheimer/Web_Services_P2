package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyerDAL {

	private static List<Buyer> BuyerDB = new ArrayList<Buyer>(Arrays.asList(new Buyer("acc1","jman","password1"),new Buyer("acc2","jmon","password2"),new Buyer("acc3","jmen","password3")));
	
	public static List<Buyer> getBuyers(){
		return BuyerDB;
	}
	
	public static void insertBuyer(String ID, String username, String password) {
		Buyer toBeAdded = new Buyer(ID,username,password);
		BuyerDB.add(toBeAdded);
	}

	public static Buyer read(String ID) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				return BuyerDB.get(i);
			}
		}
		return null;
	}

	public static void update(String ID,String username, String password) {
	//SerialID is the primary key here which you enter as a parameter for the row you wish to change
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				Buyer change = BuyerDB.get(i);
				change.setPassword(password);
				change.setUsername(username);
			}
		}
	}
	
	public static void addOrder(String ID, Order ord) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				Buyer change = BuyerDB.get(i);
				change.addOrder(ord);
			}
		}
	}

	public static void addAddress(String ID, Address addr) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				Buyer change = BuyerDB.get(i);
				change.addAddress(addr);
			}
		}
	}
	
	public static void addPaymentInfo(String ID, PaymentInfo payinf) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				Buyer change = BuyerDB.get(i);
				change.addPayInfo(payinf);
			}
		}
	}
	
	public static void deleteBuyer(String ID) {
		for(int i=0;i<BuyerDB.size();i++) {
			if(BuyerDB.get(i).getBuyerID() == ID) {
				BuyerDB.remove(i);
			}
		}
	}

}
