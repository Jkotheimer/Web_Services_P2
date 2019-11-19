package cs333.project_2.DOM.Buyer;

import java.util.List;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;

public class BuyerManager {
	
	public static List<Buyer> getBuyers() {
		return BuyerDAL.getBuyers();
	}
	
    public static Buyer getBuyer(String ID) {
    	return BuyerDAL.read(ID);
	}
    
	public static void addBuyer(String ID,String username,String password) {
		BuyerDAL.insertBuyer(ID,username,password);
	}
	
	public static void deleteBuyer(String ID) {
		BuyerDAL.deleteBuyer(ID);
	}
	
	public static void updateBuyer(String ID, String username, String password) {
		BuyerDAL.update(ID,username,password);
	}

	public static void insertOrder(String attachedBuyerID, String ID, List<String> products) {
		BuyerDAL.insertOrder(attachedBuyerID, ID, products);
	}
	
	public static void addOrder(String ID, Order ord) {
		BuyerDAL.addOrder(ID, ord);
	}

	public static void addAddress(String ID, Address addr) {
		BuyerDAL.addAddress(ID, addr);
	}
	
	public static void addPaymentInfo(String ID, PaymentInfo payinf) {
		BuyerDAL.addPaymentInfo(ID, payinf);
	}
	
}
