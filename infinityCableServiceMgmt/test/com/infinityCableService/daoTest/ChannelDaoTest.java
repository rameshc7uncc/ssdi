package com.infinityCableService.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.dao.ChannelDao;

public class ChannelDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetAllChannels() {
		
		try {
			List<String> allchnlList = ChannelDao.getAllChannels();
			assertNotNull(allchnlList);
			assertEquals(43, allchnlList.size());

		} catch (HibernateException exception) {
			exception.printStackTrace();
		}

	}

	@Test
	public final void testGetChannelIds() {

		try {
			String[] channelList = {"Discovery", "HBO", "Star Movies", "tenSports","YES" };
			 
			List<Integer> chnlIds = ChannelDao.getChannelIds(channelList);
			assertNotNull(chnlIds);
			assertEquals(5, chnlIds.size());
			assertTrue(chnlIds.contains(30));
			assertTrue(chnlIds.contains(40));
			assertTrue(chnlIds.contains(42));
			assertTrue(chnlIds.contains(4));
			assertTrue(chnlIds.contains(13));
			
			
		}catch (HibernateException exception) {
			exception.printStackTrace();
		}

	}

	@Test
	public final void testGetAllAddChannelsForPid() {
		
		try {
			 
			List<String> chnlNamesList = ChannelDao.getAllAddChannelsForPid(2);
			assertNotNull(chnlNamesList);
			/*assertTrue(chnlNamesList.contains(30));
			assertTrue(chnlNamesList.contains(40));
			assertTrue(chnlNamesList.contains(42));
			assertTrue(chnlNamesList.contains(4));
			assertTrue(chnlNamesList.contains(13));*///should set values based on test db.
			
			
		}catch (HibernateException exception) {
			exception.printStackTrace();
		}
		
	}

}
