package com.DAO;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.entities.Book;
import com.mysql.cj.protocol.Resultset;
import com.utils.DbUtil;

public class BookDAO implements AutoCloseable {
	private Connection con;

	public void open() throws Exception {
		con = DriverManager.getConnection(DbUtil.DB_URL, DbUtil.DB_USER, DbUtil.DB_PASS);
	}

	@Override
	public void close() throws Exception {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get subjects to display in SubjectServlet.java as radio buttons
	public List<String> getSubjects() throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct subject from books";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					String subject = rs.getString("subject");
					list.add(subject);
				}
			}
		}
		return list;
	}

	// get book of given subject

	public List<Book> getBookBySubject(String subject) throws Exception {
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from books where subject=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, subject);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Book b = new Book();
					b.setId(rs.getInt("id"));
					b.setName(rs.getString("name"));
					b.setAuthor(rs.getString("author"));
					b.setSubject(rs.getString("subject"));
					b.setPrice(rs.getDouble("price"));
					list.add(b);

				}
			}

		}
		return list;
	}
	// get book of given id

	public Book getBookById(int id) throws Exception {
		Book b = null;
		String sql = "select * from books where id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					b = new Book();
					b.setId(rs.getInt("id"));
					b.setName(rs.getString("name"));
					b.setAuthor(rs.getString("author"));
					b.setSubject(rs.getString("subject"));
					b.setPrice(rs.getDouble("price"));

				}
			}
		}
		return b;
	}

}
