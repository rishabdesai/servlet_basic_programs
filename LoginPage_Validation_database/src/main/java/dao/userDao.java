package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.UserPOJO;
import utils.DButils;

public class userDao implements AutoCloseable{
	
private Connection connection;
private PreparedStatement validateStatement;

	public userDao() throws Exception{
	this.connection= DButils.getSQLiteConnection();
	this.validateStatement = connection.prepareStatement("select * from bookdb where email =? and password=?");
	}


	public UserPOJO validateEmailPassword(String email, String password) throws Exception {
		this.validateStatement.setString(1, email);
		this.validateStatement.setString(2, password);
		
		try(ResultSet rs = this.validateStatement.executeQuery()){
		if(rs.next())	
			return new UserPOJO(rs.getString("full_name"),rs.getString("email"),rs.getString("password"),rs.getString("birthdate")); 
		}
		
		
		return null;
	}
	
	
	
	@Override
	public void close() throws Exception {
		
	}
	
	

}
