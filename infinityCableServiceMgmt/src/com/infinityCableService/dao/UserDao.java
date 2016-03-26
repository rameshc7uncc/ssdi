package com.infinityCableService.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.User;

public class UserDao {
	public static void main(String[] arg) {

	}
	//method for inserting a user record in User table
	public static Long createUser(String firstName, String lastName, String emailId, long phoneNumber, String address1,
			String address2, String city, String state, int pinCode, String password, String roleId, String status,
			String userCreateDate) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Long userId = null;
		try {
			transaction = session.beginTransaction();
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailAddress(emailId);
			user.setPhoneNumber(phoneNumber);
			user.setAddress1(address1);
			user.setAddress2(address2);
			user.setPinCode(pinCode);
			user.setCity(city);
			user.setState(state);
			user.setUserCreateDate(userCreateDate);
			user.setPassword(password);
			user.setRoleId(roleId);
			user.setStatus(status);
			System.out.println("User object is set");
			session.save(user);
			userId = (Long) session.save(user);
			System.out.println("User saved in DB");

			transaction.commit();

			System.out.println("User insert is committed");
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return userId;
	}

	//method for login validation of user using email address and password.
	public static User getUserBasedOnEmailAndPswd(String emailAddress, String password) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		User user = new User();

		try {
			transaction = session.beginTransaction();
			String hql = " FROM User u WHERE u.emailAddress = :emailId AND u.password = :pswrd";
			Query query = session.createQuery(hql);
			query.setParameter("emailId", emailAddress);
			query.setParameter("pswrd", password);
			List<User> resultList = query.list();

			if (resultList.isEmpty()) {
				System.out.println("There is no User registered with email address = " + emailAddress);
				user = null;
			} else {
				System.out.println("User exists for emailAddress: " + emailAddress + " First Name: " + user.getFirstName());
				user = resultList.get(0);
				System.out.println(user);	
			}
			
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}
	
	public static User verifyUserBasedOnEmail(String emailAddress){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		User user = new User();

		try {
			System.out.println("inside dao");
			transaction = session.beginTransaction();
			String hql = " FROM User u WHERE u.emailAddress = :emailId";
			Query query = session.createQuery(hql);
			query.setParameter("emailId", emailAddress);
			List<User> resultList = query.list();

			if (resultList.isEmpty()) {
				System.out.println("There is no User registered with email address = " + emailAddress);
				user = null;
			} else {
				System.out.println("User exisits for emailAddress: " + emailAddress + " First Name: " + user.getFirstName());
				user = resultList.get(0);
			}
			System.out.println(user);
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return user;

	}
}
