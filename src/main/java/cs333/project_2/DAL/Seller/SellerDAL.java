package cs333.project_2.DAL.Seller;
import cs333.project_2.DOM.Seller.Seller;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.Product.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import cs333.project_2.DOM.Seller.Seller;

public class SellerDAL {
	public static void main(String[] args) {
		insert(224,"abccrop","atz.com","sherman oak");
	}

		//create a Session Factory
	public static void insert(int Id, String username, String url, String address) {

		 SessionFactory sessionFactory = new AnnotationConfiguration().
				addAnnotatedClass(Seller.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();

			System.out.println("Creating a new Seller object...");

			//create the Seller object
			session.beginTransaction();
			Seller seller = new Seller();
			//seller.setSerialId(0);
			seller.setSellerID(Id);
			seller.setUsername(username);
			seller.seturlAddress(url);
			seller.setAddress(address);
			
			
			//Creating Order Object as soon as Seller buys a product. Something like an order receipt
//			Order order = new Order();
//			order.setSerialID(101);
//
//			order.setOrderID(425);
//			order.setOrderedProductIDs(1182);
//			order.setSeller(seller);
//
//			seller.getOrderIDs().add(order);
			Product product = new Product();
			//product.setserialID(0);
			product.setproductID(222);
			product.setItemDescrip("iphone");
			
			product.setRating(4.33f);
			product.setPrice(1222);
			product.setSeller(seller);
			
			seller.getProducts().add(product);

			
			session.beginTransaction();
			session.save(seller);

			session.save(product);

			System.out.println("Seller created in Database!");
			//commit the transaction
			session.getTransaction().commit();
		}


			public static Seller read(int ID) {

				Seller seller = new Seller();
				SessionFactory sessionFactory = new AnnotationConfiguration().
						addAnnotatedClass(Seller.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();

				Session session = sessionFactory.getCurrentSession();

				session.beginTransaction();


				//Read the seller
				System.out.println("Getting the seller based on id: ");

				seller = (Seller)session.get(Seller.class,ID);

				session.getTransaction().commit();

				System.out.println("PARTNER USERNAME: "+seller.getUsername() +"\n PARTNER ADDRESS "+seller.getaddress()+
						"\n PARTNER ID " +seller.getsellerID());
				
				return seller;

			}

			public static void update(int serialID,int newSellerID, String newusername, String newurl, String newaddress) {
				//SerialID is the primary key here which you enter as a parameter for the row you wish to change

				Seller seller = new Seller();
				SessionFactory sessionFactory = new AnnotationConfiguration().
						addAnnotatedClass(Seller.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();

				Session session = sessionFactory.getCurrentSession();

				session.beginTransaction();

				seller = (Seller)session.get(Seller.class,serialID);
				
					
				seller.setUsername(newusername);
				seller.setSellerID(newSellerID);
				seller.seturlAddress(newurl);
				seller.setAddress(newaddress);

				session.saveOrUpdate(seller);

				session.getTransaction().commit();
			}


			public static void deleteSeller(int ID) {
				SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Seller.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();


					Session session = sessionFactory.getCurrentSession();
					session.beginTransaction();

					System.out.println("DELETING BUYER with id : " + ID);

					Seller deleteSeller = (Seller)session.get(Seller.class, ID);   //specify PRIMARY KEY of the Product

					session.delete(deleteSeller);

					session.getTransaction().commit();

				}
			
//			public static Seller retrieve(int ID) {
//
//				Seller seller = new Seller();
//				SessionFactory sessionFactory = new AnnotationConfiguration().
//						addAnnotatedClass(Seller.class).
//						configure("hibernate.cfg.xml").
//						buildSessionFactory();
//
//				Session session = sessionFactory.getCurrentSession();
//
//				session.beginTransaction();
//
//
//				//Read the seller
//				System.out.println("Getting the seller based on id: ");
//
//				seller = (Seller)session.get(Seller.class,ID);
//				
//				int retrievedID = seller.getSellerID();
//				String retrievedusername = seller.getUsername();
//				
//
//				session.getTransaction().commit();
//				
//				return seller;
//
//			}

}

	



