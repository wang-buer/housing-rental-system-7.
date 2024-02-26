package com.fwzl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fwzl.dao.HouseDao;
import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;
import com.fwzl.entity.Nav;
import com.fwzl.utils.C3p0Utils;

public class HouseDaoImpl implements HouseDao{
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
	
	@Override
	public int save(House record) {
		 try {
	            //执行插入sql
	            runner.update("insert into house(l_id,a_id,title,fwbh,price,htype,rtype,direction,style,area,floor,xq,address,detail,fbrq,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)",
	                  record.getL_id(),record.getA_id(),record.getTitle(),record.getFwbh(),record.getPrice(),record.getHtype(),record.getDirection(),record.getRtype(),record.getStyle(),record.getArea(),record.getFloor(),record.getXq(),record.getAddress(),record.getDetail(),record.getStatus());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	
	}

	@Override
	public House query(Integer id) {
		 try {//返回查询的信息
	            return runner.query("select * from house where id=?", new BeanHandler<House>(House.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	@Override
	public int update(House record) {
		 try {//执行修改
	            runner.update("update house set title=?,price=?,htype=?,rtype=?,direction=?,style=?,status=?,area=?,floor=?,detail=?,xq=?,address=?,a_id=? where id=?",
	            		 record.getTitle(),record.getPrice(),record.getHtype(),record.getRtype(),record.getDirection(),record.getStyle(),record.getStatus(),record.getArea(),record.getFloor(),record.getDetail(),record.getXq(),record.getAddress(),record.getA_id(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	       
		return 1;
	}
	@Override
	 public List<Map<String, Object>> selectdoubleList(int pageNum, int pageSize) {
	    	List<Map<String, Object>> list=null;
	    	   int startNo=(pageNum-1)*pageSize;
	    	 String sql="select h.*,l.realname,l.phone,a.agentstore  from house h ,landloard l,agency a where h.l_id=l.id and h.a_id=a.id limit ?,?";
	    	 try {
	             list= runner.query(sql, new MapListHandler(),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
	             return list;
	         } catch (SQLException e) {//捕获异常
	             throw new RuntimeException(e);//抛出运行异常
	         }
	    }

	
	@Override
	public List<House> findByMap(String htype, String rtype) {
		String sql="select * from house where 1=1 ";
        List<House> list=null;
        //todo 使用JavaBean对象的list集合的实现类 BeanListHandler类封装
        List<String> list1 = new ArrayList<String>();
        if (htype != "") {
          
            sql += " and htype =  ? ";
            //将用户输入的参数添加到集合
            /*list1.add("%" + phone + "%");*/
        }
        if (rtype != "") {
            //如果用户输入的realname不为空，那需要进行字符串拼接
            sql += " and rtype like  ? ";
            //将用户输入的参数添加到集合
           /* list1.add("%" + realname + "%");*/
        }
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<House>(House.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}

	@Override
	public int queryCount() {
		  String sql="select count(*) from house";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int delete(Integer id) {
		 try {
	            //执行删除的sql
	            runner.update("delete from house where id=?",id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }

	        return 1;//删除成功返回1表示结束
	}

	@Override
	public int save2(Imgs record) {
		 try {
	            //执行插入sql
	            runner.update("insert into imgs(fwbh,img_url) values (?,?)",
	                  record.getFwbh(),record.getImg_url());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}

	@Override
	public List<Imgs> findByFwbh(String fwbh) {
		// TODO Auto-generated method stub
		String sql="select * from imgs where 1=1 ";
        List<Imgs> list=null;
        //todo 使用JavaBean对象的list集合的实现类 BeanListHandler类封装
        List<String> list1 = new ArrayList<String>();
        if ( fwbh != "") {      
            sql += " and fwbh =  ? ";
            list1.add(fwbh);
        }     
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Imgs>(Imgs.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}

	@Override
	public int delete2(Integer id) {
		// TODO Auto-generated method stub
		 try {
	            //执行删除的sql
	            runner.update("delete from imgs where id=?",id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }

	        return 1;//删除成功返回1表示结束
	}

	@Override
	public List<Map<String, Object>> findHouseByMap(String xq, String address) {
		// TODO Auto-generated method stub
		 String sql="select h.*,l.realname,l.phone from house h ,landloard l where h.l_id=l.id ";
	      
	        List<Map<String, Object>> list=null;
	        List<String> list1 = new ArrayList<String>();
	       /* list1.add(startNo);
	        list1.add(pageSize);*/
	        if (xq != "") {	          
	            sql += " and xq like ?";
	            list1.add("%" + xq + "%");
	        }
	        if (address != "") {	          
	            sql += " and address like ?  ";	          
	           list1.add("%" + address + "%");
	        }
	    
	        Object[] params = list1.toArray();
	        try {
	            list= runner.query(sql, new MapListHandler(),params);//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	@Override
	public int delete3(String fwbh) {
		// TODO Auto-generated method stub
	 try {
            //执行删除的sql
            runner.update("delete from imgs where fwbh=?",fwbh);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
	}

	@Override
	public int update2(Imgs record) {
		// TODO Auto-generated method stub
		 try {//执行修改
	            runner.update("update imgs set img_url=? where id=?",
	            		record.getImg_url(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	       
		return 1;
	}

	@Override
	public Imgs query2(Integer id) {
		// TODO Auto-generated method stub
		 try {//返回查询的信息
	            return runner.query("select * from imgs where id=?", new BeanHandler<Imgs>(Imgs.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public Imgs findByFwbh2(String fwbh) {
		// TODO Auto-generated method stub
		 try {//返回查询的信息
	            return runner.query("select * from imgs where fwbh=? limit 0,1", new BeanHandler<Imgs>(Imgs.class),fwbh);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	@Override
	public List<House> selectAllById(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from house where id=? ";	        
		List<House> list=null;
		      try {
		            list= runner.query(sql, new BeanListHandler<House>(House.class),id);//添加实体类的适配器进行类的反射
		            return list;
		      } catch (SQLException e) {//捕获异常
		            throw new RuntimeException(e);//抛出运行异常
		  }
	}

	@Override
	public List<House> findAllHouse() {
		// TODO Auto-generated method stub
		List<House>  list=null;
		 try {
			
			  String sql="select * from house ";	
		      list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射			       
			  return list;	     	          
	      } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	  }
	}

	@Override
	public List<House> findAllHouseByMap(String title,String direction,String rtype,String style,String htype,String flag) {
		// TODO Auto-generated method stub
		List<House>  list=null;
		/* List<String> list1 = new ArrayList<String>();
	        if ( fwbh != "") {      
	            sql += " and fwbh =  ? ";
	            list1.add(fwbh);
	        }     */
		 try {
			 if(title!=null) {
					String sql="select * from house where title like ? ";	
					list= runner.query(sql, new BeanListHandler<House>(House.class),"%"+title+"%");//添加实体类的适配器进行类的反射

				}
			 else if(direction!=null) {
				String sql="select * from house where direction=? ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class),direction);//添加实体类的适配器进行类的反射

			}else if(rtype!=null) {
				String sql="select * from house where rtype=? ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class),rtype);//添加实体类的适配器进行类的反射

			}else if(style!=null) {
				String sql="select * from house where style=? ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class),style);//添加实体类的适配器进行类的反射

			}else if(htype!=null) {
				String sql="select * from house where htype=? ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class),htype);//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("1")) {
				String sql="select * from house order by price asc ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("2")) {
				String sql="select * from house order by id desc ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else {
				String sql="select * from house ";	
		        list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}	        
			  return list;	     	          
	      } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	  }
	}
	
	@Override
	public List<House> findAllHouseByPrice(String flag) {
		// TODO Auto-generated method stub
		List<House>  list=null;
		 try {
			 if(flag!=null&&flag.equals("0")) {
					String sql="select * from house where price <500";	
					list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("1")) {
				String sql="select * from house where price between 500 and 1000";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("2")) {
				String sql="select * from house where price between 1001 and 2000 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("3")) {
				String sql="select * from house where price between 2001 and 3000 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("4")) {
				String sql="select * from house where price between 3001 and 4000 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("5")) {
				String sql="select * from house where price between 4001 and 5000 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(flag!=null&&flag.equals("6")) {
				String sql="select * from house where price >5000 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else {
				String sql="select * from house ";	
		        list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}	        
			  return list;	     	          
	      } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	  }
	}

	@Override
	public List<House> findAllHouseByPrice1(Integer price1, Integer price2) {
		// TODO Auto-generated method stub
		List<House>  list=null;
		 try {		
				 String sql="select * from house where price between ? and ? ";	
				 List<Integer> list1 = new ArrayList<Integer>();
			    list1.add(price1);
			     list1.add(price2);		      		    
				list= runner.query(sql, new BeanListHandler<House>(House.class),price1,price2);//添加实体类的适配器进行类的反射   
				return list;
			 
	      } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	  }
		
		
	}


	@Override
	public List<House> findAllHouseByArea(String area) {
		// TODO Auto-generated method stub
		List<House>  list=null;
		 try {
			 if(area!=null&&area.equals("1")) {
					String sql="select * from house where area <10";	
					list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射
			}else if(area!=null&&area.equals("2")) {
				String sql="select * from house where area between 11 and 30";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(area!=null&&area.equals("3")) {
				String sql="select * from house where area between 31 and 60 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(area!=null&&area.equals("4")) {
				String sql="select * from house where area between 61 and 80 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(area!=null&&area.equals("5")) {
				String sql="select * from house where area between 81 and 100 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else if(area!=null&&area.equals("6")) {
				String sql="select * from house where area >100 ";	
				list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}else {
				String sql="select * from house ";	
		        list= runner.query(sql, new BeanListHandler<House>(House.class));//添加实体类的适配器进行类的反射

			}	        
			  return list;	     	          
	      } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	}
	}

	@Override
	public List<Map<String, Object>> findMyHouse(Integer l_id) {
		// TODO Auto-generated method stub
		 String sql="select h.*,l.realname,l.phone from house h ,landloard l where h.l_id=l.id and l_id=? ";
	      
	        List<Map<String, Object>> list=null;
	     
	        try {
	            list= runner.query(sql, new MapListHandler(),l_id);//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}

	@Override
	public House query3(Integer h_id) {
		// TODO Auto-generated method stub
		try {//返回查询的信息
            return runner.query("select * from house where id=?", new BeanHandler<House>(House.class),h_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}

	@Override
	public int count2syt() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where htype='两室一厅'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int count1syt() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where htype='一室一厅'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int count3syt() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where htype='三室一厅'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int count4syt() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where htype='四室一厅'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int count4s2t() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where htype='四室两厅'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int countJzx() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where style='精装修'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int countPtzx() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where style='普通装修'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int countMpf() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where style='毛坯房'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public int countQt() {
		// TODO Auto-generated method stub
		 String sql="select count(*) from house where style='其他'";
	        try {
	            Long count =  (Long) runner.query(sql, new ScalarHandler());
	            //将long的类型转成int类型
	            return count.intValue();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	}


}
