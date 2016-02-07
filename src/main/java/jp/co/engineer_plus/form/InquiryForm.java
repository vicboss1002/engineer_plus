package jp.co.engineer_plus.form;

import java.io.Serializable;

public class InquiryForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 795260027372918378L;
	private String name;
	private String mailAddress;
	private String title;
	private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
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
