package com.fwzl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.fwzl.dao.GzfyDao;
import com.fwzl.entity.Gzfy;
import com.fwzl.utils.C3p0Utils;


public class GzfyDaoImpl implements GzfyDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());

 
   //查询我的房源
    public List<Gzfy> findMyGzfy(String phone) {
        String sql="select * from gzfy where 1=1 ";
        List<Gzfy> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (phone != "") {        
            sql += " and phone =  ? ";      
            list1.add(phone);
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Gzfy>(Gzfy.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

  
   //删除导航栏信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from gzfy where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	

	@Override
	public int save(Gzfy record) {
		 try {
	            //执行插入sql
	            runner.update("insert into gzfy(phone,h_id,gzsj) values (?,?,now())",
	                  record.getPhone(),record.getH_id());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	@Override
	public List<Map<String, Object>> findMyGzByMap(String phone) {
		// TODO Auto-generated method stub
		 String sql="select g.phone,g.gzsj, h.* from  gzfy g, house h where g.h_id=h.id ";
	      
	        List<Map<String, Object>> list=null;
	        List<String> list1 = new ArrayList<String>();
	       /* list1.add(startNo);
	        list1.add(pageSize);*/
	        if (phone != "") {	          
	            sql += " and phone =?";
	            list1.add( phone );
	        }
	       
	        Object[] params = list1.toArray();
	        try {
	            list= runner.query(sql, new MapListHandler(),params);//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	


	
    
   
	
}
