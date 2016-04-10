package com.infinityCableService.modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infinityCableService.model.User;

public class UserTest {
	User usertestObj ;	


	@Before
	public void setUp() throws Exception {
		usertestObj = new User();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetUserId() {
		usertestObj.setUserId(10);
		assertEquals(10, usertestObj.getUserId());
	}

	
	@Test
	public final void testGetFirstName() {
		usertestObj.setFirstName("John");
		assertEquals("John", usertestObj.getFirstName());
	}


	@Test
	public final void testGetLastName() {
		usertestObj.setLastName("Smith");
		assertEquals("Smith", usertestObj.getLastName());
	}

	@Test
	public final void testGetEmailAddress() {
		usertestObj.setEmailAddress("johnsmith@gmail.com");
		assertEquals("johnsmith@gmail.com", usertestObj.getEmailAddress());
	}

	@Test
	public final void testGetPhoneNumber() {
		usertestObj.setPhoneNumber(234567890);
		assertEquals(234567890, usertestObj.getPhoneNumber());
	}


	@Test
	public final void testGetAddress1() {
		usertestObj.setAddress1("234 UT drive");
		assertEquals("234 UT drive", usertestObj.getAddress1());
	}

	
	@Test
	public final void testGetAddress2() {
		usertestObj.setAddress2("Apt Y");
		assertEquals("Apt Y", usertestObj.getAddress2());
	}

	
	@Test
	public final void testGetCity() {
		usertestObj.setCity("Fayetville");
		assertEquals("Fayetville", usertestObj.getCity());
	}


	@Test
	public final void testGetState() {
		usertestObj.setState("NC");
		assertEquals("NC", usertestObj.getState());
	}


	@Test
	public final void testGetPinCode() {
		usertestObj.setPinCode(23456);
		assertEquals(23456, usertestObj.getPinCode());
	}


	@Test
	public final void testGetUserCreateDate() {
		usertestObj.setUserCreateDate("2014-09-23 00:09:45");
		assertEquals("2014-09-23 00:09:45", usertestObj.getUserCreateDate());
	}

	@Test
	public final void testGetPassword() {
		usertestObj.setPassword("qwerty");
		assertEquals("qwerty", usertestObj.getPassword());
	}


	@Test
	public final void testGetRoleId() {
		usertestObj.setRoleId("Customer");
		assertEquals("Customer", usertestObj.getRoleId());
	}

	
	@Test
	public final void testGetStatus() {
		usertestObj.setStatus("A");
		assertEquals("A", usertestObj.getStatus());
	}

	/*@Test
	public final void testObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWait() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFinalize() {
		fail("Not yet implemented"); // TODO
	}*/
	

}
