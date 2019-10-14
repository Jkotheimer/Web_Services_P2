package cs333.project_2.DAL.Rating;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import cs333.project_2.DOM.Rating.Rating;

public class RatingDAL {
	
	public static void createRating(int ID, int rateval, String review) {
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Rating.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();

		//create a Session for Insertion into database, and read data
		Session session = sessionFactory.getCurrentSession();
		try {

			System.out.println("Creating a new Rating object...");

			//create the Rating object
			Rating rating = new Rating(ID,rateval,review);

			//start a transaction
			session.beginTransaction();

			//Save the Rating object to the database

			session.save(rating);

			System.out.println("Rating created in Database!");
			//commit the transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}
	
	public static Rating readRating(int ID) {
		Rating readRating;
		
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Rating.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Rating with id : " + ID);

			readRating = (Rating)session.get(Rating.class, ID);   //specify PRIMARY KEY of the Rating
			
			/*
			//delete Rating id=3001
			System.out.println("Deleting Rating where id=3001");
			session.createQuery("delete from Rating where id=3001").executeUpdate();
			*/

			//commit the transaction
			session.getTransaction().commit();	

		} finally {
			//session.flush();
			sessionFactory.close();
		}
		
		return readRating;

	}
	
	public static void updateRating(int existingID, int rateval, String review) {
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Rating.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Rating with id : " + existingID);

			Rating updateRating = (Rating)session.get(Rating.class, existingID);   //specify PRIMARY KEY of the Rating
			updateRating.setRateval(rateval);
			updateRating.setReview(review);
			/*
			//delete Rating id=3001
			System.out.println("Deleting Rating where id=3001");
			session.createQuery("delete from Rating where id=3001").executeUpdate();
			*/
			session.saveOrUpdate(updateRating);
			//commit the transaction
			session.getTransaction().commit();	
			System.out.println("Sucessful Update");

		} finally {
			//session.flush();
			sessionFactory.close();
		}

	}
	
	public static void deleteRating(int ID) {
		SessionFactory sessionFactory = new AnnotationConfiguration().addAnnotatedClass(Rating.class).
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Retrieving Rating with id : " + ID);

			Rating deleteRating = (Rating)session.get(Rating.class, ID);   //specify PRIMARY KEY of the Rating
			
			session.delete(deleteRating);
			/*
			//delete Rating id=3001
			System.out.println("Deleting Rating where id=3001");
			session.createQuery("delete from Rating where id=3001").executeUpdate();
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
		RatingDAL.createRating(ID, 5, "iPhones are great");
		RatingDAL.updateRating(ID, 4, "iPhones are pretty good");
		System.out.println(RatingDAL.readRating(ID).getReview());
		RatingDAL.deleteRating(ID);
		
	}
}