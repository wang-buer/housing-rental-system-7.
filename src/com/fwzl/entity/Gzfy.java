package com.fwzl.entity;

import java.util.Date;

//关注房源
public class Gzfy {
	private Integer id;			
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
	public Integer getH_id() {
		return h_id;
	}
	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}
	private String phone;
	private Integer h_id;
	private Date  gzsj;//创建日期
	private Imgs imgs;
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
	public Date getGzsj() {
		return gzsj;
	}
	public void setGzsj(Date gzsj) {
		this.gzsj = gzsj;
	}

}
