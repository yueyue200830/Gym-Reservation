package beans;

public class User {
	private int usrID;
	private String usrName;
	private String usrKey;
	private String usrEmail;
	private int usrType;  // 0: ordinary 1: manager 2: super manager
	
	public int getUsrID() {
		return usrID;
	}
	public void setUsrID(int usrID) {
		this.usrID=usrID;
	}
	
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	
	public String getUsrKey() {
		return usrKey;
	}
	public void setUsrKey(String usrKey) {
		this.usrKey = usrKey;
	}
	
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	
	public int getUsrType() {
		return usrType;
	}
	public void setUsrType(int usrType) {
		this.usrType = usrType;
	}
}
