package com.fwzl.service;

import java.util.List;

import com.fwzl.entity.User;

public interface UserService {
    User login(String phone, String pwd);//根据手机号和密码来登录
    int addUser(User record);//添加
    User findById(Integer id);//根据id查询
    int updateUser(User record);//修改
    List<User> getPage(int pageNum, int pageSize);//分页查询
    List<User> findByMap(String phone,String realname);//条件查询
    int queryCount();//统计数量
    int deleteUser(Integer id);//根据id数量
    User findByPhone(String phone);
    boolean existsPhone(String phone);//判断手机号是否已经注册
}
