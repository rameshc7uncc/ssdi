package com.infinityCableService.dao;

import java.sql.Timestamp;
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

public class PackagesDao {
	
	//insert a new package into package table
	public static int createNewPckg(String pckgName, double pckgPrice, String pckgDesc){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		java.util.Date date = new java.util.Date();
		String pckgCreateDate = new Timestamp(date.getTime()).toString();
		
		int pckgId = 0;
		
		try{
			
			transaction = session.beginTransaction();
			Packages newPckg = new Packages();
			newPckg.setp_Name(pckgName);
			newPckg.setp_Price(pckgPrice);
			newPckg.setp_Description(pckgDesc);
			newPckg.setp_Status("ACTIVE");
			newPckg.setp_CreatedDate(pckgCreateDate);
			newPckg.setp_DeletedDate(null);
			session.saveOrUpdate(newPckg);
			session.flush();
			pckgId = (int) newPckg.getp_Id();
			//pckgId = session.save(newPckg);
			System.out.println("Package saved in DB");	
			
			transaction.commit();
		
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return pckgId;

		}

	public static List<String> getPckgNames(){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		List<String> pckgNames = new ArrayList<String>();

		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("SELECT p.p_Name FROM Packages p");
			pckgNames = query.list();

			if (pckgNames.isEmpty()) {
				System.out.println("No Packages retrieved from Package table.");
				pckgNames = null;
			} else {
				for (String n : pckgNames) {

					System.out.println(n);
				}
				System.out.println("No.of Package retrieved from DB:  " + pckgNames.size());
			}
		} catch (HibernateException exception) {
			if (transaction != null)
				transaction.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}

		return pckgNames;
	}

		public static int getPid(String pckgName){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			int pid = 0;
			try {
				transaction = session.beginTransaction();
				System.out.println("pckgName");
				System.out.println(pckgName);
				String hql = " SELECT p.p_Id FROM Packages p WHERE p.p_Name = :pkgName";
				Query query = session.createQuery(hql);
				query.setParameter("pkgName", pckgName);
				List<Integer> resultList = query.list();
				if (resultList.isEmpty()) {
					System.out.println("No package id exists for the package name: " + pckgName);
				} else {
					pid = resultList.get(0);
					System.out.println("Package ID : " +pid);
				}

			} catch (HibernateException exception) {
				if (transaction != null)
					transaction.rollback();
				exception.printStackTrace();
			} finally {
				session.close();
			}
			return pid;

		}
		
		public static int deletePid(int p_id){
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			int del=0;
			try{
				transaction = session.beginTransaction();
				Query query = session.createQuery("delete Packages where p_id = :pid");
				query.setParameter("pid", p_id);
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
		
		public static Packages getPkgDetails(String pckgName){
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;

			Packages pckg = new Packages();
			
			try {
				transaction = session.beginTransaction();
				Query query = session.createQuery("FROM Packages p WHERE p.p_Name = :pkgName ");
				query.setParameter("pkgName", pckgName);
				List<Packages> pckgObjList = query.list();

				if (pckgObjList.isEmpty()) {
					System.out.println("No Packages retrieved from Package table.");
					pckg = null;
				} else {
					pckg = pckgObjList.get(0);
				}
			} catch (HibernateException exception) {
				if (transaction != null)
					transaction.rollback();
				exception.printStackTrace();
			} finally {
				session.close();
			}

			return pckg;
		}

		public static List<String> getAllPckgNames(String excludePkgName){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;

			List<String> pckgNamesList = new ArrayList<String>();
			
			try {
				transaction = session.beginTransaction();
				Query query = session.createQuery("SELECT p.p_Name FROM Packages p WHERE p.p_Name NOT IN (:pkgName) ");
				query.setParameter("pkgName", excludePkgName);
				pckgNamesList = query.list();

				if (pckgNamesList.isEmpty()) {
					System.out.println("No Packages retrieved from Package table.");
					pckgNamesList = null;
				} else {
					System.out.println("Packages Names other than " +excludePkgName);
				}
			} catch (HibernateException exception) {
				if (transaction != null)
					transaction.rollback();
				exception.printStackTrace();
			} finally {
				session.close();
			}

			return pckgNamesList;

		}
		public static List<Packages> getAllPcgks(){

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = null;
            
            List<Packages> pcksList = new ArrayList<>();
            try {
                transaction = session.beginTransaction();
                Query query = session.createQuery("FROM Packages p ");
                 pcksList = query.list();

                if (pcksList.isEmpty()) {
                    System.out.println("No Packages retrieved from Package table.");
                    pcksList = null;
                } else {
                    System.out.println(pcksList.size());
                    
                }
            } catch (HibernateException exception) {
                if (transaction != null)
                    transaction.rollback();
                exception.printStackTrace();
            } finally {
                session.close();
            }

            return pcksList;

                
            
        }

		
		public static int updatePkgDetails(String curpkgNm,String pkNm, double pkprice, String pkDesc){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			//Packages upquery = new Packages();
			int rowUpdated = 0 ;
			
			try {
				transaction = session.beginTransaction();
				Query updatequery = session.createQuery("update Packages SET p_Name = :pkgNm, p_Price = :pkgprice, p_Description = :pkgDesc where p_Name = :curpkgNm" );
				updatequery.setParameter("pkgNm", pkNm);
				updatequery.setParameter("curpkgNm",curpkgNm);
				updatequery.setParameter("pkgprice", pkprice);
				updatequery.setParameter("pkgDesc", pkDesc);
				
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
		



