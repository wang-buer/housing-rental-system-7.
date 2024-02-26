package com.fwzl.dao;

import java.util.List;
import java.util.Map;

import com.fwzl.entity.Gzfy;
//关注房源Dao
public interface GzfyDao {  
    int save(Gzfy record);//添加
    List<Gzfy> findMyGzfy(String phone);//根据手机号查询  
    List<Map<String, Object>> findMyGzByMap(String phone);//根据手机号查询
    int delete(Integer id);//根据id删除
}
   
