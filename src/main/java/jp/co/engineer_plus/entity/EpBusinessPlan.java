package jp.co.engineer_plus.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * business_planの実体
 */
@Entity
@Table(name="ep_business_plan")
public class EpBusinessPlan implements Serializable, EqEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="busines_plan_sid_seq")
	@SequenceGenerator(name="busines_plan_sid_seq", sequenceName="busines_plan_sid_seq", allocationSize=1)
	private Integer sid;
	@Column
	private String name;
	@Column
	private String title;
	@Column
	private String content;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_date")
	private Date updatedDate = new Date();
	@Column(name="created_user_id")
	private Integer createdUserId;
	@Column(name="updated_user_id")
	private Integer updatedUserId;

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}
	public Integer getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
