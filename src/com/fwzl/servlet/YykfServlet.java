package com.fwzl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.Agency;
import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;
import com.fwzl.entity.Landloard;
import com.fwzl.entity.Nav;
import com.fwzl.entity.User;
import com.fwzl.entity.Yykf;
import com.fwzl.service.AgencyService;
import com.fwzl.service.HouseService;
import com.fwzl.service.LandloardService;
import com.fwzl.service.NavService;
import com.fwzl.service.UserService;
import com.fwzl.service.YykfService;
import com.fwzl.service.impl.AgencyServiceImpl;
import com.fwzl.service.impl.HouseServiceImpl;
import com.fwzl.service.impl.LandloardServiceImpl;
import com.fwzl.service.impl.NavServiceImpl;
import com.fwzl.service.impl.UserServiceImpl;
import com.fwzl.service.impl.YykfServiceImpl;
import com.fwzl.utils.WebUtils;

/**
 *处理预约看房的请求
 */
@WebServlet("/YykfServlet")
public class YykfServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private YykfService service=new YykfServiceImpl();
	private UserService us=new UserServiceImpl();
	private NavService ns=new NavServiceImpl();
	private HouseService hs=new HouseServiceImpl();
	private AgencyService as=new AgencyServiceImpl();
	private LandloardService ls=new LandloardServiceImpl();

	//分页查询导航栏信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Yykf> yykfs=service.getPage(pageNum,pageSize);
        for(Yykf y:yykfs) {
        	House h=hs.findByHid(y.getH_id());
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	User user=us.findByPhone(y.getPhone());
        	Landloard landloard=ls.findById(h.getL_id());
        	y.setLandloard(landloard);
        	y.setImgs(imgs);
        	y.setUser(user);
        	y.setHouse(h);        	
          }      
        request.setAttribute("yykfList",yykfs); //绑定参数
        int nums=service.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/yykf/yykf_list.jsp").forward(request,response); //页面转发
    }
	
	//中介的预约清酒
	protected void yykfMe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        Agency agency=(Agency) request.getSession().getAttribute("agency");
        //调用分页查询
        List<Yykf> yykfs=service.findMyYykf(agency.getId(), pageNum, pageSize);
        //携带参数到页面
        for(Yykf y:yykfs) {
        	House h=hs.findByHid(y.getH_id());
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	User user=us.findByPhone(y.getPhone());
        	Landloard landloard=ls.findById(h.getL_id());
        	y.setLandloard(landloard);
        	y.setImgs(imgs);
        	y.setUser(user);
        	y.setHouse(h);        	
          }        
        //携带参数到页面
        request.setAttribute("yykfList",yykfs); //绑定参数
        int nums=service.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/yykf/agency_yykf_list.jsp").forward(request,response); //页面转发
    }
	
	//进行预约
    protected void addYykf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
    	User user=(User)request.getSession().getAttribute("user");
    	if(user!=null) {			
        Integer h_id=Integer.parseInt(request.getParameter("h_id"));    
        Integer a_id=Integer.parseInt(request.getParameter("a_id"));  
        System.out.println(h_id+"-"+a_id);
        try {
            service.addYykf(new Yykf(null,user.getPhone(),h_id,a_id,1,null));
        }catch(Exception e) {};
        List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
        List<Yykf> yykfs=service.findByPhone(user.getPhone());		
        for(Yykf y:yykfs) {
        	House h=hs.findById(y.getH_id());
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	Agency agency=as.findById(y.getA_id());
        	y.setImgs(imgs);
        	y.setAgency(agency);
        	y.setHouse(h);
        	
        }
        request.setAttribute("yykflist" ,yykfs);
    	request.getRequestDispatcher("/WEB-INF/client/my_yykf.jsp").forward(request,response);
    	}else {
    		PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='CommonServlet?action=toUserLogin'");
			out.write("</script>");
			out.close();	
    	}
    }
    
    //我的预约看房记录
    protected void myYykf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
        User user=(User)request.getSession().getAttribute("user");
		if(user!=null) {			
			  List<Yykf> yykfs=service.findByPhone(user.getPhone());			     
		        for(Yykf y:yykfs) {
		        	House h=hs.findById(y.getH_id());
		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
		        	Agency agency=as.findById(y.getA_id());
		        	y.setImgs(imgs);
		        	y.setAgency(agency);
		        	y.setHouse(h);
		        	
		        }
		        request.setAttribute("yykflist" ,yykfs);
		    	request.getRequestDispatcher("/WEB-INF/client/my_yykf.jsp").forward(request,response);
			
		}else {
			PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='CommonServlet?action=toUserLogin'");
			out.write("</script>");
			out.close();	
		}
      
	}

   
    //租客取消预约
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteYykf(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/YykfServlet?action=myYykf"); //重定向防止重复提交哦
        }
      
    }
     //管理员删除预约记录
    protected void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteYykf(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/YykfServlet?action=list"); //重定向防止重复提交哦
        }
      
    }
    //中介同意预约
    protected void agree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        Yykf record=new Yykf();
        record.setStatus(2);
        record.setId(id);
        int b=service.updateStatus(record);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/YykfServlet?action=yykfMe"); //重定向防止重复提交哦
        }
      
    }
//中介拒绝预约
    protected void disagree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        Yykf record=new Yykf();
        record.setStatus(0);
        record.setId(id);
        int b=service.updateStatus(record);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/YykfServlet?action=yykfMe"); //重定向防止重复提交哦
        }
      
    }
    //根据手机号查询
    protected void findByMap1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String phone=request.getParameter("phone");
        String a_id=request.getParameter("a_id");
        String status=request.getParameter("status");
        List<Yykf> list=service.findByMap1(a_id, phone, status);
        for(Yykf y:list) {
        	House h=hs.findByHid(y.getH_id());
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	User user=us.findByPhone(y.getPhone());
        	Landloard landloard=ls.findById(h.getL_id());
        	y.setLandloard(landloard);
        	y.setImgs(imgs);
        	y.setUser(user);
        	y.setHouse(h);        	
          }   
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/yykf/agency_yykf_list.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/yykf/agency_yykf_list.jsp").forward(request, response);
        }
    }
    
   //管理员端多条件查询
    protected void findByMap2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String phone=request.getParameter("phone");    
        String status=request.getParameter("status");
        List<Yykf> list=service.findByMap2(phone,Integer.parseInt(status));
        for(Yykf y:list) {
        	House h=hs.findByHid(y.getH_id());
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	User user=us.findByPhone(y.getPhone());
        	Landloard landloard=ls.findById(h.getL_id());
        	y.setLandloard(landloard);
        	y.setImgs(imgs);
        	y.setUser(user);
        	y.setHouse(h);        	
          }   
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/yykf/list_yykf.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/yykf/list_yykf.jsp").forward(request, response);
        }
    }
  
 

}
