package com.kamil.model.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kamil.model.RegisterUserModel;
import com.kamil.util.HibernateUtil;

public class RegisterDAO {
	
	Session session = null;
	Transaction transaction = null;
	boolean flag = false;
	
	
	public void registerUser(RegisterUserModel admin) {
		System.out.println("Czy cos sie tu dzieje wogole REGHISTER DAO.java");
		try {
			session = HibernateUtil.getSession();
			System.out.println((session==null)?"Session == null123":"Session different than null123");
			if(session!=null) {
				System.out.println("[chcek in RegisterDAO] -> session has been created");
				
				transaction = session.beginTransaction();
			if(transaction!=null) {
				
				session.save(admin);
				flag=true;
			}
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("[chcek in RegisterDAO] -> transaction has been commited - new entry in DB should be avaiaible");
			}else {
				System.out.println("[chcek in RegisterDAO] -> transaction has not been commited -probably is equal to null");
				System.out.println((session==null)?"session == null!!":"Session not null");
				transaction.rollback();
		
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
