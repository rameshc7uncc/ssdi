package com.infinityCableService.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.dao.UserFeedbackDao;
import com.infinityCableService.dbUtilTest.HibernateUtilTest;
import com.infinityCableService.model.UserFeedback;

public class UserFeedbackDaoTest {
	UserFeedbackDao ufdao ;
	@Before
	public void setUp() throws Exception {
		ufdao = new UserFeedbackDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateFeedback() {
clearUserTable();
		
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Long userId = (long) 1234;
		String queryType="feedback";
		String queryStatus="Open";
		String start_Date="2003-06-12 00:09:45";
		String end_Date="NULL";
		UserFeedback uf;
		try {
			ufdao.createFeedback(userId, queryType, queryStatus, start_Date, end_Date);
			uf=(UserFeedback)session.get(UserFeedback.class, 1);
			selcttable();
			 
		}catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		//fail("Not yet implemented");
	}
		public void clearUserTable(){
			SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			int rowId;

			try {
				String hql = "Delete from customer_feedback";
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
		public void selcttable()
		{
			SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			int rowId;
			UserFeedback usrfbObj ;
			try {
				String hql = "from UserFeedback";
				Query query = session.createQuery(hql);
				List<UserFeedback> resultList = query.list();
				if (resultList.isEmpty()) {
					assertNotNull("NULL");
				}
				else
				{
					usrfbObj = resultList.get(0);
					assertEquals("feedback", usrfbObj.getQ_type());
					 assertEquals("Open", usrfbObj.getQ_status());
					 assertEquals(1234, usrfbObj.getU_Id());
				}
					
				
			
		
		}catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
		}
}
