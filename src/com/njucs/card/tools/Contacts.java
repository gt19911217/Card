package com.njucs.card.tools;

import com.njucs.card.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
//import android.widget.TextView;

/*
 * 联系人字段，暂时这些，以后需要再添加
 * 2016-11-02
 */

public class Contacts extends BaseActivity{
	private String name;					// 姓名
	private String duty;					// 职务
	private String company;			// 公司
	private String address;				// 地址
	private String telephone;			// 电话
	private String mobilephone;		// 手机
	private String mail;					// 邮箱
	private String fax;						// 传真
	private String note;			// 备注
	
	//private TextView Name,Phone,Company,Email,Duty;
	private EditText PutName,PutPhone,PutCompany,PutEmail,PutDuty;
	
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

	
	public Contacts(String s){
		name="zwj";
		mobilephone="15152280426";
		company="南京大学";
		address="江苏省南京市栖霞区仙林大道163号";
		duty="学生";
		mail="1031320610@qq.com";
		note="nothing";
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		
		/*Name=(TextView)findViewById(R.id.Name);
		Phone=(TextView)findViewById(R.id.MobilePhone);
		Company=(TextView)findViewById(R.id.Company);
		Email=(TextView)findViewById(R.id.Email);
		Duty=(TextView)findViewById(R.id.Duty);*/
		
		PutName=(EditText)findViewById(R.id.PutName);
		PutPhone=(EditText)findViewById(R.id.PutPhone);
		PutCompany=(EditText)findViewById(R.id.PutCompany);
		PutEmail=(EditText)findViewById(R.id.PutEmail);
		PutDuty=(EditText)findViewById(R.id.PutDuty);
		
		PutName.setText(name);
		PutPhone.setText(mobilephone);
		PutCompany.setText(company);
		PutEmail.setText(mail);
		PutDuty.setText(duty);
	}

	//创建活动
	public void action(Context PageContext){
		Intent intent=new Intent(PageContext,Contacts.class);
		Log.i("String", "Come in!");
		startActivity(intent);
	}
}
