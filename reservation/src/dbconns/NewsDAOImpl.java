package dbconns;

import java.sql.*;
import java.util.*;

import beans.News;
import dbconns.DBconn;

public class NewsDAOImpl implements NewsDAO {
	public List<News> getall(){
		System.out.println("... in user-getall");
		List<News> list = new ArrayList<News>();
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("select * from news order by newTime desc\r\n");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setNewID(rs.getInt("newID"));
				news.setNewTitle(rs.getString("newTitle"));
				news.setNewContent(rs.getString("newContent"));
				news.setNewTime(rs.getString("newTime"));
				news.setNewPhoto(rs.getString("newPhoto"));
				list.add(news);
			}
			DBconn.close();
			
			System.out.println("-- news-getall success --");
		
			return list;
		} catch (SQLException e) {
			System.out.println("!! news-getall sql error !!");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean add(String newTitle, String newContent, String newPhoto) {
		System.out.println("... in news-add");
		boolean flag=false;
		int r=0;
		String sql="insert into news(newTitle,newContent,newPhoto,newTime) values(?,?,?,current_timestamp())";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,newTitle);
			ps.setString(2,newContent);
			ps.setString(3,newPhoto);
			System.out.println("-- ps success: "+ps+" --");

			r=ps.executeUpdate();
			
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! news-add sql error !!");
			e.printStackTrace();
		}
		
		if(r > 0) {
			System.out.println("--" + r + " lines affected --");
			flag = true;
		}
		return flag;
	}
}