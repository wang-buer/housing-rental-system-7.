package com.fwzl.service.impl;

import java.util.List;

import com.fwzl.dao.AgencyDao;
import com.fwzl.dao.impl.AgencyDaoImpl;
import com.fwzl.entity.Agency;
import com.fwzl.service.AgencyService;

public class AgencyServiceImpl implements AgencyService{
	private AgencyDao dao=new AgencyDaoImpl();

	@Override
	public int addAgency(Agency record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	@Override
	public Agency findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	@Override
	public boolean existsPhone(String phone) {
		// TODO Auto-generated method stub
		 if(dao.queryByPhone(phone)==null){
	            return false;//表示不可以用
	        }
	        return true;//表示可以用
	}

	@Override
	public int updateAgency(Agency record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	@Override
	public List<Agency> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	@Override
	public List<Agency> findByMap(String agentstore,String phone) {
		// TODO Auto-generated method stub
		return dao.findByMap(agentstore,phone);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public int deleteAgency(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<Agency> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int updateStatus(Agency record) {
		// TODO Auto-generated method stub
		return dao.update2(record);
	}

	@Override
	public Agency login(String phone, String pwd) {
		// TODO Auto-generated method stub
		return dao.queryByPhoneAndPwd(phone, pwd);
	}
		
	

	

}
