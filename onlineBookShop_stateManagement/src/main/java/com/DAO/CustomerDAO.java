package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.Customer;
import com.utils.DbUtil;

public class CustomerDAO implements AutoCloseable {

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

	// get customer using email id
	public Customer getCustomer(String email) throws Exception {
		Customer c = null;
		String sql = "select * from customers where email=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					c = new Customer();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setEmail(rs.getString("email"));
					c.setPassword(rs.getString("password"));
					c.setMobile(rs.getString("mobile"));
					c.setAddress(rs.getString("address"));
				}
			}
		}

		return c;
	}

}
