package daoImplemetion;

import java.sql.SQLException;

import dao.LoginDetailsDao;
import model.UserDetails;
import repository.LoginDetailsDaoRes;

public class LoginDetailsDaoImpl implements LoginDetailsDao
{
LoginDetailsDaoRes loginDetailsDaoRes=null;
	
	public LoginDetailsDaoImpl()
	{
		try {
			loginDetailsDaoRes=new LoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e.getMessage());
		}
	}

	@Override
	public boolean signUp(UserDetails user) {
		
		try {
			return loginDetailsDaoRes.signUp(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign up"+e.getMessage());
			return false;
		}

		
	}

	@Override
	public boolean signIn(UserDetails user) {
		try {
			return loginDetailsDaoRes.signIn(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	

	

}
