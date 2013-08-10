package com.soullleo.index.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soullleo.website.domain.Blog;

public class DataService {

	public List<Blog> getBlogs() {

		List<Blog> blogs = new ArrayList<Blog>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://209.141.46.127/soulwebsite?user=root&password=dianlang321");

			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from website_blog");

			while (resultSet.next()) {

				Blog blog = new Blog();

				blog.setContent(resultSet.getString("content"));
				blog.setCreateTime(resultSet.getDate("createTime"));
				blog.setId(resultSet.getLong("id"));
				blog.setKeyWords(resultSet.getString("keyWords"));
				blog.setStatus(resultSet.getString("status"));
				blog.setSummary(resultSet.getString("summary"));
				blog.setTags(resultSet.getString("tags"));
				blog.setTitle(resultSet.getString("title"));
				blog.setUpdateTime(resultSet.getDate("updateTime"));

				blogs.add(blog);

			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return blogs;
	}

}
