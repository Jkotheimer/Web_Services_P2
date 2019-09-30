package cs333.project_2.DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cs333.project_2.Profile.Address;
import cs333.project_2.Profile.Seller;
import cs333.project_2.Order.Product;

public class ProductDAL {
	public static void main(String[] args) {

		//create a Session Factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Product.class).
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try {

			System.out.println("Creating a new Product object...");

			//create the Product object
			Product product = new Product(1234, 5134, 450f, "iPhone");

			//start a transaction
			session.beginTransaction();

			//Save the Product object to the database

			session.save(product);

			System.out.println("Product created in Database!");
			//commit the transaction
			session.getTransaction().commit();

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			//Read the product
			System.out.println("Getting the Product based on id: " + product.getID());

			Product readProduct = session.get(Product.class, product.getID());   //specify PRIMARY KEY of the product

			System.out.println("Retrieved Product details : " + product);

			//commit the transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

		// delete a row in the database
		try {
			int ID = 1;
			//Deleting a single Product
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Product with id : " + ID);

			Product readProduct = session.get(Product.class, ID);   //specify PRIMARY KEY of the Product
			System.out.println("Deleting Product...");

			session.delete(readProduct);

			/*
			//delete Product id=3001
			System.out.println("Deleting Product where id=3001");
			session.createQuery("delete from Product where id=3001").executeUpdate();
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

