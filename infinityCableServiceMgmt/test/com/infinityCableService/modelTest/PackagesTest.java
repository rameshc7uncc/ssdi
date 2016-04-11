package com.infinityCableService.modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.model.Packages;

public class PackagesTest {
	Packages packagestestObj;
	@Before
	public void setUp() throws Exception {
		packagestestObj=new Packages();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetp_Id() {
		packagestestObj.setp_Id(1);
		assertEquals(1, packagestestObj.getp_Id());
	}

	@Test
	public void testGetp_Name() {
		packagestestObj.setp_Name("Standard");
		assertEquals("Standard", packagestestObj.getp_Name());
	}

	@Test
	public void testGetp_Description() {
		packagestestObj.setp_Description("Includes 10 channels");
		assertEquals("Includes 10 channels", packagestestObj.getp_Description());
	}

	@Test
	public void testGetp_Price() {
		packagestestObj.setp_Price(40);
		assertEquals(40, packagestestObj.getp_Price());
	}

	@Test
	public void testGetp_Status() {
		packagestestObj.setp_Status("Active");
		assertEquals("Active", packagestestObj.getp_Status());	
	}

	@Test
	public void testGetp_CreatedDate() {
		packagestestObj.setp_CreatedDate("2016-04-11 13:52:08");
		assertEquals("2016-04-11 13:52:08", packagestestObj.getp_CreatedDate());
	}

	@Test
	public void testGetp_DeletedDate() {
		packagestestObj.setp_DeletedDate("2016-04-11 14:45:27");
		assertEquals("2016-04-11 14:45:27", packagestestObj.getp_DeletedDate());
	}

}
