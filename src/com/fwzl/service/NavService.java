package com.fwzl.service;

import java.util.List;

import com.fwzl.entity.Nav;

public interface NavService {
	
	    int addNav(Nav record);//添加
	    Nav findById(Integer id);//根据id查询
	    int updateNav(Nav record);//修改
	    List<Nav> getPage(int pageNum, int pageSize);//分页查询
	    List<Nav> findByMap(String name);//条件查询
	    int queryCount();//统计数量
	    int deleteNav(Integer id);//根据id数量
	    List<Nav> findAll();//查询所有
	    boolean existsPx(Integer px);//判断排序号是否已经存在
}
