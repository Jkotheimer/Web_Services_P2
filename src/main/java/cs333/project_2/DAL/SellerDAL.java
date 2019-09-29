package cs333.project_2.DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cs333.project_2.Profile.Address;
import cs333.project_2.Profile.Seller;

public class SellerDAL {
public static void main(String[] args) {
		
		//create a Session Factory
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Seller.class).
				buildSessionFactory();
		
		
		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try{
			
			System.out.println("Creating a new Seller object...");
			
			//create the Seller object
			Seller seller = new Seller("rayyanshaji", "loyola",2349, new Address("123CampbellAve","Chicago","IL", 60645),"loyola.com", (float) 3.85);
			
			//start a transaction
			session.beginTransaction();
			
			//Save the Seller object to the database
			session.save(seller);
			
			System.out.println("Seller created in Database!");
			//commit the transaction
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Read the student
			System.out.println("Getting the Seller based on id: " + seller.getID());
			
			Seller readSeller = session.get(Seller.class, seller.getID());   //specify PRIMARY KEY of the student
			
			System.out.println("Retrieved Seller details : " + seller);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			
			sessionFactory.close();
		}
		
		
		// delete a row in the database
		try{
			int ID = 1;
			//Deleting a single Seller
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieving Seller with id : " + ID);
			
			Seller readSeller = session.get(Seller.class, ID);   //specify PRIMARY KEY of the Seller
			System.out.println("Deleting Seller...");
			
			session.delete(readSeller);
			
			/*
			//delete Seller id=3001
			System.out.println("Deleting Seller where id=3001");
			session.createQuery("delete from Seller where id=3001").executeUpdate();
			*/
			
			//commit the transaction
			session.getTransaction().commit();	
			
		}finally{
			//session.flush();
			session.close();
			sessionFactory.close();
		}
	}

}


