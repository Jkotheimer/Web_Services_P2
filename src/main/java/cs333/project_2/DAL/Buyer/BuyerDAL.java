package cs333.project_2.DAL.Buyer;

import cs333.project_2.DOM.Order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cs333.project_2.DOM.Buyer.Buyer;

public class BuyerDAL {
	
	public static void main(String[] args) {
				//insert();
				read(2);
				update(2,202,"mshaji","45 N Campbell Ave");
				deleteCustomer(5);
	}
//
		public static void insert(int ID, String username, String address) {
		
		 SessionFactory sessionFactory = new AnnotationConfiguration().
				addAnnotatedClass(Buyer.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
					
			System.out.println("Creating a new Buyer object...");
			
			//create the Buyer object
				
			Buyer buyer = new Buyer();
			buyer.setSerialId(1);
			buyer.setbuyerID(101);
			buyer.setUsername("rayyanshaji");
			buyer.setAddress("43 xyz st");	
					
			//Creating Order Object as soon as Buyer buys a product. Something like an order receipt
//			Order order = new Order();
//			order.setSerialID(101);
//		
//			order.setOrderID(425);
//			order.setOrderedProductIDs(1182);
//			order.setBuyer(buyer);
//			
//			buyer.getOrderIDs().add(order);

			session.beginTransaction();
	
			session.save(buyer);

			//session.save(order);
		
			System.out.println("Buyer created in Database!");
			//commit the transaction
			session.getTransaction().commit();
		}
						

			public static void read(int ID) {
				
				Buyer buyer = new Buyer();
				SessionFactory sessionFactory = new AnnotationConfiguration().
						addAnnotatedClass(Buyer.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();

				Session session = sessionFactory.getCurrentSession();

				session.beginTransaction();
							
			
				//Read the buyer
				System.out.println("Getting the buyer based on id: ");
				
				buyer = (Buyer)session.get(Buyer.class,ID); 
				
				session.getTransaction().commit();
				
				System.out.println(" CUSTOMER USERNAME: "+buyer.getUsername() +"\n CUSTOMER ADDRESS "+buyer.getAddress()+
						"\n CUSTOMER ID " +buyer.getBuyerID());
					
			}
			
			public static void update(int serialID,int newBuyerID, String newusername, String newaddress) {
				//SerialID is the primary key here which you enter as a parameter for the row you wish to change
				
				Buyer buyer = new Buyer();
				SessionFactory sessionFactory = new AnnotationConfiguration().
						addAnnotatedClass(Buyer.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();

				Session session = sessionFactory.getCurrentSession();
			
				session.beginTransaction();
				
				buyer = (Buyer)session.get(Buyer.class,serialID); 
				
				buyer.setUsername(newusername);
				buyer.setbuyerID(newBuyerID);
				buyer.setAddress(newaddress);
				
				session.saveOrUpdate(buyer);
				
				session.getTransaction().commit();
			}
			
			public static void deleteCustomer(int ID) {
				SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Buyer.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();
						
					
					Session session = sessionFactory.getCurrentSession();
					session.beginTransaction();

					System.out.println("DELETING BUYER with id : " + ID);

					Buyer deleteBuyer = (Buyer)session.get(Buyer.class, ID);   //specify PRIMARY KEY of the Product
					
					session.delete(deleteBuyer);
					
					session.getTransaction().commit();	

				}
			
}
			

		
	

	

