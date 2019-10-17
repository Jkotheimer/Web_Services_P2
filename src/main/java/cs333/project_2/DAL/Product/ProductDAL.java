package cs333.project_2.DAL.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import cs333.project_2.DOM.Product.Product;

public class ProductDAL {
	
	public static void createProduct(int ID, int sellerID, float price, String itemDescrip) {
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Product.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try {

			System.out.println("Creating a new Product object...");

			//create the Product object
			Product product = new Product(ID,sellerID,price,itemDescrip);

			//start a transaction
			session.beginTransaction();

			//Save the Product object to the database

			session.save(product);

			System.out.println("Product created in Database!");
			//commit the transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}
	
	public static Product readProduct(int ID) {
		Product readProduct;
		
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Product.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Product with id : " + ID);

			readProduct = (Product)session.get(Product.class, ID);   //specify PRIMARY KEY of the Product
			
			/*
			//delete Product id=3001
			System.out.println("Deleting Product where id=3001");
			session.createQuery("delete from Product where id=3001").executeUpdate();
			*/

			//commit the transaction
			session.getTransaction().commit();	

		} finally {
			//session.flush();
			sessionFactory.close();
		}
		
		return readProduct;

	}
	
	public static void updateProduct(int existingID, int sellerID, float price, String itemDescrip) {
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Product.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Product with id : " + existingID);

			Product updateProduct = (Product)session.get(Product.class, existingID);   //specify PRIMARY KEY of the Product
			updateProduct.setItemDescrip(itemDescrip);
			updateProduct.setPrice(price);
			updateProduct.setSellerID(sellerID);
			/*
			//delete Product id=3001
			System.out.println("Deleting Product where id=3001");
			session.createQuery("delete from Product where id=3001").executeUpdate();
			*/
			session.saveOrUpdate(updateProduct);
			//commit the transaction
			session.getTransaction().commit();	
			System.out.println("Sucessful Update");

		} finally {
			//session.flush();
			sessionFactory.close();
		}

	}
	
	public static void deleteProduct(int ID) {
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Product.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Product with id : " + ID);

			Product deleteProduct = (Product)session.get(Product.class, ID);   //specify PRIMARY KEY of the Product
			
			session.delete(deleteProduct);
			/*
			//delete Product id=3001
			System.out.println("Deleting Product where id=3001");
			session.createQuery("delete from Product where id=3001").executeUpdate();
			*/

			//commit the transaction
			session.getTransaction().commit();	

		} finally {
			//session.flush();
			sessionFactory.close();
		}

	}
	
	public static void main(String[] args) {
		int ID = 1236;
		ProductDAL.createProduct(ID, 5134, 450f, "iPhone");
		ProductDAL.updateProduct(ID, 5134, 890f, "iGone");
		System.out.println(ProductDAL.readProduct(ID).getPrice());
		ProductDAL.deleteProduct(ID);
		
	}
}

