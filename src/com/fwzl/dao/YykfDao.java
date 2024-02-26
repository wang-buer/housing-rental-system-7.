package com.fwzl.dao;

import java.util.List;

import com.fwzl.entity.Yykf;
//操作预约看房
public interface YykfDao {

    int save(Yykf record);//添加
    int update(Yykf record);//修改
    List<Yykf> getPage(int pageNum, int pageSize);//f分页查询
    List<Yykf> getPage2(int a_id,int pageNum, int pageSize);//f分页查询
    List<Yykf> findByPhone(String phone);//条件查询
    List<Yykf> findByMap1(String a_id,String phone,String status);//条件查询
    List<Yykf> findByMap2(String phone,int status);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    int delete2(Integer h_id);//根据id数量
}
   
