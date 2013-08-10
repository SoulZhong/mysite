/**
 * 
 */
package com.soullleo.index;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.soullleo.server.jetty.Config;

/**
 * @author Soul
 * @date Aug 7, 2013
 */
public enum Searcher {

	INSTANCE;

	Searcher() {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private IndexSearcher is;

	private void init() throws IOException {

		// System.out.println(">>>>>>>>>>>>>>>"+Config.INSTANCE.getIndexPath());
		// System.out.println(">>>>>>>>>>>>>>>"+Config.INSTANCE.getPort());
		IndexReader indexReader = DirectoryReader.open(FSDirectory
				.open(new File(Config.INSTANCE.getIndexPath())));

		is = new IndexSearcher(indexReader);

	}

	/**
	 * 
	 * @param q
	 * @param n
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public TopDocs doSearch(String q, int n) throws IOException, ParseException {

		QueryParser parser = new QueryParser(Version.LUCENE_44, "Content",
				new StandardAnalyzer(Version.LUCENE_44));
		Query query = parser.parse(q);

		TopDocs docs = is.search(query, n);

//		System.out.println(">>>>>>>>>>>>>" + docs.totalHits);

		return docs;

	}

}
