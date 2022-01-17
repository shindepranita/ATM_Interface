package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DatabaseProperties;

public class WtdwDepositeDaoImpRepository {
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public WtdwDepositeDaoImpRepository() throws SQLException
	{
		connection=DatabaseProperties.getMyConnection();
		statement=connection.createStatement();
	}

	
	public boolean deposite(int accountNo,int amount) throws SQLException
	{
		resultSet=statement.executeQuery("select * from account where accountNo="+accountNo+"");
		while(resultSet.next())
		{
			int balance=resultSet.getInt("balance");
			balance=balance+amount;
			int r1=statement.executeUpdate("update account set balance="+balance+"where accountNo="+accountNo+"");
			if(r1==1)
				return true;
		}
			return false;
				
	}
	public boolean withdraw(int accountNo, int amount) throws SQLException 
	{
		
		resultSet=statement.executeQuery("select * from account where accountNo="+accountNo+"");
		while(resultSet.next())
		{
			int balance=resultSet.getInt("balance");
			balance=balance-amount;
	
			int r1=statement.executeUpdate("update account set balance="+balance+"where accountNo="+accountNo+"");
			if(r1==1)
				return true;
		}
			return false;
	}

}
