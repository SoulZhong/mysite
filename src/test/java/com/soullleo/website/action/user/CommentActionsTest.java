/**
 * 
 */
package com.soullleo.website.action.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Soul
 * @date Sep 4, 2013
 */
public class CommentActionsTest {
	
	CommentActions actions = new CommentActions();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.soullleo.website.action.user.CommentActions#containLink(java.lang.String)}.
	 */
	@Test
	public void testContainLink() {
		
		assertTrue(actions.containLink("asdfsdf <a href=\"http://soullleo.com\"> asdfsdf</a>"));
		assertFalse(actions.containLink("asdfas<afadsfsadf"));
	}

}
