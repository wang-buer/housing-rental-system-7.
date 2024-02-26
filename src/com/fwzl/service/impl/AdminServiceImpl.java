package com.fwzl.service.impl;


import com.fwzl.dao.AdminDao;
import com.fwzl.dao.impl.AdminDaoImpl;
import com.fwzl.entity.Admin;
import com.fwzl.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao=new AdminDaoImpl();

	

	
	public int updateAdmin(Admin record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}


	public Admin login(String phone, String pwd) {
		// TODO Auto-generated method stub
		return dao.queryByPhoneAndPwd(phone, pwd);
	}


	@Override
	public Admin findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

}
