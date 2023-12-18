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
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
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
			}else {
				transaction.rollback();
		
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
