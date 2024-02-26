package com.fwzl.service.impl;

import java.util.List;

import com.fwzl.dao.NavDao;
import com.fwzl.dao.impl.NavDaoImpl;
import com.fwzl.entity.Nav;
import com.fwzl.service.NavService;

public class NavServiceImpl implements NavService {
	private NavDao dao =new NavDaoImpl();

	@Override
	public int addNav(Nav record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	@Override
	public Nav findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	@Override
	public int updateNav(Nav record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	@Override
	public List<Nav> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	@Override
	public List<Nav> findByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public int deleteNav(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<Nav> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean existsPx(Integer px) {
		// TODO Auto-generated method stub
		 if(dao.queryPx(px)==null){
	            return false;//表示不可以用
	        }
	        return true;//表示可以用
	}

}
