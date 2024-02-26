package com.fwzl.service;

import java.util.List;
import java.util.Map;

import com.fwzl.entity.Gzfy;

public interface GzfyService {	
	    int addGzfy(Gzfy record);//添加
	    List<Gzfy> findMyGzfy(String phone);//条件查
	    int deleteGzfy(Integer id);//根据id数量	 
	    List<Map<String, Object>> findMyGzByMap(String phone);//根据手机号查询
}
