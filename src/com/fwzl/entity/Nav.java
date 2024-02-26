package com.fwzl.entity;

//导航栏
public class Nav {
   
	private Integer id;    
    
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	


	public Nav(Integer id, String name, String url, String note,Integer px) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.note = note;
		this.px=px;
	}




	public Integer getPx() {
		return px;
	}


	public void setPx(Integer px) {
		this.px = px;
	}




	private Integer px;
	private String name;
   
	private String url;
	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	private String note;//路径说明
   
	
	public Nav() {
		super();
	}
    
}
