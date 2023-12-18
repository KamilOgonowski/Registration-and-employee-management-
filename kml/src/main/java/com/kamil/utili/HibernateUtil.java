package com.kamil.utili;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session=null;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println("Session factory has been build: " + sessionFactory);
	}
	
	public static Session getSession() {
		
		if(session==null) {  /* to avoid having two session objects -> then 2 cache would be available
		 						which we want to avoid*/
			session = sessionFactory.openSession();		
		}
		return session;	
		
	}
	
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	
	public static void closeSessionFactory() { /* no parameters as the user can work with multiple Session 
												objects, but only one SessionFactory object*/
		if(sessionFactory!=null)
			sessionFactory.close();
	}
	
	
	
	
	

}
