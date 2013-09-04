/**
 * 
 */
package com.soullleo.index.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Soul
 * @date Aug 7, 2013
 */
public class DataServiceTest {

	DataService dataService = new DataService();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBlogs() {

		assertTrue(dataService.getBlogs().size() > 0);

	}

}
