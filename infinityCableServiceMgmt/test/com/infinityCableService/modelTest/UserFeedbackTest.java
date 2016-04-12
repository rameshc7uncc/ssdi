package com.infinityCableService.modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.model.UserFeedback;

public class UserFeedbackTest {
	UserFeedback uft;

	@Before
	public void setUp() throws Exception {
		uft=new UserFeedback();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testgetU_Id() {
		uft.setU_Id(1234);
		assertEquals(1234, uft.getU_Id());
	}
	
	public final void testgetQ_type() {
		uft.setQ_type("Feedback");
		assertEquals("Feedback", uft.getQ_type());
	}
	
	public final void testgetQ_status() {
		uft.setQ_type("Open");
		assertEquals("Open", uft.getQ_status());
	}
	public final void testall() {
		testgetU_Id();
		testgetQ_type();
		testgetQ_status();
	}
}
