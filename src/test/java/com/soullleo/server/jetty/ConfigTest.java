/**
 * 
 */
package com.soullleo.server.jetty;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Soul
 * @date Jun 2, 2013
 */
public class ConfigTest {
	Config config = Config.INSTANCE;

	@Before
	public void setUp() throws Exception {
		
		Config.INSTANCE.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPort() {
		assertEquals(8080, config.getPort());
	}

	@Test
	public void testGetWebfilepath() {
		assertEquals("/home/soul/git/mysite/src/main/webapp/WEB-INF/web.xml", config.getWebfilepath());
	}

	@Test
	public void testGetResourcepath() {
		assertEquals("/home/soul/git/mysite/src/main/webapp", config.getResourcepath());
	}

	@Test
	public void testGetContextpath() {
		assertEquals("/", config.getContextpath());
	}

}
