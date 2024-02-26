package com.fwzl.entity;

import java.util.Date;

//租客实体
public class User {
   
	public User() {
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
	public User(Integer id, String phone, String realname, String pwd, String sex, String nickname, Date createtime) {
		super();
		this.id = id;
		this.phone = phone;
		this.realname = realname;
		this.pwd = pwd;
		this.sex = sex;
		this.nickname = nickname;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	private String  sex;//性别
    private String  nickname;//昵称
    private Date  createtime;//创建日期

}
