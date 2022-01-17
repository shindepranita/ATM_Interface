package daoImplemetion;

import java.sql.SQLException;

import dao.CheckBalanceDao;
import repository.CheckBalanceDaoRepository;

public class CheckBalanceDaoImp implements CheckBalanceDao {
	
	CheckBalanceDaoRepository checkBalanceDaoRepository=null;

	
	public CheckBalanceDaoImp()
	{
		try {
			checkBalanceDaoRepository=new CheckBalanceDaoRepository();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int checkBalance(int accountNo) {
		 int balance=0;
		try {
			balance=checkBalanceDaoRepository.checkBalance(accountNo);
			if(balance > 0)
			{
				return balance;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return balance;
		
	}

}
