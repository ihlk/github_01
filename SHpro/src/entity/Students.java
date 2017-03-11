package entity;

import java.util.Date;

//学生类
public class Students {
	
	private String sid;//学号
	private String sname;//姓名
	private String gender;//性别
	private Date birthday;//出生日期
	private String address;//地址
	
	public Students(){
		
	}
	public Students(String sid, String sname, String gender, Date birthday,
			String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	
	public String getSid() {
		return sid;
	}
	public String getSname() {
		return sname;
	}
	public String getGender() {
		return gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender="
				+ gender + ", birthday=" + birthday + ", address=" + address
				+ "]";
	}



	
}
