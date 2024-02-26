package com.fwzl.service.impl;

import java.util.List;

import com.fwzl.dao.YykfDao;
import com.fwzl.dao.impl.YykfDaoImpl;
import com.fwzl.entity.Yykf;
import com.fwzl.service.YykfService;

public class YykfServiceImpl implements YykfService {
	private YykfDao dao =new YykfDaoImpl();

	@Override
	public int addYykf(Yykf record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	

	@Override
	public List<Yykf> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	
	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public int deleteYykf(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int updateStatus(Yykf record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	@Override
	public List<Yykf> findByPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.findByPhone(phone);
	}



	@Override
	public int deleteYykfByHid(Integer h_id) {
		// TODO Auto-generated method stub
		return dao.delete2(h_id);
	}



	@Override
	public List<Yykf> findMyYykf(int a_id, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage2(a_id, pageNum, pageSize);
	}



	@Override
	public List<Yykf> findByMap1(String a_id, String phone, String status) {
		// TODO Auto-generated method stub
		return dao.findByMap1(a_id, phone, status);
	}



	@Override
	public List<Yykf> findByMap2(String phone, int status) {
		// TODO Auto-generated method stub
		return dao.findByMap2(phone, status);
	}


}
