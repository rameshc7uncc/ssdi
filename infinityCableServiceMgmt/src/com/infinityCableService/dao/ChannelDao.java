package com.infinityCableService.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.Channel;

public class ChannelDao {
	public static void main(String args[]) {
		List<String> channelList = new ArrayList<String>();
		channelList = getAllChannels();
	}

	// getting all channels from channel table
	public static List<String> getAllChannels() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		List<String> names = new ArrayList<String>();

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("SELECT c.c_Name FROM Channel c");
			names = query.list();

			if (names.isEmpty()) {
				System.out.println("No Channels retrieved from Channel table.");
				names = null;
			} else {
				for (String n : names) {
					System.out.println(n);
				}
				System.out.println("No.of Channels retrieved from DB:  " + names.size());
			}
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return names;

	}

	// get channel ids
	public static List<Integer> getChannelIds(String[] channelList) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		List<Integer> channelIdsList = new ArrayList<Integer>();

		try {
			transaction = session.beginTransaction();
			for (String chanelName : channelList) {
				String hql = " SELECT c.c_Id FROM Channel c WHERE c.c_Name = :chnlName";
				Query query = session.createQuery(hql);
				query.setParameter("chnlName", chanelName);
				List<Integer> resultList = query.list();

				if (resultList.isEmpty()) {
					System.out.println("No channel id exists for the channel name: " + chanelName);
					// channelList = null;
				} else {
					channelIdsList.add(resultList.get(0));
					System.out.println("Channel ID added to the list");
				}

			}
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("Size of ChanelId list: "+channelIdsList.size());
		return channelIdsList;

	}

}
