package beans;

import java.sql.Timestamp;

public class News {
	private int newID;
	private String newTitle;
	private String newContent;
	private String newTime;
	private String newPhoto;
	
	public int getNewID() {
		return newID;
	}
	public void setNewID(int newID) {
		this.newID=newID;
	}
	
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	
	public String getNewTime() {
		return newTime;
	}
	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}
	
	public String getNewPhoto() {
		return newPhoto;
	}
	public void setNewPhoto(String newPhoto) {
		this.newPhoto=newPhoto;
	}
}
