package cs333.project_2.DOM.Buyer;

import java.util.List;

import cs333.project_2.DAL.Buyer.BuyerDAL;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Product.Product;

public class BuyerManager {
	
	public static List<Buyer> getBuyers() {
		List<Buyer> buyers = BuyerDAL.getBuyers();
		return buyers;
	}
	
	public static Buyer login(String username, String password) {
		return BuyerDAL.read(username, password);
	}
	
    public static Buyer getBuyer(String ID) {
    	return BuyerDAL.read(ID);
	}
    
	public static Buyer addBuyer(String username,String password) {
		return BuyerDAL.insertBuyer(username,password);
	}
	
	public static void deleteBuyer(String ID) {
		BuyerDAL.deleteBuyer(ID);
	}
	
	public static int changePassword(String ID, String oldPassword, String newPassword) {
		return BuyerDAL.update(ID, oldPassword, newPassword);
	}
	
	public static Buyer changeUsername(String ID, String newUsername) {
		return BuyerDAL.update(ID, newUsername);
	}

	public static void insertOrder(String attachedBuyerID, String ID, List<Product> products) {
		BuyerDAL.insertOrder(attachedBuyerID, ID, products);
	}
	
	public static void addOrder(String ID, Order ord) {
		BuyerDAL.addOrder(ID, ord);
	}

	public static Buyer addAddress(String ID, Address addr) {
		return BuyerDAL.addAddress(ID, addr);
	}
	
	public static Buyer addPaymentInfo(String ID, PaymentInfo payinf) {
		return BuyerDAL.addPaymentInfo(ID, payinf);
	}
	
}
