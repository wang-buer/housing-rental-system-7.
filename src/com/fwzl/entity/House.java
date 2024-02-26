package com.fwzl.entity;

import java.util.Date;


//房屋实体
public class House {
   
	public House() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getL_id() {
		return l_id;
	}
	public void setL_id(Integer l_id) {
		this.l_id = l_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFwbh() {
		return fwbh;
	}
	public void setFwbh(String fwbh) {
		this.fwbh = fwbh;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getHtype() {
		return htype;
	}
	public void setHtype(String htype) {
		this.htype = htype;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getFbrq() {
		return fbrq;
	}
	public void setFbrq(Date fbrq) {
		this.fbrq = fbrq;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	private Integer id;
	private Integer l_id;
	private Integer a_id;//关联外键
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	private String title;
	private String fwbh;//房屋编号
	private Integer price;//租赁价格
	private String htype;//房屋类型，比如三室一厅
	private String rtype;//租房形式，比如可整租、可合租、其他
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	private String direction;
	private String style;//装修风格
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	private Integer area;//房屋面积
	private String floor;//所在楼层
	private String xq;//小区
	public String getXq() {
		return xq;
	}
	public void setXq(String xq) {
		this.xq = xq;
	}
	private String address;//房屋位置
	private Landloard landloard;
	private Agency agency;
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	private Imgs imgs;

	
	public Imgs getImgs() {
		return imgs;
	}
	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}
	public Landloard getLandloard() {
		return landloard;
	}
	public void setLandloard(Landloard landloard) {
		this.landloard = landloard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String detail;
    private Date  fbrq;//创建日期
    private Integer status;

}
