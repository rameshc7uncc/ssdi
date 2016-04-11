package com.infinityCableService.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.UserFeedback;

public class UserFeedbackDao {
	public static void createFeedback(long userid, String queryType, String queryStatus, String start_Date,String end_Date){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			UserFeedback feedback =new UserFeedback();
			feedback.setU_Id(userid);
			feedback.setQ_type(queryType);
			feedback.setQ_status(queryStatus);
			feedback.setStart_Date(start_Date);
			//feedback.setEnd_Date(end_Date);
			session.saveOrUpdate(feedback);
			System.out.println("Feedback saved in DB");
			transaction.commit();

			System.out.println("Feedback insert is committed");
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
			
		}
	
	}

