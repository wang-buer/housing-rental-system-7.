package com.fwzl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fwzl.dao.AgencyDao;
import com.fwzl.entity.Agency;
import com.fwzl.utils.C3p0Utils;


public class AgencyDaoImpl implements AgencyDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    

  

  
    //分页查询
    public List<Agency> getPage(int pageNum, int pageSize) {
        String sql="select * from agency limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Agency> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Agency>(Agency.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询导航栏信息
    public List<Agency> findByMap(String agentstore,String phone) {
        String sql="select * from agency where 1=1 ";
        List<Agency> list=null;     
        List<String> list1 = new ArrayList<String>();
        if (agentstore != "") {         
            sql += " and agentstore like  ? ";       
            list1.add("%" + agentstore + "%");
        }  
        if (phone != "") {         
            sql += " and phone like  ? ";       
            list1.add("%" + phone + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Agency>(Agency.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计数量
    public int queryCount() {
        String sql="select count(*) from agency";
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
            runner.update("delete from agency where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

   
	@Override
	public int save(Agency record) {
		 try {
	            //执行插入sql
	            runner.update("insert into agency(realname,sex,tx,phone,gznx,note,cno,education,qq,pwd,status,agentstore) values (?,?,?,?,?,?,?,?,?,?,?,?)",
	                  record.getRealname(),record.getSex(),record.getTx(),record.getPhone(),record.getGznx(),record.getNote(),record.getCno(),record.getEducation(),record.getQq(),record.getPwd(),record.getStatus(),record.getAgentstore());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}

	@Override
	public Agency query(Integer id) {
		// TODO
		 try {//返回查询的信息
	            return runner.query("select * from agency where id=?", new BeanHandler<Agency>(Agency.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}
	

	@Override
	public int update(Agency record) {
		
		 try {//执行修改
	            runner.update("update agency set realname=?,sex=?,phone=?,gznx=?,note=?,cno=?,education=?,qq=?,pwd=?,agentstore=? where id=?",
	            		record.getRealname(),record.getSex(),record.getPhone(),record.getGznx(),record.getNote(),record.getCno(),record.getEducation(),record.getQq(),record.getPwd(),record.getAgentstore(),record.getId());
	        } catch (SQLException e) {
	        	e.printStackTrace();
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}


	@Override
	public List<Agency> findAll() {
		// TODO Auto-generated method stub
		  String sql="select * from agency ";	        
	        List<Agency> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Agency>(Agency.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public Agency queryByPhone(String phone) {
		// TODO Auto-generated method stub
		 try {//返回查询的信息
	            return runner.query("select * from agency where phone=?", new BeanHandler<Agency>(Agency.class),phone);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public int update2(Agency record) {
		// TODO Auto-generated method stub
		try {//执行修改
            runner.update("update agency set status=1 where id=?",
            		record.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
        return 1;
	}


	@Override
	public Agency queryByPhoneAndPwd(String phone, String pwd) {
		// TODO Auto-generated method stub
		 try {
	            return runner.query("select * from agency where phone=? and pwd=?", new BeanHandler<Agency>(Agency.class),phone,pwd);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}




	
    
   
	
}
