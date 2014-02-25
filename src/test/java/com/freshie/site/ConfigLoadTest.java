package com.freshie.site;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigLoadTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(Config.getValue("db_server"),"localhost");
		assertEquals(Config.getValue("db_port"),"27017");
		assertEquals(Config.getValue("db_username"),"freshie");
		assertEquals(Config.getValue("db_password"),"genefreshie0707");
		assertEquals(Config.getValue("db_blogdb"),"blogposts");
		assertEquals(Config.getValue("page_size"),"10");		
	}

}
