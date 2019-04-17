package adou.common.pojo;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable {
	
	private long id;
	private  String text;
	private String 	state;
	public long getId() {
		return id;
	}
	public void setId(Long long1) {
		this.id = long1;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
