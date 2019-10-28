package cs333.project_2.DAL.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import cs333.project_2.DOM.Buyer.Buyer;
import cs333.project_2.DOM.Order.Order;
import cs333.project_2.DOM.Order.Order;

public class OrderDAL {
	

	public static void main(String[] args) {
		insert(888,176);
		//read(28);
	}
	public static void insert(int ID, int prod) {

		 SessionFactory sessionFactory = new AnnotationConfiguration().
				addAnnotatedClass(Order.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		Buyer buyer = new Buyer();
//		buyer.setbuyerID(103);
//		buyer.setUsername("Wayyanshaji");
//		buyer.setAddress("47 xyz st");
			System.out.println("Creating a new Order object...");
			//create the Order object
			//Creating Order Object as soon as Order buys a product. Something like an order receipt
			Order order = new Order();
			
			order.setOrderID(ID);
			order.setOrderedProductIDs(prod);
			
			order.setBuyer(buyer);
			
			buyer.getOrderIDs().add(order);

			session.beginTransaction();

			session.save(order);
			//session.save(buyer);
			System.out.println("Order created in Database!");
			
			session.getTransaction().commit();
		}


			public static Order read(int ID) {

				Order order = new Order();
				SessionFactory sessionFactory = new AnnotationConfiguration().
						addAnnotatedClass(Order.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();

				Session session = sessionFactory.getCurrentSession();

				session.beginTransaction();


				//Read the Order
				System.out.println("Getting the Order based on id: ");

				order = (Order)session.get(Order.class,ID);

				session.getTransaction().commit();

				System.out.println("ORDER ID : "+order.getOrderID() +"\n ORDERED PRODUCT ID "+order.getOrderedProductIDs()
				+"\n CUSTOMER ID " +order.getBuyer().getBuyerID() +"\n CUSTOMER USERNAME : " +order.getBuyer().getUsername());

				return order;
			}

			public static void update(int serialID,int newOrderID, int producID) {
				//SerialID is the primary key here which you enter as a parameter for the row you wish to change

				Order order = new Order();
				SessionFactory sessionFactory = new AnnotationConfiguration().
						addAnnotatedClass(Order.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();

				Session session = sessionFactory.getCurrentSession();

				session.beginTransaction();

				order = (Order)session.get(Order.class,serialID);

				order.setOrderID(newOrderID);
				order.setOrderedProductIDs(producID);
				
				session.saveOrUpdate(order);

				session.getTransaction().commit();
			}


			public static void deleteOrder(int ID) {
				SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Order.class).
						configure("hibernate.cfg.xml").
						buildSessionFactory();


					Session session = sessionFactory.getCurrentSession();
					session.beginTransaction();

					System.out.println("DELETING Order with id : " + ID);

					Order deleteOrder = (Order)session.get(Order.class, ID);   //specify PRIMARY KEY of the Product

					session.delete(deleteOrder);

					session.getTransaction().commit();

				}
}

		
