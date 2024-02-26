package com.fwzl.service;

import java.util.List;
import java.util.Map;

import com.fwzl.entity.Landloard;

public interface LandloardService {
    Landloard login(String phone, String pwd);//根据手机号和密码来登录
    int addLandloard(Landloard record);//添加
    Landloard findById(Integer id);//根据id查询
    int updateLandloard(Landloard record);//修改
    List<Landloard> getPage(int pageNum, int pageSize);//分页查询
    List<Landloard> findByMap(String phone,String realname);//条件查询
    int queryCount();//统计数量
    int deleteLandloard(Integer id);//根据id数量
   
    boolean existsPhone(String phone);//判断手机号是否已经注册
}
