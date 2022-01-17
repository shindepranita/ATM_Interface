package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DatabaseProperties;

public class CheckBalanceDaoRepository {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public CheckBalanceDaoRepository() throws SQLException
	{
		connection=DatabaseProperties.getMyConnection();
		statement=connection.createStatement();
	}

	public int checkBalance (int accountNo) throws SQLException
	{
		resultSet=statement.executeQuery("select * from account where accountNo="+accountNo+"");
		resultSet.next();
		   int value=resultSet.getInt("balance");
		   
		   return value;
		
	}
}
