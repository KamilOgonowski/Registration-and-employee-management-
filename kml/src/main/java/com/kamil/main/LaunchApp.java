package com.kamil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kamil.entity.Student2;
import com.kamil.utili.HibernateUtil;

public class LaunchApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();	
			if(session!=null) 
				transaction = session.beginTransaction();
			if(transaction!=null) {
				Student2 st = new Student2();
				
				st.setId(25);
				st.setName("Raul");
				st.setAge(34);
				st.setAddress("Cracow");
				
				session.save(st);
				flag=true;
			}
			
			
		}catch(HibernateException e ) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Data is saved to DB");
			}else {
				transaction.rollback(); // All or nothing
				System.out.println("Not able to store the data in DB");
				
			}
				
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
			}
		}
		
		

	}


