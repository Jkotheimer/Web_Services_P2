package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.General.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddressDAL {
	public static void main(String[] args) {
		
		//create a Session Factory
		SessionFactory sessionFactory = new Configuration().
		configure("hibernate.cfg.xml").
		addAnnotatedClass(Address.class).
		buildSessionFactory();
		
		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try {
			
			System.out.println("Creating a new Address object...");
			
			//create the Address object
			Address address = new Address("321 Second St", "Seattle", "WA", 55555, 2319, 8204);
			
			//start a transaction
			session.beginTransaction();
			
			//Save the Address object to the database
			session.save(address);
			
			System.out.println("Address created in Database!");
			//commit the transaction
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Read the address
			System.out.println("Getting the address based on id: " + address.getID());
			
			Address readAddress = session.get(Address.class, address.getID());   //specify PRIMARY KEY of the address
			
			System.out.println("Retrieved PaymentInfo details : " + readAddress);
			
			//commit the transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
		// delete a row in the database
		try {
			int ID = 1;
			//Deleting a single PaymentInfo
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieving PaymentInfo with id : " + ID);
			
			Address readAddress = session.get(Address.class, ID);   //specify PRIMARY KEY of the PaymentInfo
			System.out.println("Deleting PaymentInfo...");
			
			session.delete(readAddress);
			
			/*
			 *		//delete PaymentInfo id=3001
			 *		System.out.println("Deleting PaymentInfo where id=3001");
			 *		session.createQuery("delete from PaymentInfo where id=3001").executeUpdate();
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
