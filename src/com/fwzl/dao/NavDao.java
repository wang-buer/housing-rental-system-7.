package com.fwzl.dao;

import java.util.List;

import com.fwzl.entity.Nav;

public interface NavDao {
  
    int save(Nav record);//添加
    Nav query(Integer id);//根据id查询 
    Nav queryPx(Integer px);//根据px编号查询 
    int update(Nav record);//修改
    List<Nav> getPage(int pageNum, int pageSize);//f分页查询
    List<Nav> findAll();//查询所有
    List<Nav> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
