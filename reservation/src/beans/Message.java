package beans;

import java.sql.Timestamp;

public class Message {
	private int msgID;
	private String msgContent;
	private String msgAuthor;
	private boolean msgIsVisible;
	private Timestamp msgTime;
	
	public int getMsgID() {
		return msgID;
	}
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}
	
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	
	public String getMsgAuthor() {
		return msgAuthor;
	}
	public void setMsgAuthor(String msgAuthor) {
		this.msgAuthor = msgAuthor;
	}
	
	public boolean isMsgIsVisible() {
		return msgIsVisible;
	}
	public void setMsgIsVisible(boolean msgIsVisible) {
		this.msgIsVisible = msgIsVisible;
	}
	
	public Timestamp getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Timestamp msgTime) {
		this.msgTime = msgTime;
	}
	
}
