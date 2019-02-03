package dbconns;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Revenue;

public class RevenueDAOImpl implements RevenueDAO {

	public boolean update(int rvnID, String rvnName, int rvnNum, double rvnPrice) {
		System.out.println("... in revenue-update");
		boolean flag = false;
		int r = 0;
		String sql = "update revenues set rvnName=?,rvnNum=?,rvnPrice=? where rvnID=?";

		try {
			Connection conn = DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, rvnName);
			ps.setString(2, Integer.toString(rvnNum));
			ps.setString(3, Double.toString(rvnPrice));
			ps.setString(4, Integer.toString(rvnID));
			r=ps.executeUpdate();
			DBconn.close();
		} catch (SQLException e) {
			System.out.println("!! revenue-update error !!");
			e.printStackTrace();
		}

		if (r > 0) {
			System.out.println("--" + r + " lines affected --");
			flag = true;
		}

		return flag;
	}
	
	public List<Revenue> getall() {
		System.out.println("... in revenue-getall");
		List<Revenue> list = new ArrayList<Revenue>();
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("select * from revenues");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Revenue revenue=new Revenue();
				revenue.setRvnID(rs.getInt("rvnID"));
				revenue.setRvnName(rs.getString("rvnName"));
				revenue.setRvnNum(rs.getInt("rvnNum"));
				revenue.setRvnPrice(rs.getInt("rvnPrice"));
				list.add(revenue);
			}
			DBconn.close();
			
			System.out.println("-- revenue-getall success --");
		
			return list;
		} catch (SQLException e) {
			System.out.println("!! revenue-getall sql error !!");
			e.printStackTrace();
		}
		return null;
	}
	
	public int findprice(int rvnID) {
		System.out.println("... in revenue-findprice");
		int price=0;
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("select rvnPrice from revenues where rvnID="+rvnID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				price=rs.getInt("rvnPrice");
			}
			DBconn.close();
			
			System.out.println("-- revenue-findprice success --");					
		} catch (SQLException e) {
			System.out.println("!! revenue-findprice sql error !!");
			e.printStackTrace();
		}
    	
		return price;
		
	}
}
