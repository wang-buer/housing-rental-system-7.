package com.fwzl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fwzl.dao.YykfDao;
import com.fwzl.entity.Yykf;
import com.fwzl.utils.C3p0Utils;

//预约看房
public class YykfDaoImpl implements YykfDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    

  
    //分页查询
    public List<Yykf> getPage(int pageNum, int pageSize) {
        String sql="select * from yykf limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Yykf> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Yykf>(Yykf.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //查询我的预约看房记录
    public List<Yykf> findByPhone(String phone) {
        String sql="select * from yykf where 1=1 ";
        List<Yykf> list=null;
        //todo 使用JavaBean对象的list集合的实现类 BeanListHandler类封装
        List<String> list1 = new ArrayList<String>();
        if (phone != "") {         
            sql += " and phone =  ? ";
            //将用户输入的参数添加到集合
            list1.add(phone );
        }       
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql,params, new BeanListHandler<Yykf>(Yykf.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
		List<Yykf> list=new YykfDaoImpl().findByPhone("17766091168");
		System.out.print(list.size());
	}

    
    //统计数量
    public int queryCount() {
        String sql="select count(*) from yykf";
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
            runner.update("delete from yykf where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	

	@Override
	public int save(Yykf record) {
		 try {
	            //执行插入sql
	            runner.update("insert into yykf(phone,h_id,a_id,status,create_time) values (?,?,?,?,now())",
	                  record.getPhone(),record.getH_id(),record.getA_id(),record.getStatus());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}

	

	@Override
	public int update(Yykf record) {
		
		 try {//执行修改
	            runner.update("update yykf set status=? where id=?",
	            		record.getStatus(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}


	@Override
	public int delete2(Integer h_id) {
		// TODO Auto-generated method stub
		   try {
	            //执行删除的sql
	            runner.update("delete from yykf where h_id=?",h_id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }

	        return 1;//删除成功返回1表示结束
	}


	@Override
	public List<Yykf> getPage2(int a_id,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
	    String sql="select * from yykf where a_id=? limit ?,? ";
        int startNo=(pageNum-1)*pageSize;
        List<Yykf> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Yykf>(Yykf.class),new Object[] {a_id,startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


	@Override
	public List<Yykf> findByMap1(String a_id, String phone, String status) {
		// TODO Auto-generated method stub
		 String sql="select * from yykf where 1=1 ";
	        List<Yykf> list=null;
	        //todo 使用JavaBean对象的list集合的实现类 BeanListHandler类封装
	        List<String> list1 = new ArrayList<String>();
	        if (a_id!=null) {         
	            sql += " and a_id =  ? ";
	            //将用户输入的参数添加到集合
	            list1.add(a_id );
	        }       
	        if (phone != "") {         
	            sql += "and phone like  ? ";
	            //将用户输入的参数添加到集合
	            list1.add("%"+phone +"%");
	        }   
	        if (status!= "") {         
	            sql += "and status like  ? ";
	            //将用户输入的参数添加到集合
	            list1.add(status );
	        }   
	        Object[] params = list1.toArray();
	        try {
	            list=runner.query(sql,params, new BeanListHandler<Yykf>(Yykf.class));
	            System.out.println(list.size());
	            return list;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}


	@Override
	public List<Yykf> findByMap2(String phone, int status) {
		// TODO Auto-generated method stub
		String sql="select * from yykf where phone=? and status=? ";      
        List<Yykf> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Yykf>(Yykf.class),new Object[] {phone,status});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	





	
    
   
	
}
