package com.infinityCableService.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinityCableService.dbUtil.HibernateUtil;
import com.infinityCableService.model.Package_Channel;
import com.infinityCableService.model.Packages;

public class Package_ChannelDao {

	// insert p_id,c_id for new Package
	public static int createPckgChnl(int pckgId, List<Integer> chanlIdsList) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int countOfInsertion = 0;
		try {
			transaction = session.beginTransaction();
			for (Integer chnlId : chanlIdsList) {
				Package_Channel newpckgChnl = new Package_Channel();
				newpckgChnl.setp_Id(pckgId);
				newpckgChnl.setc_Id(chnlId);
				session.save(newpckgChnl);
				System.out.println("Package_Channel saved in DB. p_ID: "+pckgId+" c_Id: "+chnlId);
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

	
	public static int deletePid(int pid){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Package_Channel pckChnobj = new Package_Channel();
		int del=0;
		try{
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete Package_Channel where p_Id = :pid");
			query.setParameter("pid", pid);
			del = query.executeUpdate();
			transaction.commit();
		}catch(HibernateException exception){
				if(transaction!=null)
					transaction.rollback();
				exception.printStackTrace();
		}finally{
				session.close();
		}
		return del;
			
		}
	

	//delete channel ids

		public static int deleteCid(List<Integer> cid,int pid ){
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			int del=0;
			try{
				transaction = session.beginTransaction();
				for (Integer chnlId : cid) {
					Query query = session.createQuery("delete from Package_Channel PC where PC.c_Id = :cid and PC.p_Id = :pid");
					query.setParameter("pid", pid);
					query.setParameter("cid", chnlId);
					del = query.executeUpdate();
					}
				
				transaction.commit();
			}catch(HibernateException exception){
					if(transaction!=null)
						transaction.rollback();
					exception.printStackTrace();
			}finally{
					session.close();
			}
			return del;
				
			}
	
	public static List<String> getPckgChanlList(int pid){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<String> pkgChnList = new ArrayList<String>();
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("SELECT c.c_Name From Channel c WHERE c.c_Id IN(SELECT pc.c_Id FROM Package_Channel pc where pc.p_Id = :pid)");
			query.setParameter("pid", pid);
			 pkgChnList = query.list();

			if (pkgChnList.isEmpty()) {
				System.out.println("No Packages retrieved from Package table.");
				pkgChnList = null;
			} else {
				System.out.println(pkgChnList.size());
			}
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return pkgChnList;


		
		
	}
	
		
}

