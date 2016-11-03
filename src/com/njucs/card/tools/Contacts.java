package com.njucs.card.tools;

/*
 * 联系人字段，暂时这些，以后需要再添加
 * 2016-11-02
 */

public class Contacts {
	private String name;					// 姓名
	private String duty;					// 职务
	private String company;			// 公司
	private String address;				// 地址
	private String telephone;			// 电话
	private String mobilephone;		// 手机
	private String mail;					// 邮箱
	private String fax;						// 传真
	private String note;					// 备注
	
	//	Get Set 函数
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
