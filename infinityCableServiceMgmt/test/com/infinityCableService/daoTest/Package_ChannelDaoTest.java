package com.infinityCableService.daoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.dao.ChannelDao;
import com.infinityCableService.dao.Package_ChannelDao;

public class Package_ChannelDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreatePckgChnl() {
		//Package_ChannelDao.createPckgChnl(pckgId, chanlIdsList);
		try {
			List<Integer> chanlIdsList = new ArrayList();
			chanlIdsList.add(30);
			chanlIdsList.add(32);
			chanlIdsList.add(39);
			chanlIdsList.add(26);
			chanlIdsList.add(27);
			 
			int rowsU= Package_ChannelDao.createPckgChnl(6, chanlIdsList);
			assertEquals(5, rowsU);
			
		}
		catch (HibernateException exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void testDeletePid() {
		try{
			
			int del= Package_ChannelDao.deletePid(6);
			assertEquals(5, del);
	}
		catch (HibernateException exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void testDeleteCid() {
		try{
			List<Integer> cid = new ArrayList();
			cid.add(5);
			int del= Package_ChannelDao.deleteCid(cid ,5);
			assertEquals(1, del);
	}
		catch (HibernateException exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void testGetPckgChanlList() {
		List<String> pkgChnList = Package_ChannelDao.getPckgChanlList(4);
		assertNotNull(pkgChnList);
		assertEquals(11, pkgChnList.size());
		
	}

}
