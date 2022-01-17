package main;

import java.util.Scanner;

import dao.ATM_Function_withdraw_and_Deposite;
import dao.CheckBalanceDao;
import dao.LoginDetailsDao;
import daoImplemetion.CheckBalanceDaoImp;
import daoImplemetion.LoginDetailsDaoImpl;
import daoImplemetion.WtdwDepositeDaoImp;
import model.Account;
import model.UserDetails;

public class User_Interface {

	public static void main(String[] args) {
		
System.out.println("***********Welcome to ATM Interface****************");
		
		
		System.out.println("1: Sign Up");
		System.out.println("2: Log in");
		System.out.println("3: About US");
		System.out.println("4: Exit");
		
		System.out.println("*********************************************");
		
		char ch=' ';
		LoginDetailsDao LoginDao=new LoginDetailsDaoImpl();
		ATM_Function_withdraw_and_Deposite withdrawobj=new WtdwDepositeDaoImp();
		CheckBalanceDao balanceDao=new CheckBalanceDaoImp();
		String username,firstname,lastname,password, location, mobileno;
		do {
			
			System.out.println("What you do wish to check from the above list");
		
		
			Scanner sn=new Scanner(System.in);
			int option=sn.nextInt();
		
			switch(option)
			{
				
				case 1:
						System.out.println("enter the details to signup");
						System.out.println("Enter Username");
						username=sn.next();
						System.out.println("Enter password");
						password=sn.next();
						System.out.println("Enter mobile Number");
						mobileno=sn.next();
						System.out.println("Enter first name");
						firstname=sn.next();
						System.out.println("Enter last name");
						lastname=sn.next();
						System.out.println("Enter location name");
						location=sn.next();
						UserDetails user=new UserDetails();
						user.setUsername(username);
						user.setPassword(password);
						user.setMobileno(mobileno);
						user.setFirstName(firstname);
						user.setLastName(lastname);
						user.setLocation(location);
						
						boolean r=LoginDao.signUp(user);
						if(r)
						{
							System.out.println("You have successfully Sign up");
						}
						else
						{
							System.out.println("You have not successfully Sign up");
						}
					
					break;
				case 2:
					System.out.println("enter the username and password to login");
					System.out.println("Enter Username ---->");
					String usern=sn.next();
					System.out.println("Enter Password----->");
					String pass=sn.next();
					UserDetails details=new UserDetails();
					details.setUsername(usern);
					details.setPassword(pass);
					boolean res=LoginDao.signIn(details);
					if(res)
					{
						System.out.println("*************************");
						System.out.println("1. Check Balalnce");
						System.out.println("2. Deposite amount");
						System.out.println("3. Withdraw amount");
						System.out.println("4. Exit");
						System.out.println("**************************");
						do
						{
							Account account=new Account();
							System.out.println("What you do wish to check from the above list");
							int option1=sn.nextInt();
							
							switch(option1)
							{
							case 1 :
								System.out.println("Enter the account No");
								int accountNo=sn.nextInt();
								account.setAccountNo(accountNo);
								int balance=balanceDao.checkBalance(accountNo);
								System.out.println("Total balance is= "+balance);
								break;
								
							case 2 :
								System.out.println("Enter the account No");
								int accountNo1=sn.nextInt();
								System.out.println("Enter the amount to Deposite");
								int amount=sn.nextInt();
								account.setAccountNo(accountNo1);
						        account.setBalance(amount);
								boolean result=withdrawobj.deposite(accountNo1, amount);
								if(result)
								{
								System.out.println(amount+" Rs. successfully creadited into account...!!");
								}
								
								
								break;
								
							case 3 :
								System.out.println("Enter the account No");
								int accountNo2=sn.nextInt();
								System.out.println("Enter the amount to withdraw");
								int amount1=sn.nextInt();
								account.setAccountNo(accountNo2);
								account.setBalance(amount1);
								boolean result1=withdrawobj.withdraw(accountNo2, amount1);
								if(result1)
								System.out.println(amount1+" Rs. successfully debited from account...!!");
								break; 
							case 4:
								//System.exit(0);
								System.out.println("You have successfully exited");
							default: System.out.println("enter the valid option");
							}
							System.out.println("Do you wish to check other options");
							ch=sn.next().charAt(0);
						}while(ch=='y'||ch=='Y');
						
					}
					   else 
						System.out.println("login failed");
					break;
				case 3:
					System.out.println(" ");
					break;
				case 4 :
					System.out.println("You have successfully Exit");
					break;
				default: System.out.println("enter the valid option");
			}
		System.out.println("Do you wish to check other options");
		ch=sn.next().charAt(0);
		
	  }while(ch=='y'||ch=='Y');
		
	}
	



	}


