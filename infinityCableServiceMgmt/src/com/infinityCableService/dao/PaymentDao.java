package com.infinityCableService.dao;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.Customer_Subscription;
import com.infinityCableService.model.Payment;

public class PaymentDao {

	public static Payment getBillDetails(long user_Id) {

		Payment payDet = null;
		Customer_Subscription cusSubObj = new Customer_Subscription();

		cusSubObj = Customer_SubscriptionDao.getCustomerSubscptnDetails(user_Id);
		if (cusSubObj != null) {
			int pid = cusSubObj.getP_Id();
			String pckgName = PackagesDao.getPckgName(pid);
			payDet = getBill(user_Id);
			if (payDet == null) {

				insertPayment(user_Id, PackagesDao.getPrice(pckgName));
				payDet = getBill(user_Id);
			}
		} else {
			System.out.println("no subscription yet");
		}
		return payDet;

	}

	public static int updatePaymentDetails(long user_Id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowUpdated = 0;

		try {
			transaction = session.beginTransaction();
			Query updatequery = session.createQuery(
					"update Payment set payment_Status = 'Paid',payment_Date = now() where user_Id = :user_Id and payment_Status = 'unpaid'");
			updatequery.setParameter("user_Id", user_Id);
			rowUpdated = updatequery.executeUpdate();
			transaction.commit();
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return rowUpdated;
	}

	public static Payment getBill(long user_Id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		Payment paymntObj = new Payment();
		try {
			transaction = session.beginTransaction();
			String hql = "SELECT pa.billing_Date, pa.bill_Amount, pa.payment_Status FROM Payment pa WHERE user_Id = :user_Id";
			Query query = session.createQuery(hql);
			query.setParameter("user_Id", user_Id);
			List<Object> result = (List<Object>) query.list();
			Iterator itr = result.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				// now you have one array of Object for each row

				paymntObj.setbilling_Date(obj[0].toString());
				paymntObj.setbill_Amount((double) obj[1]);
				paymntObj.setpayment_Status((String) obj[2]);
				return paymntObj;
			}
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return paymntObj;

	}

	public static int insertPayment(long user_Id, double pckgP) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		String payment_Status = "paid";
		java.util.Date date = new java.util.Date();
		String payment_Date = new Timestamp(date.getTime()).toString();

		try {
			transaction = session.beginTransaction();

			Payment iBill = new Payment();
			iBill.setUser_Id(user_Id);
			iBill.setbilling_Date(payment_Date);
			iBill.setbill_Amount(pckgP);
			iBill.setpayment_Date(payment_Date);
			iBill.setpayment_Status(payment_Status);
			session.save(iBill);
			transaction.commit();

		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return 0;

	}

}
