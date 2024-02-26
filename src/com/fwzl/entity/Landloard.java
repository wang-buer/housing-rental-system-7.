package com.fwzl.entity;

import java.util.Date;

//房东实体
public class Landloard {
   
	public Landloard() {
		super();
	}
	private Integer id;
	private String phone;
	private String realname;//姓名
    private String pwd;//密码
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public Landloard(Integer id, String phone, String realname, String pwd, String sex, Date createtime) {
		super();
		this.id = id;
		this.phone = phone;
		this.realname = realname;
		this.pwd = pwd;
		this.sex = sex;
	
		this.createtime = createtime;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	private String  sex;//性别
   
    private Date  createtime;//创建日期

}
