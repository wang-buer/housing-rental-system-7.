package com.fwzl.entity;

//管理员
public class Admin {
   
	private Integer id;    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public Admin(Integer id, String phone, String pwd, String nickname) {
		super();
		this.id = id;
		this.phone = phone;
		this.pwd = pwd;
		this.nickname = nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private String phone;
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String pwd;
    private String nickname;
	
	public Admin() {
		super();
	}
    
}
