package com.infinityCableService.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.dao.Customer_SubscriptionDao;
import com.infinityCableService.dbUtilTest.HibernateUtilTest;
import com.infinityCableService.model.Customer_Subscription;

public class Customer_SubscriptionDaoTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateCusSubscription() {
		clearCustomerSubTable();
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowId;
		Customer_Subscription cusSub;

		try {
			rowId = Customer_SubscriptionDao.createCusSubscription(4, 2);
			cusSub = session.get(Customer_Subscription.class, rowId);
			assertEquals(4, cusSub.getUser_Id());
			assertEquals(2, cusSub.getP_Id());

		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Test
	public final void testGetCustomerSubscptnDetails() {
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowId;
		Customer_Subscription cusSub;

		try {
			cusSub = Customer_SubscriptionDao.getCustomerSubscptnDetails(4);
			assertNotNull(cusSub);
			assertEquals(4, cusSub.getUser_Id());
			assertEquals(2, cusSub.getP_Id());
			assertNotEquals(null, cusSub.getStart_Date());
			assertEquals(null, cusSub.getEnd_Date());

		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Test
	public final void testUnsubscribe() {

		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowId;
		Customer_Subscription cusSub;

		try {
			rowId = Customer_SubscriptionDao.unsubscribe(4, 2);
			cusSub = session.get(Customer_Subscription.class, rowId);
			assertNotNull(cusSub);
			assertEquals(4, cusSub.getUser_Id());
			assertEquals(2, cusSub.getP_Id());
			assertNotNull(cusSub.getEnd_Date());

		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public void clearCustomerSubTable(){
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowId;

		try {
			String hql = "Delete from Customer_Subscription";
			Query query = session.createQuery(hql);
			rowId = query.executeUpdate();
			System.out.println(rowId+ "rows deleted." );

		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
