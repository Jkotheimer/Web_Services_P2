package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.Order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import cs333.project_2.DOM.Buyer.Buyer;

public class BuyerDAL {
	
	public static void main(String[] args) {

		
//
		
		 SessionFactory sessionFactory = new AnnotationConfiguration().
				addAnnotatedClass(Buyer.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
	
		
//		Configuration cfg = new Configuration();
//		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		

		
		

		
		//create a Session for Insertion into database, and read data
		
			System.out.println("Creating a new Buyer object...");
			
			//create the Buyer object
			
			Buyer buyer = new Buyer();
			buyer.setSerialId(1);
			buyer.setbuyerID(101);
			buyer.setUsername("rayyanshaji");
			buyer.setAddress("43 xyz st");	
			
			
			
			//Creating Order Object
			Order order = new Order();
			order.setSerialID(101);
			
			order.setOrderID(425);
			order.setOrderedProductIDs(1182);
			order.setBuyer(buyer);
			
			//Add buyer columns to order table
			buyer.getOrderIDs().add(order);
//			List<Order> orderlist = new ArrayList<Order>();
//			buyer.setOrderIDs(orderlist);
//			
//			orderlist.add(order);
								
			//System.out.println(buyer.getID());
			//System.out.println(orderlist.get(0).getBuyer().getID());
			//starting a transaction
			session.beginTransaction();
	
			session.save(buyer);

			session.save(order);
		
			System.out.println("Buyer created in Database!");
			//commit the transaction
			session.getTransaction().commit();
		
			session.close();
			

	
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

			
//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//			
//			//Read the buyer
//			System.out.println("Getting the buyer based on id: " + buyer.getBuyerID());
//			Buyer readBuyer = (Buyer)session.get(Buyer.class, buyer.getBuyerID());   //Since I changed the ID field name 
//			//to BuyerID, as ID is a reserved word in SQL and was causing many issues.
//
//			System.out.println("Retrieved buyer details : " + buyer);
//			
//			//Commit the transaction
//			session.getTransaction().commit();
			
		
		
		
		// Delete a row in the database
//		try{
//			int ID = 111;
//			//Putting an existing ID in my database. Your database might have a different value.
//			//Deleting a single Buyer
//			//Get a new session and begin transaction
//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//			
//			System.out.println("Retrieving Buyer with id : " + ID);
//			
//			Buyer read_Buyer = (Buyer)session.get(Buyer.class, buyer.getBuyerID());   //specify KEY of the Buyer
//			System.out.println("Deleting Buyer...");
//			
//			session.delete(read_Buyer); // avoiding duplicate name for read_buyer
//			
//			/*
//			 *		//delete Buyer id=3001
//			 *		System.out.println("Deleting Buyer where id=3001");
//			 *		session.createQuery("delete from Buyer where id=3001").executeUpdate();
//			 */
//			
//			//commit the transaction
//			session.getTransaction().commit();
//			
//		} finally {
//			//session.flush();
//			session.close();
//			sessionFactory.close();
//			//Closing the session.
//		}
		}
	}

	

