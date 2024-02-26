package com.fwzl.entity;

//中介
public class Agency {
   
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Agency(Integer id, String realname, String sex, String tx, String phone, String gznx, String note,
			String cno, String education, String qq, String pwd, int status, String agentstore) {
		super();
		this.id = id;
		this.realname = realname;
		this.sex = sex;
		this.tx = tx;
		this.phone = phone;
		this.gznx = gznx;
		this.note = note;
		this.cno = cno;
		this.education = education;
		this.qq = qq;
		this.pwd = pwd;
		this.status = status;
		this.agentstore = agentstore;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGznx() {
		return gznx;
	}

	public void setGznx(String gznx) {
		this.gznx = gznx;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAgentstore() {
		return agentstore;
	}

	public void setAgentstore(String agentstore) {
		this.agentstore = agentstore;
	}

	private Integer id;     
	private String realname;			
	private String sex;
	private String tx;
	private String phone;
	private String gznx;
	private String note;
	private String cno;
	private String education;
	private String qq;
	private String pwd;
	private int status;
	private String agentstore;
   
	public Agency() {
		super();
	}
    
}
