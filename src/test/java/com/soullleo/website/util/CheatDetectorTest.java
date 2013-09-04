/**
 * 
 */
package com.soullleo.website.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Soul
 * @date Sep 4, 2013
 */
public class CheatDetectorTest {

	@Test
	public void testContainLink() {
		assertTrue(CheatDetector.containLink("test <a href=\"#\">ssss</a>"));
		assertTrue(CheatDetector.containLink("test <a href=\"\">dddd</a>"));
		assertFalse(CheatDetector.containLink("ddsdfasdfsdf"));
	}

}
