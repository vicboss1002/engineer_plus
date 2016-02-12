package jp.co.engineer_plus.form;

import java.io.Serializable;

public class BusinessPlanForm implements Serializable, EqForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1551038280505536575L;
	private String name;
	private String title;
	private String content;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
