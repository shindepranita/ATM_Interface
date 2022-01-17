package daoImplemetion;

import java.sql.SQLException;

import dao.ATM_Function_withdraw_and_Deposite;
import repository.WtdwDepositeDaoImpRepository;

public class WtdwDepositeDaoImp implements ATM_Function_withdraw_and_Deposite{

	WtdwDepositeDaoImpRepository wtdwDepositeDaoImpRepository=null;
	public WtdwDepositeDaoImp()
	{
		try {
			wtdwDepositeDaoImpRepository=new WtdwDepositeDaoImpRepository();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean deposite(int accountNo, int amount) {
		
	     try {
			return wtdwDepositeDaoImpRepository.deposite(accountNo, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean withdraw(int accountNo, int amount) {
		
		try {
			return wtdwDepositeDaoImpRepository.withdraw(accountNo, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
