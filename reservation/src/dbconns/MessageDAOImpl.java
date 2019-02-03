package dbconns;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.Message;

public class MessageDAOImpl implements MessageDAO {
	public List<Message> getall(){
		System.out.println("... in message-getall");
		List<Message> list = new ArrayList<Message>();
		
    	try {
		    Connection conn=DBconn.init();
		    
		    PreparedStatement ps=conn.prepareStatement("select * from messages");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Message message=new Message();
				message.setMsgID(rs.getInt("msgID"));
				message.setMsgAuthor(rs.getString("msgAuthor"));
				message.setMsgContent(rs.getString("msgContent"));
				message.setMsgIsVisible(rs.getBoolean("msgIsVisible"));
				message.setMsgTime(rs.getTimestamp("msgTime"));
				list.add(message);
			}
			DBconn.close();
			
			System.out.println("-- message-getall success --");
		
			return list;
		} catch (SQLException e) {
			System.out.println("!! message-getall sql error !!");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean add(String msgAuthor,String msgContent) {
		System.out.println("... in messages-add");
		boolean flag=false;
		int r=0;
		String sql="insert into messages(msgAuthor,msgContent,msgIsVisible,msgTime) values(?,?,0,current_timestamp())";
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,msgAuthor);
			ps.setString(2,msgContent);
			System.out.println("-- ps success: "+ps+" --");

			r=ps.executeUpdate();
			
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! messages-add sql error !!");
			e.printStackTrace();
		}
		
		if(r > 0) {
			System.out.println("--" + r + " lines affected --");
			flag = true;
		}
		return flag;
	}
	
	public boolean publish(int msgID) {
		System.out.println("... in message publish");
		boolean flag=false;
		int r=0;
		String sql="update messages set msgIsVisible=1 where msgID="+msgID;
		
		try {
			Connection conn=DBconn.init();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println("-- ps success: "+ps+" --");

			r=ps.executeUpdate();
			
			DBconn.close();
		}catch(SQLException e) {
			System.out.println("!! messages-publish sql error !!");
			e.printStackTrace();
		}
		
		if(r > 0) {
			System.out.println("--" + r + " lines affected --");
			flag = true;
		}
		return flag;
	}
}
