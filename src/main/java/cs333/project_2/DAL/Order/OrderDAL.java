package cs333.project_2.DAL.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cs333.project_2.DOM.Order.Order;

public class OrderDAL {
	public static void main(String[] args) {

		//create a Session Factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try {

			System.out.println("Creating a new Order object...");

			//create the Order object
			Order order = new Order(1234, new int[]{4567, 9367}, 9870);

			//start a transaction
			session.beginTransaction();

			//Save the Order object to the database
			session.save(order);

			System.out.println("Order created in Database!");
			//commit the transaction
			session.getTransaction().commit();

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			//Read the order
			System.out.println("Getting the Order based on id: " + order.getID());

			Order readorder = (Order)session.get(Order.class, order.getID());   //specify PRIMARY KEY of the order

			System.out.println("Retrieved Order details : " + order);

			//commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

		// delete a row in the database
		try {
			int ID = 1;
			//Deleting a single Order
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Order with id : " + ID);

			Order readOrder = (Order)session.get(Order.class, ID);   //specify PRIMARY KEY of the Order
			System.out.println("Deleting Order...");

			session.delete(readOrder);

			/*
			//delete Order id=3001
			System.out.println("Deleting Order where id=3001");
			session.createQuery("delete from Order where id=3001").executeUpdate();
			*/

			//commit the transaction
			session.getTransaction().commit();	

		} finally {
			//session.flush();
			session.close();
			sessionFactory.close();
		}
	}
}
