package com.fwzl.service;

import com.fwzl.entity.Admin;

public interface AdminService {
    public Admin login(String phone,String pwd);//管理员登陆
    public int updateAdmin(Admin record);//管理员修改密码
    public Admin findById(Integer id);//根据id查询管理员信息
}
