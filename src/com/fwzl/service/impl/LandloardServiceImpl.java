package com.fwzl.service.impl;

import java.util.List;
import java.util.Map;

import com.fwzl.dao.LandloardDao;
import com.fwzl.dao.impl.LandloardDaoImpl;
import com.fwzl.entity.Landloard;
import com.fwzl.service.LandloardService;

public class LandloardServiceImpl implements LandloardService {
	private LandloardDao dao =new LandloardDaoImpl();

	public Landloard login(String phone, String pwd) {
		// TODO Auto-generated method stub
		return dao.queryByPhoneAndPwd(phone, pwd);
	}

	@Override
	public int addLandloard(Landloard record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	@Override
	public Landloard findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	@Override
	public int updateLandloard(Landloard record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	@Override
	public List<Landloard> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	@Override
	public List<Landloard> findByMap(String phone, String realname) {
		// TODO Auto-generated method stub
		return dao.findByMap(phone, realname);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public int deleteLandloard(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	

	@Override
	public boolean existsPhone(String phone) {
		// TODO Auto-generated method stub
		   if(dao.queryByPhone(phone)==null){
	            return false;//表示不可以用
	        }
	        return true;//表示可以用
	}

	

}
