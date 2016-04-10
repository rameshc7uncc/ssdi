package com.infinityCableService.modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.model.Customer_Subscription;

public class Customer_SubscriptionTest {
	Customer_Subscription custSubsc;

	@Before
	public void setUp() throws Exception {
		custSubsc = new Customer_Subscription();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetRow_Id() {
		custSubsc.setRow_Id(12);
		assertEquals(12, custSubsc.getRow_Id());
		
	}

	@Test
	public final void testGetUser_Id() {
		custSubsc.setUser_Id(2);
		assertEquals(2, custSubsc.getUser_Id());
	}

	@Test
	public final void testGetP_Id() {
		custSubsc.setP_Id(4);
		assertEquals(4, custSubsc.getP_Id());	}

	@Test
	public final void testGetStart_Date() {
		custSubsc.setStart_Date("2015-09-09 23:23:30");
		assertEquals("2015-09-09 23:23:30", custSubsc.getStart_Date());
	}

	@Test
	public final void testGetEnd_Date() {
		custSubsc.setEnd_Date("2015-12-31 09:25:10");
		assertEquals("2015-12-31 09:25:10", custSubsc.getEnd_Date());
	}

}
