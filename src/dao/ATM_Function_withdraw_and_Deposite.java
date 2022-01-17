package dao;

public interface ATM_Function_withdraw_and_Deposite {
	
	public boolean deposite(int accountNo,int amount);
	public boolean withdraw(int accountNo,int amount);
	

}
