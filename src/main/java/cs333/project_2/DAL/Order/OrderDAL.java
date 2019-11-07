package cs333.project_2.DAL.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Order.Order;

public class OrderDAL {
	
	private static List<Order> OrderDB = new ArrayList<Order>(Arrays.asList(new Order("acc1","jman","password1"),new Order("acc2","jmon","password2"),new Order("acc3","jmen","password3")));
	
	public static List<Order> getOrders(){
		return OrderDB;
	}
	
	public static void insertOrder(String ID, String username, String password) {
		Order toBeAdded = new Order(ID,username,password);
		OrderDB.add(toBeAdded);
	}

	public static Order read(String ID) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getOrderID() == ID) {
				return OrderDB.get(i);
			}
		}
		return null;
	}

	public static void update(String ID,String username, String password) {
	//SerialID is the primary key here which you enter as a parameter for the row you wish to change
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getOrderID() == ID) {
				Order change = OrderDB.get(i);
				change.setPassword(password);
				change.setUsername(username);
			}
		}
	}
	
	public static void addOrder(String ID, Order ord) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getOrderID() == ID) {
				Order change = OrderDB.get(i);
				change.addOrder(ord);
			}
		}
	}

	public static void addAddress(String ID, Address addr) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getOrderID() == ID) {
				Order change = OrderDB.get(i);
				change.addAddress(addr);
			}
		}
	}
	
	public static void addPaymentInfo(String ID, PaymentInfo payinf) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getOrderID() == ID) {
				Order change = OrderDB.get(i);
				change.addPayInfo(payinf);
			}
		}
	}
	
	public static void deleteOrder(String ID) {
		for(int i=0;i<OrderDB.size();i++) {
			if(OrderDB.get(i).getOrderID() == ID) {
				OrderDB.remove(i);
			}
		}
	}
	
}

		
