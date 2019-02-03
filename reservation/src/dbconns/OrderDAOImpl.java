package dbconns;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import beans.News;
import beans.Order;
import dbconns.RevenueDAO;
import dbconns.RevenueDAOImpl;

public class OrderDAOImpl implements OrderDAO {
	
	public List<String> getall() {
		System.out.println("... in Order-getall");
		List<String> list = new ArrayList<String>();
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("SELECT ordID,usrName,ordName,rvnName,rvnRoom,ordPhone,ordPrice,rvnDate,rvnTime FROM orders inner join users on orders.usrID=users.usrID inner join revenues on orders.rvnID = revenues.rvnID");
			ResultSet rs = ps.executeQuery();
			System.out.println("-- query done --");
			while(rs.next()){
				list.add(Integer.toString(rs.getInt("ordID")));
				list.add(rs.getString("usrName"));
				list.add(rs.getString("ordName"));
				list.add(rs.getString("rvnName"));
				list.add(Integer.toString(rs.getInt("rvnRoom")));
				list.add(rs.getString("ordPhone"));
				list.add(Double.toString(rs.getDouble("ordPrice")));
				list.add(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("rvnDate")));		
				int orgTime = rs.getInt("rvnTime");
				String time = Integer.toString(orgTime+12)+":00 - "+Integer.toString(orgTime+13)+":00";
				list.add(time);
			}
			
			DBconn.close();
			
			System.out.println("-- Order-getall success --");
		
			return list;
		} catch (SQLException e) {
			System.out.println("!! Order-getall sql error !!");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> usergetall(int usrID){
		System.out.println("... in Order-usergetall");
		List<String> list = new ArrayList<String>();
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("SELECT ordID,usrName,ordName,rvnName,rvnRoom,ordPhone,ordPrice,rvnDate,rvnTime "
		    +"FROM orders inner join users on orders.usrID=users.usrID inner join revenues on orders.rvnID = revenues.rvnID where orders.usrID="+usrID);
			ResultSet rs = ps.executeQuery();
			System.out.println("-- query done --");
			while(rs.next()){
				list.add(Integer.toString(rs.getInt("ordID")));
				list.add(rs.getString("usrName"));
				list.add(rs.getString("ordName"));
				list.add(rs.getString("rvnName"));
				list.add(Integer.toString(rs.getInt("rvnRoom")));
				list.add(rs.getString("ordPhone"));
				list.add(Double.toString(rs.getDouble("ordPrice")));
				list.add(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("rvnDate")));	
				int orgTime = rs.getInt("rvnTime");
				String time = Integer.toString(orgTime+12)+":00 - "+Integer.toString(orgTime+13)+":00";
				list.add(time);
			}
			
			DBconn.close();
			
			System.out.println("-- Order-usergetall success --");
		
			return list;
		} catch (SQLException e) {
			System.out.println("!! Order-usergetall sql error !!");
			e.printStackTrace();
		}
		return null;
	}
	
	public int[][] available(int rvnID, String rvnDate){
		System.out.println("... in order-available");
		int price=0;
		RevenueDAO rd=new RevenueDAOImpl();
		price=rd.findprice(rvnID);
		int[][] avai=new int[4][8];
		for(int i=0;i<4;i++) {
			for(int j=0;j<8;j++) {
				avai[i][j]=price;
			}
		}
			
		String sql="select rvnRoom,rvnTime from orders where rvnDate=? and rvnID=?";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,rvnDate);
			ps.setInt(2,rvnID);
			System.out.println("-- ps success: "+ps+" --");

			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int col=0,row=0;
				row=rs.getInt("rvnRoom");
				col=rs.getInt("rvnTime");
				System.out.println(row+","+col);
				avai[row-1][col-1]=0;
			}
			DBconn.close();
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<8;j++) {
					System.out.print(avai[i][j]+" ");
				}
				System.out.println("");
			}
			
			System.out.println("-- orderdaoimpl-available success --");
		
		} catch (SQLException e) {
			System.out.println("!! order-available sql error !!");
			e.printStackTrace();
		}
		
		return avai;
	}
	
	public boolean add(int usrID, String ordName, int rvnID, int rvnRoom,String ordPhone, double ordPrice, String rvnDate, int rvnTime) {
		System.out.println("... in order-add");
		String sql="insert into orders (usrID,ordName,rvnID,rvnRoom,ordPhone,ordPrice,rvnDate,rvnTime) values (?,?,?,?,?,?,?,?)";
		int r=0;
		boolean flag=false;
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,Integer.toString(usrID));
			ps.setString(2,ordName);
			ps.setString(3,Integer.toString(rvnID));
			ps.setString(4,Integer.toString(rvnRoom));
			ps.setString(5,ordPhone);
			ps.setString(6,Double.toString(ordPrice));
			ps.setString(7,rvnDate);
			ps.setString(8,Integer.toString(rvnTime));
			System.out.println("-- ps success: "+ps+" --");
			
			r=ps.executeUpdate();
			
			if(r>0)
				flag=true;
			
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! user-register sql error !!");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean delete(int ordID) {
		System.out.println("... in order-add");
		String sql="delete from orders where ordID=?";
		int r=0;
		boolean flag=false;
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,Integer.toString(ordID));
			System.out.println("-- ps success: "+ps+" --");

			r=ps.executeUpdate();
			
			if(r>0)
				flag=true;
			
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! user-delete sql error !!");
			e.printStackTrace();
		}
		
		return flag;
	}
}
