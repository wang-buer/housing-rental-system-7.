package com.fwzl.entity;

public class Imgs {
	private Integer id;	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFwbh() {
		return fwbh;
	}
	public void setFwbh(String fwbh) {
		this.fwbh = fwbh;
	}
	public Imgs(Integer id, String fwbh, String img_url) {
		super();
		this.id = id;
		this.fwbh = fwbh;
		this.img_url = img_url;
	}
	public String getImg_url() {
		return img_url;
	}
	public Imgs() {
		super();
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	private String fwbh;
	private String img_url;

}
