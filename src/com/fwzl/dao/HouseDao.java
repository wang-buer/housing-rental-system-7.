package com.fwzl.dao;

import java.util.List;
import java.util.Map;

import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;

public interface HouseDao {
    int save(House record);//添加
    int save2(Imgs record);
    House query(Integer id);//根据id查询
    Imgs query2(Integer id);//根据id查询图片
    House query3(Integer h_id);//根据h_id查询
    
    int update(House record);//修改
    int update2(Imgs record);//修改图片
 
    List<Map<String, Object>> selectdoubleList(int pageNum, int pageSize);//分页多表查询
    List<Map<String, Object>> findHouseByMap(String xq,String address);//分页多表模糊查询
    List<Map<String, Object>> findMyHouse(Integer l_id);//查询房东的的房源。
    List<House> findByMap(String htype,String rtype);//条件查询
    List<Imgs> findByFwbh(String fwbh);//根据编号查询访问房屋的图片
    Imgs findByFwbh2(String fwbh);
    List<House> findAllHouse();//查询所有房源
    List<House> findAllHouseByMap(String title,String direction,String rtype,String style,String htype,String flag);//查询所有房源
    List<House> findAllHouseByPrice(String flag);//根据价格查询所有房源
    List<House> findAllHouseByPrice1(Integer price1,Integer price2);//根据价格范围查询所有房源
    List<House> findAllHouseByArea(String area);//根据房子面积查询所有房源
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    int delete2(Integer id);//删除图片id数量
    int delete3(String  fwbh);//删除图片
    int count2syt();//统计两室一厅
    int count1syt();//统计1室一厅
    int count3syt();//统计三室一厅
    int count4syt();//统计四室一厅
    int count4s2t();//统计四室2厅
    int countJzx();//统计精装修
    int countPtzx();//统计普通装修
    int countMpf();//统计毛坯房
    int countQt();//统计其他
    List<House> selectAllById(Integer id);//批量查询
}
   
