package dao;

import model.UserDetails;

public interface LoginDetailsDao {
	
	public boolean signUp(UserDetails user);
	public boolean signIn(UserDetails user);


}
