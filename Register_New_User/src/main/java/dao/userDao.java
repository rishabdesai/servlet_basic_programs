package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.UserPOJO;
import utils.DButils;

public class userDao implements AutoCloseable{
	
private Connection connection;
private PreparedStatement validateStatement;
private PreparedStatement RegistrationStatement;

	public userDao() throws Exception{
	this.connection= DButils.getSQLiteConnection();
	this.validateStatement = this.connection.prepareStatement("select * from bookdb where email =? and password=?");
	
	this.RegistrationStatement=this.connection.prepareStatement("insert into bookdb values(?,?,?,?)");
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
	
	public int registerNewUser(UserPOJO user) throws SQLException {
		this.RegistrationStatement.setString(1, user.getFullName());
		this.RegistrationStatement.setString(2, user.getEmail());
		this.RegistrationStatement.setString(3, user.getPassword());
		this.RegistrationStatement.setString(4, user.getBirthDate());
		return this.RegistrationStatement.executeUpdate();
		
	}
	
	@Override
	public void close() throws Exception {
	}



	
	

}
