package cs333.project_2.DOM.Order;

import cs333.project_2.DAL.Order.OrderDAL;

public class OrderManager {
	public void addOrder(int ID, int prod) {
		OrderDAL orderdal = new OrderDAL();
		orderdal.insert(ID, prod);
		// TODO add the order to the database
	}
	
	
	public void readOrder(int serialID) {
		OrderDAL orderdal = new OrderDAL();
		orderdal.read(serialID);
	}
	
	public void updateOrder(int serialID,int newOrderID, int productID) {
		OrderDAL orderdal = new OrderDAL();
		orderdal.update(serialID,newOrderID, productID);
	}
	
	public void deleteOrder(int ID) {
		// TODO delete the given order
		OrderDAL orderdal = new OrderDAL();
		orderdal.deleteOrder(ID);
	}

}
