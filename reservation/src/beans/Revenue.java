package beans;

public class Revenue {
	private int rvnID;
	private String rvnName;
	private int rvnNum; //the num of rooms
	private int rvnPrice;
	
	public int getRvnID() {
		return rvnID;
	}
	public void setRvnID(int rvnID) {
		this.rvnID=rvnID;
	}
	
	public String getRvnName() {
		return rvnName;
	}
	public void setRvnName(String rvnName) {
		this.rvnName = rvnName;
	}
	
	public int getRvnNum() {
		return rvnNum;
	}
	public void setRvnNum(int rvnNum) {
		this.rvnNum = rvnNum;
	}
	
	public int getRvnPrice() {
		return rvnPrice;
	}
	public void setRvnPrice(int rvnPrice) {
		this.rvnPrice = rvnPrice;
	}
	
	
}
