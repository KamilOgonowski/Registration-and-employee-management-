package com.kamil.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session= null;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println("[chcek in HibernateUtil] -> Session factory has been build: " + sessionFactory );
	}
	
	public static Session getSession() {
		if (session!=null) {
			session = sessionFactory.openSession(); /*To avoid two Session objects opened at once -> issue with double/miltiple cache*/
			System.out.println("[chcek in HibernateUtil] -> Session has been opened");
		}
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
