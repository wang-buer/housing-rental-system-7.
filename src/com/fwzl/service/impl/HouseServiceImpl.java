package com.fwzl.service.impl;

import java.util.List;
import java.util.Map;

import com.fwzl.dao.HouseDao;
import com.fwzl.dao.impl.HouseDaoImpl;
import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;
import com.fwzl.service.HouseService;

public class HouseServiceImpl implements HouseService {
	private HouseDao dao=new HouseDaoImpl();

	@Override
	public int addHouse(House record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	@Override
	public House findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	@Override
	public int updateHouse(House record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	

	@Override
	public List<House> findByMap(String htype, String rtype) {
		// TODO Auto-generated method stub
		return dao.findByMap(htype, rtype);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public int deleteHouse(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int addImgs(Imgs record) {
		// TODO Auto-generated method stub
		return dao.save2(record);
	}

	@Override
	public List<Map<String, Object>> selectdoubleList(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.selectdoubleList(pageNum, pageSize);
	}

	@Override
	public List<Imgs> findByFwbh(String fwbh) {
		// TODO Auto-generated method stub
		return dao.findByFwbh(fwbh);
	}

	@Override
	public int deleteImgs(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete2(id);
	}

	@Override
	public List<Map<String, Object>> findHouseByMap(String xq, String address) {
		// TODO Auto-generated method stub
		return dao.findHouseByMap(xq, address);
	}

	@Override
	public int deleteByFwbh(String fwbh) {
		// TODO Auto-generated method stub
		return dao.delete3(fwbh);
	}

	@Override
	public Imgs findImgsById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query2(id);
	}

	@Override
	public int updateImgs(Imgs record) {
		// TODO Auto-generated method stub
		return dao.update2(record);
	}

	@Override
	public List<House> findAllHouse() {
		// TODO Auto-generated method stub
		return dao.findAllHouse();
	}

	@Override
	public Imgs findByFwbh2(String fwbh) {
		// TODO Auto-generated method stub
		return dao.findByFwbh2(fwbh);
	}

	@Override
	public List<House> selectAllById(Integer  id) {
		// TODO Auto-generated method stub
		
		return dao.selectAllById(id);
	}

	@Override
	public List<House> findAllHouseByMap(String title,String direction,String rtype,String style,String htype,String flag) {
		// TODO Auto-generated method stub
		return dao.findAllHouseByMap(title,direction,rtype,style,htype,flag);
	}

	@Override
	public List<House> findAllHouseByPrice(String flag) {
		// TODO Auto-generated method stub
		return dao.findAllHouseByPrice(flag);
	}

	@Override
	public List<House> findAllHouseByPrice1(Integer price1, Integer price2) {
		// TODO Auto-generated method stub
		return dao.findAllHouseByPrice1(price1, price2);
	}

	@Override
	public List<House> findAllHouseByArea(String area) {
		// TODO Auto-generated method stub
		return dao.findAllHouseByArea(area);
	}

	@Override
	public List<Map<String, Object>> findMyHouse(Integer l_id) {
		// TODO Auto-generated method stub
		return dao.findMyHouse(l_id);
	}

	@Override
	public House findByHid(Integer h_id) {
		// TODO Auto-generated method stub
		return dao.query3(h_id);
	}

	@Override
	public int count2syt() {
		// TODO Auto-generated method stub
		return dao.count2syt();
	}

	@Override
	public int count1syt() {
		// TODO Auto-generated method stub
		return dao.count1syt();
	}

	@Override
	public int count3syt() {
		// TODO Auto-generated method stub
		return dao.count3syt();
	}

	@Override
	public int count4syt() {
		// TODO Auto-generated method stub
		return dao.count4syt();
	}

	@Override
	public int count4s2t() {
		// TODO Auto-generated method stub
		return dao.count4s2t();
	}

	@Override
	public int countJzx() {
		// TODO Auto-generated method stub
		return dao.countJzx();
	}

	@Override
	public int countPtzx() {
		// TODO Auto-generated method stub
		return dao.countPtzx();
	}

	@Override
	public int countMpf() {
		// TODO Auto-generated method stub
		return dao.countMpf();
	}

	@Override
	public int countQt() {
		// TODO Auto-generated method stub
		return dao.countQt();
	}

}
