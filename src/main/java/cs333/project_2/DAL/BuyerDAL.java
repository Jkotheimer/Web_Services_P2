package cs333.project_2.DAL;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cs333.project_2.Profile.Address;
import cs333.project_2.Profile.Buyer;

public class BuyerDAL {
	public static void main(String[] args) {
		
		//create a Session Factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Buyer.class).
				buildSessionFactory();
		
		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try{
			
			System.out.println("Creating a new Buyer object...");
			
			//create the Buyer object
			Buyer buyer = new Buyer("rayyanshaji", "loyola", 1239, new Address("123CampbellAve", "Chicago", "IL", 60645));
			
			//start a transaction
			session.beginTransaction();
			
			//Save the Buyer object to the database
			session.save(buyer);
			
			System.out.println("Buyer created in Database!");
			//commit the transaction
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Read the student
			System.out.println("Getting the buyer based on id: " + buyer.getID());
			
			Buyer readBuyer = session.get(Buyer.class, buyer.getID());   //specify PRIMARY KEY of the student
			
			System.out.println("Retrieved buyer details : " + buyer);
			
			//commit the transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
		
		// delete a row in the database
		try{
			int ID = 1;
			//Deleting a single Buyer
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieving Buyer with id : " + ID);
			
			Buyer readBuyer = session.get(Buyer.class, ID);   //specify PRIMARY KEY of the Buyer
			System.out.println("Deleting Buyer...");
			
			session.delete(readBuyer);
			
			/*
			//delete Buyer id=3001
			System.out.println("Deleting Buyer where id=3001");
			session.createQuery("delete from Buyer where id=3001").executeUpdate();
			*/
			
			//commit the transaction
			session.getTransaction().commit();	
			
		}finally{
			session.flush();
			session.close();
			sessionFactory.close();
			
		}
	}

}

