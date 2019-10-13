package cs333.project_2.DAL.Buyer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import cs333.project_2.DOM.Buyer.Buyer;

public class BuyerDAL {
	
	public static void main(String[] args) {
		
		//create a Session Factory
		SessionFactory sessionFactory = new AnnotationConfiguration().
		addAnnotatedClass(Buyer.class).
		configure("hibernate.cfg.xml").
		buildSessionFactory();
		
		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try{
			
			System.out.println("Creating a new Buyer object...");
			
			//create the Buyer object
			Buyer buyer = new Buyer("rayyanshaji", "SooperSecurePassword", 1239);
			
			
			//starting a transaction
			session.beginTransaction();
			
			//Saving the Buyer object to the database
			session.save(buyer);
			
			System.out.println("Buyer created in Database!");
			//commit the transaction
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Read the buyer
			System.out.println("Getting the buyer based on id: " + buyer.getID());
			Buyer readBuyer = (Buyer)session.get(Buyer.class, buyer.getID());   //specify PRIMARY KEY of the buyer

			System.out.println("Retrieved buyer details : " + buyer);
			
			//Commit the transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
		sessionFactory = new AnnotationConfiguration().
		addAnnotatedClass(Buyer.class).
		configure("hibernate.cfg.xml").
		buildSessionFactory();
		
		// delete a row in the database
		try{
			int ID = 1239;
			//Deleting a single Buyer
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieving Buyer with id : " + ID);
			
			Buyer readBuyer = (Buyer)session.get(Buyer.class, ID);   //specify PRIMARY KEY of the Buyer
			System.out.println("Deleting Buyer...");
			
			session.delete(readBuyer);
			
			/*
			 *		//delete Buyer id=3001
			 *		System.out.println("Deleting Buyer where id=3001");
			 *		session.createQuery("delete from Buyer where id=3001").executeUpdate();
			 */
			
			//commit the transaction
			session.getTransaction().commit();
			
		} finally {
			//session.flush();
			session.close();
			sessionFactory.close();
			//Closing the session.
		}
	}
}
