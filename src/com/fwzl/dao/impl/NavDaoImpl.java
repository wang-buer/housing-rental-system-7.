package com.fwzl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fwzl.dao.NavDao;
import com.fwzl.entity.Nav;
import com.fwzl.utils.C3p0Utils;


public class NavDaoImpl implements NavDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    

  

  
    //分页查询
    public List<Nav> getPage(int pageNum, int pageSize) {
        String sql="select * from nav limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Nav> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Nav>(Nav.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询导航栏信息
    public List<Nav> findByMap(String name) {
        String sql="select * from nav where 1=1 ";
        List<Nav> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and name like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Nav>(Nav.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计数量
    public int queryCount() {
        String sql="select count(*) from nav";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除导航栏信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from nav where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	

	@Override
	public int save(Nav record) {
		 try {
	            //执行插入sql
	            runner.update("insert into nav(name,url,note,px) values (?,?,?,?)",
	                  record.getName(),record.getUrl(),record.getNote(),record.getPx());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}

	@Override
	public Nav query(Integer id) {
		// TODO
		 try {//返回查询的信息
	            return runner.query("select * from nav where id=?", new BeanHandler<Nav>(Nav.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	@Override
	public int update(Nav record) {
		
		 try {//执行修改
	            runner.update("update nav set name=?,url=?,note=?,px=? where id=?",
	            		record.getName(),record.getUrl(),record.getNote(),record.getPx(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}


	@Override
	public List<Nav> findAll() {
		// TODO Auto-generated method stub
		  String sql="select * from nav order by px asc ";	        
	        List<Nav> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Nav>(Nav.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public Nav queryPx(Integer px) {
		// TODO Auto-generated method stub
		 try {//返回查询的信息
	            return runner.query("select * from nav where px=?", new BeanHandler<Nav>(Nav.class),px);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}




	
    
   
	
}
