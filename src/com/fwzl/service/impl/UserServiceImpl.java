package com.fwzl.service.impl;

import java.util.List;

import com.fwzl.dao.UserDao;
import com.fwzl.dao.impl.UserDaoImpl;
import com.fwzl.entity.User;
import com.fwzl.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao =new UserDaoImpl();

	@Override
	public User login(String phone, String pwd) {
		// TODO Auto-generated method stub
		return dao.queryByPhoneAndPwd(phone, pwd);
	}

	@Override
	public int addUser(User record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	@Override
	public int updateUser(User record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	@Override
	public List<User> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	@Override
	public List<User> findByMap(String phone, String realname) {
		// TODO Auto-generated method stub
		return dao.findByMap(phone, realname);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	@Override
	public int deleteUser(Integer id) {
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

	@Override
	public User findByPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.queryByPhone(phone);
	}
	

}
