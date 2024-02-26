package com.fwzl.service.impl;

import java.util.List;
import java.util.Map;

import com.fwzl.dao.GzfyDao;
import com.fwzl.dao.impl.GzfyDaoImpl;
import com.fwzl.entity.Gzfy;
import com.fwzl.service.GzfyService;
//关注房源业务层
public class GzfyServiceImpl implements GzfyService {
	private GzfyDao dao =new GzfyDaoImpl();

	@Override
	public int addGzfy(Gzfy record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}


	
	@Override
	public List<Gzfy> findMyGzfy(String phone) {
		// TODO Auto-generated method stub
		return dao.findMyGzfy(phone);
	}

	@Override
	public int deleteGzfy(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}



	@Override
	public List<Map<String, Object>> findMyGzByMap(String phone) {
		// TODO Auto-generated method stub
		return dao.findMyGzByMap(phone);
	}

	

}
