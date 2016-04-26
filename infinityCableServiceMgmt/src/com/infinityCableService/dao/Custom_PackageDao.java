package com.infinityCableService.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.Custom_Package;
import com.infinityCableService.model.Package_Channel;
import com.infinityCableService.model.Packages;

@SuppressWarnings("unused")
public class Custom_PackageDao {

	// insert p_id,c_id for new Package
	public static int createCustomPckgChnl(int user_Id,int p_Id, List<Integer> chanlIdsList) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int countOfInsertion = 0;
		
		try {
			transaction = session.beginTransaction();
			for (Integer chnlId : chanlIdsList) {
				Custom_Package customPckgChnl = new Custom_Package();
				customPckgChnl.setuser_Id(user_Id);
				customPckgChnl.setp_Id(p_Id);
				customPckgChnl.setc_Id(chnlId);
				session.saveOrUpdate(customPckgChnl);
				System.out.println("Package_Channel saved in DB. p_ID: "+p_Id+" c_Id: "+chnlId);
				countOfInsertion = countOfInsertion + 1;
			}
			transaction.commit();
			System.out.println("New Package_Channel insert is committed");
			System.out.println("Total No.Of Channels added to Package_Channel: " + countOfInsertion);
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return countOfInsertion;

	}	
		
}

