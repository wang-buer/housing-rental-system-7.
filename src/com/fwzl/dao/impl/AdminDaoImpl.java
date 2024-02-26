package com.fwzl.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fwzl.dao.AdminDao;
import com.fwzl.entity.Admin;
import com.fwzl.utils.C3p0Utils;


public class AdminDaoImpl implements AdminDao{

	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());

	
	//根据用户名和密码查询
	public Admin queryByPhoneAndPwd(String phone, String pwd) {
		 try {
	            return runner.query("select * from admin where phone=? and pwd=?", new BeanHandler<Admin>(Admin.class),phone,pwd);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}
	

	public int update(Admin record) {
		try {//执行更改
            runner.update("update admin set phone=?,pwd=?,nickname=? where id=?",
            		record.getPhone(),record.getPwd(),record.getNickname(),record.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
        return 1;
	}


	@Override
	public Admin query(Integer id) {
		// TODO Auto-generated method stub
		 try {
	            return runner.query("select * from admin where id=?", new BeanHandler<Admin>(Admin.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}
}
