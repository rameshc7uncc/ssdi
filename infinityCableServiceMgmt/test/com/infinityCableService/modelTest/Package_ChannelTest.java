package com.infinityCableService.modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinityCableService.model.Package_Channel;

public class Package_ChannelTest {
	
	Package_Channel packagechannelTest;

	@Before
	public void setUp() throws Exception {
		packagechannelTest= new Package_Channel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRow_id() {
		packagechannelTest.setRow_id(10);
		assertEquals(10, packagechannelTest.getRow_id());
	}

	@Test
	public void testGetc_Id() {
		packagechannelTest.setc_Id(10);
		assertEquals(10, packagechannelTest.getc_Id());
	}

	@Test
	public void testGetp_Id() {
		packagechannelTest.setp_Id(10);
		assertEquals(10, packagechannelTest.getp_Id());
	}

}
