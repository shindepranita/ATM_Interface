package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DatabaseProperties;
import model.UserDetails;

public class LoginDetailsDaoRes 
{
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public LoginDetailsDaoRes() throws SQLException
	{
		connection=DatabaseProperties.getMyConnection();
		statement=connection.createStatement();
	}
	
	public boolean signUp(UserDetails user) throws SQLException {
		// TODO Auto-generated method stub
	
	int r=statement.executeUpdate("insert into userdetails values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getMobileno()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getLocation()+"')");
	if(r==1)
	{
	return true;
	}else
		return false;

	}
	public boolean signIn(UserDetails user) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String tuser=user.getUsername();
		String pass=user.getPassword();
		resultSet=statement.executeQuery("select *from userdetails where username='"+tuser+"' and password='"+pass+"'");
		if(resultSet.next())
		{
		return true;
		}else
			return false;
	}




}
