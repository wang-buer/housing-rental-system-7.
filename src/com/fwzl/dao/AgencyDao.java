package com.fwzl.dao;

import java.util.List;

import com.fwzl.entity.Agency;

public interface AgencyDao {
  
    int save(Agency record);//添加
    Agency query(Integer id);//根据id查询 
    Agency queryByPhone(String phone);
    int update(Agency record);//修改
    int update2(Agency record);//修改
    List<Agency> getPage(int pageNum, int pageSize);//f分页查询
    List<Agency> findAll();//查询所有
    List<Agency> findByMap(String agentstore,String phone);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    Agency queryByPhoneAndPwd(String phone, String pwd);//根据手机号和密码来登录
}
   
