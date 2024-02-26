package com.fwzl.dao;

import java.util.List;

import com.fwzl.entity.User;

public interface UserDao {
  
    User queryByPhoneAndPwd(String phone, String pwd);//根据手机号和密码来登录
    int save(User record);//添加
    User query(Integer id);//根据id查询
    User queryByPhone(String phone);//根据手机号查询
    int update(User record);//修改
    List<User> getPage(int pageNum, int pageSize);//f分页查询
    List<User> findByMap(String phone,String realname);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
