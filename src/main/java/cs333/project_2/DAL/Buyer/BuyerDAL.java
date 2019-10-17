package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.Order.Order;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import cs333.project_2.DOM.Buyer.Buyer;

public class BuyerDAL {
	public static void main(String[] args) {
		
		
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Buyer.class).
				buildSessionFactory();
		
		Configuration cfg = new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		


		session.beginTransaction();
		

			System.out.println("Creating a new Buyer object...");

			//create the Buyer object
			
			//Order instantiated with generating an OrderID
			Buyer buyer = new Buyer();
			buyer.setbuyerID(101);
			buyer.setUsername("rayyanshaji");
			buyer.setAddress("43 xyz st");	
			
			
			
			//Creating Order Object
			Order order = new Order();
			
			//Order ID should come from the generated Buyer class
			order.setOrderID(425);
			order.setOrderedProductIDs(1182);
			order.setBuyer(buyer);
			
			buyer.getOrderIDs().add(order);
//			List<Order> orderlist = new ArrayList<Order>();
//			buyer.setOrderIDs(orderlist);
//			
//			orderlist.add(order);
			
			
			
					
			//System.out.println(buyer.getID());
			//System.out.println(orderlist.get(0).getBuyer().getID());
			//starting a transaction
			

			//Saving the Buyer object to the database
			
			//session.beginTransaction();
			//
			session.save(buyer);
			session.save(order);
		
			
			
			
			
			
			
			
			

			System.out.println("Buyer created in Database!");
			//commit the transaction
			session.getTransaction().commit();
//
//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//
//			//Read the buyer
//			System.out.println("Getting the buyer based on id: " + buyer.getID());
//
//			Buyer readBuyer = session.get(Buyer.class, buyer.getID());   //specify PRIMARY KEY of the buyer
//
//			System.out.println("Retrieved buyer details : " + readBuyer);

			//Commit the transaction
		

		
			
			session.close();
			sessionFactory.close();
//		}

		// delete a row in the database
//		try{
//			int ID = 1;
//			//Deleting a single Buyer
//			//Get a new session and begin transaction
//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//
//			System.out.println("Retrieving Buyer with id : " + ID);
//
//			Buyer readBuyer = session.get(Buyer.class, ID);   //specify PRIMARY KEY of the Buyer
//			System.out.println("Deleting Buyer...");
//
//			session.delete(readBuyer);
//
//			/*
//			//delete Buyer id=3001
//			System.out.println("Deleting Buyer where id=3001");
//			session.createQuery("delete from Buyer where id=3001").executeUpdate();
//			*/
//
//			//commit the transaction
//			session.getTransaction().commit();	
//
//		}finally{
//			session.flush();
//			session.close();
//			sessionFactory.close();
//			//Closing the session.
//		}
//}
	
//	public static synchronized SessionFactory getSessionFactory() {
//		SessionFactory sessionFactory = new Configuration().
//				configure("hibernate.cfg.xml").
//				addAnnotatedClass(Buyer.class).
//				buildSessionFactory();
//
//		//create a Session for Insertion into database, and read data
//		Session session = sessionFactory.getCurrentSession();
//		
//	    if ( sessionFactory == null ) {
//
//	        // exception handling omitted for brevity
//
//	        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//	                .configure("hibernate_test.cfg.xml")
//	                .build();
//
//	        sessionFactory = new Configuration().buildSessionFactory( serviceRegistry );
//	    }
//	    return sessionFactory;
//	}
	
	
	
}
}

