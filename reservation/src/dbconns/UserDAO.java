package dbconns;

import java.util.List;

import beans.User;

public interface UserDAO {
	public boolean login(String usrName,String usrKey);
	public boolean register(String usrName, String usrKey, String usrEmail);
	public List<User> getall();
	public boolean findsame(String usrName);
	public boolean update(int usrID, String usrName, String usrKey, String usrEmail) ;
	public String findemail(String usrName);
	public int findid(String usrName);
	public int findtype(String usrName);
	public boolean check(int usrID,String usrKey);
	
}
