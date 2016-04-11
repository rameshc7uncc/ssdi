package com.infinityCableService.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.dao.UserDao;
import com.infinityCableService.dbUtilTest.HibernateUtilTest;
import com.infinityCableService.model.User;

@SuppressWarnings("unused")
public class UserDaoTest {
	
	UserDao userDao ;

	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}*/

	@Before
	public void setUp() throws Exception {
		userDao = new UserDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateUser() {
		clearUserTable();
		
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Long userId = null;
		User newuser  = null;
		
		try {
			 userId = UserDao.createUser("Jennifer", "Cooper", "jenny@yahoo.com", 1234567890,
					"567 Some Lane", "NO 345", "Charlotte", "NC", 34567, "plmokn", "Customer", "A", "2003-06-12 00:09:45");
			
			 newuser =(User)session.get(User.class,userId);
			 assertNotNull(newuser);
			 assertEquals("Jennifer", newuser.getFirstName());
			 assertEquals("jenny@yahoo.com", newuser.getEmailAddress());
			 assertEquals(34567, newuser.getPinCode());
			 //assertEquals("2003-06-12 00:09:45", newuser.getUserCreateDate());
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Test
	public final void testGetUserBasedOnEmailAndPswd() {
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		User user  = null;
		try {
			 user = UserDao.getUserBasedOnEmailAndPswd("jenny@yahoo.com", "plmokn");
			 assertNotNull(user);
			 assertEquals("Jennifer", user.getFirstName());
			 assertEquals(34567, user.getPinCode());
			 //assertEquals("2003-06-12 00:09:45", newuser.getUserCreateDate());
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Test
	public final void testVerifyUserBasedOnEmail() {
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		User user  = null;
		try {
			 user = UserDao.verifyUserBasedOnEmail("jenny@yahoo.com");
			 assertNotNull(user);
			 assertEquals("Jennifer", user.getFirstName());
			 assertEquals("A", user.getStatus());
			 assertEquals(34567, user.getPinCode());
			 //assertEquals("2003-06-12 00:09:45", newuser.getUserCreateDate());
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	@Test
	public final void testResetPaswd() {
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowAffected = 0;
		try {
			 rowAffected = UserDao.resetPaswd("1234_abcde", "jenny@yahoo.com");
			 assertEquals(1, rowAffected);
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
	}
	@Test
	public final void testUpdateUser(){
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowAffected = 0;
		User userToUpdat;
		User currUser;
		try {
			userToUpdat = UserDao.getUserBasedOnEmailAndPswd("jenny@yahoo.com", "1234_abcde");
			userToUpdat.setPassword("Pa$$w@rd");
			userToUpdat.setAddress1("123 Some new Drive");
			 rowAffected = UserDao.updateUser(userToUpdat);
			 currUser =UserDao.getUserBasedOnEmailAndPswd("jenny@yahoo.com", "Pa$$w@rd");
			 assertEquals("Pa$$w@rd", currUser.getPassword());
			 assertEquals("123 Some new Drive", currUser.getAddress1());
			 //assertEquals(1, rowAffected);
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void clearUserTable(){
		SessionFactory sessionFactory = HibernateUtilTest.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int rowId;

		try {
			String hql = "Delete from User";
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
