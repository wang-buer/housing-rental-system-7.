package com.fwzl.dao;

import java.util.List;

import com.fwzl.entity.Landloard;

public interface LandloardDao {
  
    Landloard queryByPhoneAndPwd(String phone, String pwd);//根据手机号和密码来登录
    int save(Landloard record);//添加
    Landloard query(Integer id);//根据id查询
    Landloard queryByPhone(String phone);//根据手机号查询
    int update(Landloard record);//修改
    List<Landloard> getPage(int pageNum, int pageSize);//f分页查询
    List<Landloard> findByMap(String phone,String realname);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
