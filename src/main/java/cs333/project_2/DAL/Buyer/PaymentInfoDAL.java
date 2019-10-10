package cs333.project_2.DAL;
import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PaymentInfoDAL {
	public static void main(String[] args) {

		//create a Session Factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(PaymentInfo.class).
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try {

			System.out.println("Creating a new PaymentInfo object...");

			//create the PaymentInfo object
			PaymentInfo paymentInfo = new PaymentInfo("5463225300483912","MOHAMMED SHAJI","23APRIL2019",000,
													  new Address("321 Second St", "Seattle", "WA", 55555)
			);

			//start a transaction
			session.beginTransaction();

			//Save the PaymentInfo object to the database
			session.save(paymentInfo);

			System.out.println("PaymentInfo created in Database!");
			//commit the transaction
			session.getTransaction().commit();

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			//Read the paymentInfo
			System.out.println("Getting the PaymentInfo based on id: " + paymentInfo.getCreditCardNum());

			PaymentInfo readpaymentInfo = session.get(PaymentInfo.class, paymentInfo.getCreditCardNum());   //specify PRIMARY KEY of the paymentInfo

			System.out.println("Retrieved PaymentInfo details : " + paymentInfo);

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

			PaymentInfo readPaymentInfo = session.get(PaymentInfo.class, ID);   //specify PRIMARY KEY of the PaymentInfo
			System.out.println("Deleting PaymentInfo...");

			session.delete(readPaymentInfo);

			/*
			//delete PaymentInfo id=3001
			System.out.println("Deleting PaymentInfo where id=3001");
			session.createQuery("delete from PaymentInfo where id=3001").executeUpdate();
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
