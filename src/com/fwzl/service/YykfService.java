package com.fwzl.service;

import java.util.List;

import com.fwzl.entity.Yykf;

public interface YykfService {
	
    int addYykf(Yykf record);//添加
    int updateStatus(Yykf record);//修改
    List<Yykf> getPage(int pageNum, int pageSize);//f分页查询
    List<Yykf> findMyYykf(int a_id,int pageNum, int pageSize);//f分页查询
    List<Yykf> findByPhone(String phone);//条件查询
    List<Yykf> findByMap1(String a_id,String phone,String status);//条件查询
    List<Yykf> findByMap2(String phone,int status);//条件查询
    int queryCount();//统计数量
    int deleteYykf(Integer id);//根据id删除
    int deleteYykfByHid(Integer h_id);//根据h_id删除
}
