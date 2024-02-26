package com.fwzl.service;

import java.util.List;

import com.fwzl.entity.Agency;

public interface AgencyService {
	
    int addAgency(Agency record);//添加
    Agency findById(Integer id);//根据id查询
    boolean existsPhone(String phone);//判断手机号是否已经注册
    int updateAgency(Agency record);//修改
    List<Agency> getPage(int pageNum, int pageSize);//分页查询
    List<Agency> findByMap(String agentstore,String phone);//条件查询
    int queryCount();//统计数量
    int deleteAgency(Integer id);//根据id数量
    List<Agency> findAll();//查询所有
    int updateStatus(Agency record);//通过
    Agency login(String phone, String pwd);//根据手机号和密码来登录
}
