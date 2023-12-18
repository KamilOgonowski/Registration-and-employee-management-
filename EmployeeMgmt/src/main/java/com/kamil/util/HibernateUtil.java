package com.kamil.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session= null;

	static {

		Configuration config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
		System.out.println("SessionFactory zostalo utworzone");
//		
//		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		System.out.println("Pokaz czy jest sesje w getSession: " + session);
		if (session==null ||!session.isOpen()) {
			session = sessionFactory.openSession(); /*To avoid two Session objects opened at once -> issue with double/miltiple cache*/
			System.out.println("[chcek in HibernateUtil] -> Session has been opened!");
		}
		System.out.println(session==null);
		System.out.println("Nie ma sesji: "+ session);
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
			System.out.println("[chcek in HibernateUtil] -> Session has been closed");
		}
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
			System.out.println("[chcek in HibernateUtil] -> SessionFactory obj has been closed");
			
		}
	}
	

	
}
