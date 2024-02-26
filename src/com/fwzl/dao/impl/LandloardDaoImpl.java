package com.fwzl.dao.impl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fwzl.dao.LandloardDao;
import com.fwzl.entity.Landloard;
import com.fwzl.utils.C3p0Utils;


public class LandloardDaoImpl implements LandloardDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    

  

    public static void main(String[] args) {
		/*LandloardDaoImpl daoImpl=new LandloardDaoImpl();*/
		/*daoImpl.save();*/
			
	}
 

    //分页查询
    public List<Landloard> getPage(int pageNum, int pageSize) {
        String sql="select * from landloard limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Landloard> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Landloard>(Landloard.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //查询租客信息
    public List<Landloard> findByMap(String phone,String realname) {
        String sql="select * from landloard where 1=1 ";
        List<Landloard> list=null;
        //todo 使用JavaBean对象的list集合的实现类 BeanListHandler类封装
        List<String> list1 = new ArrayList<String>();
        if (phone != "") {
          
            sql += " and phone like  ? ";
            //将用户输入的参数添加到集合
            list1.add("%" + phone + "%");
        }
        if (realname != "") {
            //如果用户输入的realname不为空，那需要进行字符串拼接
            sql += " and realname like  ? ";
            //将用户输入的参数添加到集合
            list1.add("%" + realname + "%");
        }
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Landloard>(Landloard.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计数量
    public int queryCount() {
        String sql="select count(*) from landloard";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除学生信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from landloard where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	

	@Override
	public Landloard queryByPhoneAndPwd(String phone, String pwd) {
		// 根据手机号和密码查询
		try {
            return runner.query("select * from landloard where phone=? and pwd=?", new BeanHandler<Landloard>(Landloard.class),phone,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}
	
	@Override
	public int save(Landloard record) {
		 try {
	            //执行插入sql
	            runner.update("insert into landloard(phone,realname,pwd,sex,createtime) values (?,?,?,?,now())",
	                  record.getPhone(),record.getRealname(),record.getPwd(),record.getSex());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}

	@Override
	public Landloard query(Integer id) {
		// TODO
		 try {//返回查询的信息
	            return runner.query("select * from landloard where id=?", new BeanHandler<Landloard>(Landloard.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	@Override
	public int update(Landloard record) {
		
		 try {//执行修改
	            runner.update("update landloard set phone=?, realname=?,pwd=?,sex=? where id=?",
	            		 record.getPhone(),record.getRealname(),record.getPwd(),record.getSex(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}


	@Override
	public Landloard queryByPhone(String phone) {
		// TODO Auto-generated method stub
		try {
            return runner.query("select * from landloard where phone=?", new BeanHandler<Landloard>(Landloard.class),phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}

	

    
   
	
}
