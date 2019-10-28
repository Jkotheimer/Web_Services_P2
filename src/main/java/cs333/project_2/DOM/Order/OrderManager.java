package cs333.project_2.DOM.Order;

import java.util.HashSet;
import java.util.Set;

import cs333.project_2.DAL.Order.OrderDAL;
import cs333.project_2.DOM.Order.Order;

public class OrderManager {
	
	public Set<Order> getOrders(){
		Set<Order> orders = new HashSet<Order>();
		Order a = new Order(123,12);
		Order b = new Order(124,11);
		Order c = new Order(125,9);
		orders.add(a);
		orders.add(b);
		orders.add(c);
		return orders;
	}
	
	public void addOrder(int ID, int prod) {
		OrderDAL.insert(ID, prod);
		// TODO add the order to the database
	}
	
	public Order readOrder(int serialID) {
		return OrderDAL.read(serialID);
	}
	
	public void updateOrder(int serialID,int newOrderID, int orderID) {
		OrderDAL.update(serialID,newOrderID, orderID);
	}
	
	public void deleteOrder(int ID) {
		// TODO delete the given order
		OrderDAL.deleteOrder(ID);
	}

}
