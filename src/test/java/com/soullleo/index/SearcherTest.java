package com.soullleo.index;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.soullleo.server.jetty.Config;

public class SearcherTest {
	
	Searcher searcher;

	@Before
	public void setUp() throws Exception {
		
		Config.INSTANCE.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
		searcher = Searcher.INSTANCE;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoSearch() throws IOException, ParseException {
		assertTrue(searcher.doSearch("方式", 10).totalHits > 0);
	}

}
