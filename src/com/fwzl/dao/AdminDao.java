package com.fwzl.dao;

import com.fwzl.entity.Admin;


public interface AdminDao {
    public Admin queryByPhoneAndPwd(String phone, String pwd);//根据管理员手机号和密码来登录
    public int update(Admin record);//根据id数量
    public Admin query(Integer id);//根据id查询
}
