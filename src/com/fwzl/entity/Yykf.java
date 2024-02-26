package com.fwzl.entity;

import java.util.Date;




//预约看房
public class Yykf {
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Yykf() {
		super();
	}
	public Integer getH_id() {
		return h_id;
	}
	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Yykf(Integer id, String phone, Integer h_id, Integer a_id, Integer status, Date create_time
			) {
		super();
		this.id = id;
		this.phone = phone;
		this.h_id = h_id;
		this.a_id = a_id;
		this.status = status;
		this.create_time = create_time;
	
	}
	private Integer id;				
	private String phone;
	private Integer h_id;
	private Integer a_id;
    private Integer status;
  
 	private Date  create_time;//预约时间
	private Imgs imgs;
	private Agency agency;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private User user;
	public Landloard getLandloard() {
		return landloard;
	}
	public void setLandloard(Landloard landloard) {
		this.landloard = landloard;
	}
	private Landloard landloard;
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	private House house;
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Imgs getImgs() {
		return imgs;
	}
	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}
	

}
