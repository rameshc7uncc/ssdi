package com.infinityCableService.modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.model.Channel;

public class ChannelTest {
Channel channeltestObj;
	@Before
	public void setUp() throws Exception {
		channeltestObj = new Channel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetc_Id() {
		channeltestObj.setc_Id(1);
		assertEquals(1, channeltestObj.getc_Id());
	}

	@Test
	public void testGetc_Name() {
		channeltestObj.setc_Name("tensports");
		assertEquals("tensports", channeltestObj.getc_Name());
	}

	//@SuppressWarnings("deprecation")
	@Test
	public void testGetc_Price() {
		channeltestObj.setc_Price(40);
		extracted();
	}

	private void extracted() {
		assertEquals(40, channeltestObj.getc_Price());
	}

	@Test
	public void testGetc_Status() {
		channeltestObj.setc_Status("Active");
		assertEquals("Active", channeltestObj.getc_Status());
	}

	@Test
	public void testGetc_HD() {
		channeltestObj.setc_HD("Y");
		assertEquals("Y", channeltestObj.getc_HD());
	}

}
