package beans;

import java.util.Date;

public class Order {
	private int ordID;
	private int usrID;
	private String ordName;
	private int rvnID;
	private int rvnRoom;
	private String ordPhone;
	private int ordPrice;
	private  Date rvnDate;
	private int rvnTime;
	
	public int getOrdID() {
		return ordID;
	}
	public void setOrdID(int ordID) {
		this.ordID = ordID;
	}
	
	public int getUsrID() {
		return usrID;
	}
	public void setUsrID(int usrID) {
		this.usrID = usrID;
	}
	
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	
	public int getRvnID() {
		return rvnID;
	}
	public void setRvnID(int rvnID) {
		this.rvnID = rvnID;
	}
	
	public int getRvnRoom() {
		return rvnRoom;
	}
	public void setRvnRoom(int rvnRoom) {
		this.rvnRoom=rvnRoom;
	}
	
	public String getOrdPhone() {
		return ordPhone;
	}
	public void setOrdPhone(String ordPhone) {
		this.ordPhone = ordPhone;
	}
	
	public int getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}
	
	public Date getRvnDate() {
		return rvnDate;
	}
	public void setRvnDate(Date rvnDate) {
		this.rvnDate=rvnDate;
	}
	
	public int getRvnTime() {
		return rvnTime;
	}
	public void setRvnTime(int rvnTime) {
		this.rvnTime=rvnTime;
	}
	
}
