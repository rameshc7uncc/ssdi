package com.infinityCableService.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.Customer_Subscription;
import com.infinityCableService.model.Packages;

public class Customer_SubscriptionDao {
	
	public static int createCusSubscription (long userid, int pid){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		java.util.Date date = new java.util.Date();
		String subscriptionStartDate = new Timestamp(date.getTime()).toString();
		
		int rowID = 0;
		
		try{
			
			transaction = session.beginTransaction();
			Customer_Subscription custSubObj = new Customer_Subscription();
			custSubObj.setUser_Id(userid);
			custSubObj.setP_Id(pid);
			custSubObj.setStart_Date(subscriptionStartDate);
			custSubObj.setEnd_Date(null);
			session.saveOrUpdate(custSubObj);
			session.flush();
			rowID = (int) custSubObj.getRow_Id();
			System.out.println("Customer Subscription saved in DB");	
			
			transaction.commit();
		
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return rowID;


		
	}
	
	public static Customer_Subscription getCustomerSubscptnDetails(long userId){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Customer_Subscription  custSubptnObj = new Customer_Subscription();
		
		try{
			 transaction = session.beginTransaction();
			 Query query = session.createQuery("FROM Customer_Subscription cs WHERE cs.user_Id = :userid AND cs.end_Date IS NULL ");
			 query.setParameter("userid", userId);
			 List<Customer_Subscription> pckgObjList = query.list();

				if (pckgObjList.isEmpty()) {
					System.out.println("Customer has not subscribed to any package.");
					custSubptnObj = null;
				} else {
					custSubptnObj = pckgObjList.get(0);
				}
			} catch (HibernateException exception) {
				if (transaction != null)
					transaction.rollback();
				exception.printStackTrace();
			} finally {
				session.close();
			}

			return custSubptnObj;
		 
		
	}
	
	public static int unsubscribe(long userid , int pckgid){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowUpdated = 0 ;
		java.util.Date date = new java.util.Date();
		String subscriptionEndDate = new Timestamp(date.getTime()).toString();
		
		try {
			transaction = session.beginTransaction();
			Query updatequery = session.createQuery("update Customer_Subscription SET end_Date = :endDate WHERE user_Id = :userid AND p_Id = :pid" );
			updatequery.setParameter("endDate", subscriptionEndDate);
			updatequery.setParameter("userid",userid);
			updatequery.setParameter("pid", pckgid);
			
			rowUpdated = updatequery.executeUpdate();
			transaction.commit();
		}catch(HibernateException exception){
				if(transaction!=null)
					transaction.rollback();
				exception.printStackTrace();
		} finally {
			session.close();
		}
		
		
		 return rowUpdated;
	}

}
