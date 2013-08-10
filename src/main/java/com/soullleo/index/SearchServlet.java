/**
 * 
 */
package com.soullleo.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

/**
 * @author Soul
 * @date Aug 10, 2013
 */
public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3947687680240720280L;
	private Searcher searcher = Searcher.INSTANCE;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		String query = request.getParameter("q");
		int n = Integer.valueOf(request.getParameter("n"));
		try {
			TopDocs docs = searcher.doSearch(query, n);

			PrintWriter writer = response.getWriter();

			for (ScoreDoc doc : docs.scoreDocs) {
				writer.append(doc.toString());
			}

			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
