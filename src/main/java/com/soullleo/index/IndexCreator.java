/**
 * 
 */
package com.soullleo.index;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import com.soullleo.index.data.DataService;
import com.soullleo.website.domain.Blog;

/**
 * @author Soul
 * @date Aug 7, 2013
 */
public class IndexCreator {
	private static final String IndexPath = "/home/soul/Index";

	DataService dataService;

	public void init() {
		dataService = new DataService();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IndexCreator creator = new IndexCreator();
		creator.init();
		creator.index();

	}

	public void index() {

		List<Blog> blogs = dataService.getBlogs();
		IndexWriter writer = null;
		try {
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_44, analyzer);
			Directory directory = new SimpleFSDirectory(new File(IndexPath));
			
			writer = new IndexWriter(directory, config);

			for (int i = 0, count = blogs.size(); i < count; i++) {
				Blog blog = blogs.get(i);
				Document doc = new Document();

				System.out.println(blog.getContent());
				doc.add(new Field("Content", blog.getContent(), Field.Store.NO, Field.Index.ANALYZED));
				writer.addDocument(doc);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
