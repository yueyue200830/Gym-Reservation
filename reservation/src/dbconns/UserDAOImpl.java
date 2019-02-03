package dbconns;

import java.sql.*;
import java.util.*;

import beans.User;
import dbconns.DBconn;

public class UserDAOImpl implements UserDAO {
	public boolean login(String usrName, String usrKey) {
		System.out.println("... in user-login");
		
		boolean flag = false;
		String sql="select * from users where usrName=? and usrKey=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,usrName);
			ps.setString(2,usrKey);
			System.out.println("-- ps success: "+ps+" --");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("-- record found --");
				if (rs.getString("usrName").equals(usrName) && rs.getString("usrKey").equals(usrKey)) {
					flag = true;
				}
			}
			
			DBconn.close();
		} catch (SQLException e) {
			System.out.println("!! user-login sql error !!");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean register(String usrName, String usrKey, String usrEmail) {
		System.out.println("... in user-register");
		boolean flag=false;
		int r=0;
		String sql="insert into users(usrName, usrKey, usrEmail, usrType) values(?,?,?,0)";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,usrName);
			ps.setString(2,usrKey);
			ps.setString(3,usrEmail);
			System.out.println("-- ps success: "+ps+" --");

			r=ps.executeUpdate();
			
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! user-register sql error !!");
			e.printStackTrace();
		}
		
		if(r > 0) {
			System.out.println("--" + r + " lines affected --");
			flag = true;
		}
		return flag;
	}	
	
	public List<User> getall() {
		System.out.println("... in user-getall");
		List<User> list = new ArrayList<User>();
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUsrID(rs.getInt("usrID"));
				user.setUsrName(rs.getString("usrName"));
				user.setUsrKey(rs.getString("usrKey"));
				user.setUsrEmail(rs.getString("usrEmail"));
				user.setUsrType(rs.getInt("usrType"));
				list.add(user);
			}
			DBconn.close();
			
			System.out.println("-- user-getall success --");
		
			return list;
		} catch (SQLException e) {
			System.out.println("!! user-getall sql error !!");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean findsame(String usrName) {
		System.out.println("... in user-findsame");
		boolean flag=false;
		String sql="select * from users where usrName=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, usrName);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				flag=true;
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! user-findsame error !!");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean update(int usrID, String usrName, String usrKey, String usrEmail) {
		System.out.println("... in user-update");
		boolean flag = false;
		int r = 0;
		String sql = "update users set usrName=?, usrKey=?, usrEmail=? where usrID=?";

		try {
			Connection conn = DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, usrName);
			ps.setString(2, usrKey);
			ps.setString(3, usrEmail);
			ps.setInt(4, usrID);
			r=ps.executeUpdate();
			DBconn.close();
		} catch (SQLException e) {
			System.out.println("!! user-update error !!");
			e.printStackTrace();
		}

		if (r > 0) {
			System.out.println("--" + r + " lines affected --");
			flag = true;
		}

		return flag;
	}
	
	public String findemail(String usrName) {
		System.out.println("... in user-findemail");
		String email="";
		
		String sql="select usrEmail from users where usrName=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,usrName);
			System.out.println("-- ps success: "+ps+" --");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				email= rs.getString("usrEmail");
			}
			
			DBconn.close();
			System.out.println("-- success findemail: "+email);
			return email;
		} catch (SQLException e) {
			System.out.println("!! user-findemail sql error !!");
			e.printStackTrace();
			return null;
		}
	}
	
	public int findid(String usrName) {
		System.out.println("... in user-findid");
		int usrID=0;
		
		String sql="select usrID from users where usrName=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,usrName);
			System.out.println("-- ps success: "+ps+" --");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usrID= rs.getInt("usrID");
			}
			
			DBconn.close();
			
			System.out.println("-- success id: "+usrID);
			return usrID;
		} catch (SQLException e) {
			System.out.println("!! user-findid sql error !!");
			e.printStackTrace();
			return usrID;
		}
	}
	
	public int findtype(String usrName) {
		System.out.println("... in user-findtype");
		int usrType=-1;
		
		String sql="select usrType from users where usrName=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,usrName);
			System.out.println("-- ps success: "+ps+" --");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usrType= rs.getInt("usrType");
			}
			
			DBconn.close();
			
			System.out.println("-- success id: "+usrType);
		} catch (SQLException e) {
			System.out.println("!! user-findid sql error !!");
			e.printStackTrace();
		}
		
		return usrType;
	}
	
	public boolean check(int usrID,String usrKey) {
		System.out.println("... in user-check");
		
		boolean flag = false;
		String sql="select * from users where usrID=? and usrKey=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,usrID);
			ps.setString(2,usrKey);
			System.out.println("-- ps success: "+ps+" --");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("-- record found --");
				if (rs.getInt("usrID")==usrID && rs.getString("usrKey").equals(usrKey)) {
					flag = true;
				}
			}
			
			DBconn.close();
		} catch (SQLException e) {
			System.out.println("!! user-check sql error !!");
			e.printStackTrace();
		}
		
		return flag;
	}
}
