package com.fwzl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fwzl.entity.Agency;
import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;
import com.fwzl.entity.Landloard;
import com.fwzl.entity.Nav;
import com.fwzl.entity.User;
import com.fwzl.service.AdminService;
import com.fwzl.service.AgencyService;
import com.fwzl.service.HouseService;
import com.fwzl.service.LandloardService;
import com.fwzl.service.NavService;
import com.fwzl.service.UserService;
import com.fwzl.service.impl.AdminServiceImpl;
import com.fwzl.service.impl.AgencyServiceImpl;
import com.fwzl.service.impl.HouseServiceImpl;
import com.fwzl.service.impl.LandloardServiceImpl;
import com.fwzl.service.impl.NavServiceImpl;
import com.fwzl.service.impl.UserServiceImpl;
import com.sun.javafx.geom.Area;

/**
 * 处理公共的一些请求，比如页面之间的跳转等
 */
@WebServlet("/CommonServlet")
public class CommonServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as=new AdminServiceImpl();   
	private NavService ns=new NavServiceImpl();
	private HouseService hs=new HouseServiceImpl();
	private AgencyService service=new AgencyServiceImpl();
	private LandloardService ls=new LandloardServiceImpl();
	private UserService us=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //根据房屋面积查询
    protected void moreHouseFindByArea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
      	List<Nav> list=ns.findAll();
          request.setAttribute("navList" ,list);             
          String area=request.getParameter("area");        
          List<House> houses=hs.findAllHouseByArea(area);
          for(House h:houses) {
          	Imgs imgs=hs.findByFwbh2(h.getFwbh());
          	h.setImgs(imgs);
          	Agency agency=service.findById(h.getA_id());
          	Landloard landloard=ls.findById(h.getL_id());
          	h.setAgency(agency);
          	h.setLandloard(landloard);
          }
         
  		HttpSession session = request.getSession();	
  	
  		List<Integer> ids= (ArrayList<Integer>)session.getAttribute("ids");		
  		if(ids!=null) {		
  			List<House> lastlylist = null;
  			for(Integer id:ids) {
  				lastlylist=hs.selectAllById(id);
  			}
  			  for(House h:lastlylist) {
  		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
  		        	h.setImgs(imgs);
  		        	Agency agency=service.findById(h.getA_id());
  		        	Landloard landloard=ls.findById(h.getL_id());
  		        	h.setAgency(agency);
  		        	h.setLandloard(landloard);
  		        }
  			
  			request.setAttribute("lastlylist", lastlylist);
  		}
  				
          request.setAttribute("houseList" ,houses);
      	request.getRequestDispatcher("/WEB-INF/client/more_house.jsp").forward(request,response);
  	}
    //查看个人信息
    protected void toUpdateUserPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		User u=(User)request.getSession().getAttribute("user");
		if(u!=null) {
			User user=us.findById(u.getId());	
			List<Nav> list=ns.findAll();
	        request.setAttribute("navList" ,list);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/client/user_updatepwd.jsp").forward(request,response);
		}else {
			PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='CommonServlet?action=toUserLogin'");
			out.write("</script>");
			out.close();	
		}
		
	}
    //我的资料
    protected void toPersonInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		User u=(User)request.getSession().getAttribute("user");
		if(u!=null) {
			User user=us.findById(u.getId());	
			List<Nav> list=ns.findAll();
	        request.setAttribute("navList" ,list);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/client/user_info.jsp").forward(request,response);
		}else {
			PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='CommonServlet?action=toUserLogin'");
			out.write("</script>");
			out.close();	
		}
		
	}


    //更多房源
    protected void moreHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
        List<House> houses=hs.findAllHouse();     
        for(House h:houses) {
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	h.setImgs(imgs);
        	Agency agency=service.findById(h.getA_id());
        	Landloard landloard=ls.findById(h.getL_id());
        	h.setAgency(agency);
        	h.setLandloard(landloard);
        }
        

		HttpSession session = request.getSession();	
	
		List<Integer> ids= (ArrayList<Integer>)session.getAttribute("ids");		
		if(ids!=null) {		
			List<House> lastlylist = null;
			for(Integer id:ids) {
				lastlylist=hs.selectAllById(id);
			}
			  for(House h:lastlylist) {
		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
		        	h.setImgs(imgs);
		        	Agency agency=service.findById(h.getA_id());
		        	Landloard landloard=ls.findById(h.getL_id());
		        	h.setAgency(agency);
		        	h.setLandloard(landloard);
		        }
			
			request.setAttribute("lastlylist", lastlylist);
		}
		request.setAttribute("jzx", hs.countJzx());
		request.setAttribute("ptzx", hs.countPtzx());
		request.setAttribute("mpf", hs.countMpf());
		request.setAttribute("qt", hs.countQt());
		request.setAttribute("counts1", hs.count1syt());		
		request.setAttribute("counts2", hs.count2syt());
		request.setAttribute("counts3", hs.count3syt());
		request.setAttribute("counts4", hs.count4syt());
		request.setAttribute("counts5", hs.count4s2t());
	
        request.setAttribute("houseList" ,houses);
        System.out.print(hs.countJzx()+hs.countPtzx()+"**********");
    	request.getRequestDispatcher("/WEB-INF/client/more_house.jsp").forward(request,response);
	}
    //根据租金查询
    protected void moreHouse1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
      	List<Nav> list=ns.findAll();
          request.setAttribute("navList" ,list);             
          String flag=request.getParameter("flag");        
          List<House> houses=hs.findAllHouseByPrice(flag);
          for(House h:houses) {
          	Imgs imgs=hs.findByFwbh2(h.getFwbh());
          	h.setImgs(imgs);
          	Agency agency=service.findById(h.getA_id());
          	Landloard landloard=ls.findById(h.getL_id());
          	h.setAgency(agency);
          	h.setLandloard(landloard);
          }
         
  		HttpSession session = request.getSession();	
  	
  		List<Integer> ids= (ArrayList<Integer>)session.getAttribute("ids");		
  		if(ids!=null) {		
  			List<House> lastlylist = null;
  			for(Integer id:ids) {
  				lastlylist=hs.selectAllById(id);
  			}
  			  for(House h:lastlylist) {
  		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
  		        	h.setImgs(imgs);
  		        	Agency agency=service.findById(h.getA_id());
  		        	Landloard landloard=ls.findById(h.getL_id());
  		        	h.setAgency(agency);
  		        	h.setLandloard(landloard);
  		        }
  			
  			request.setAttribute("lastlylist", lastlylist);
  		}
  		request.setAttribute("counts1", hs.count1syt());		
		request.setAttribute("counts2", hs.count2syt());
		request.setAttribute("counts3", hs.count3syt());
		request.setAttribute("counts4", hs.count4syt());
		request.setAttribute("counts5", hs.count4s2t());
		request.setAttribute("counts6", hs.countJzx());
		request.setAttribute("ptzx", hs.countPtzx());
		request.setAttribute("mpf", hs.countMpf());
		request.setAttribute("qt", hs.countQt());
         request.setAttribute("houseList" ,houses);
      	request.getRequestDispatcher("/WEB-INF/client/more_house.jsp").forward(request,response);
  	}
    //根据租金范围查询房源
    protected void moreHouse3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
      	  List<Nav> list=ns.findAll();
          request.setAttribute("navList" ,list);   
          String xq=request.getParameter("xq");     String price1=request.getParameter("price1");
          String price2=request.getParameter("price2");        
          System.out.print("租金1："+price1+"-租金2："+price2);
          List<House> houses=hs.findAllHouseByPrice1(Integer.parseInt(price1), Integer.parseInt(price2));
          for(House h:houses) {
          	Imgs imgs=hs.findByFwbh2(h.getFwbh());
          	h.setImgs(imgs);
          	Agency agency=service.findById(h.getA_id());
          	Landloard landloard=ls.findById(h.getL_id());
          	h.setAgency(agency);
          	h.setLandloard(landloard);
          }         
  		HttpSession session = request.getSession();	  	
  		List<Integer> ids= (ArrayList<Integer>)session.getAttribute("ids");		
  		if(ids!=null) {		
  			List<House> lastlylist = null;
  			for(Integer id:ids) {
  				lastlylist=hs.selectAllById(id);
  			}
  			  for(House h:lastlylist) {
  		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
  		        	h.setImgs(imgs);
  		        	Agency agency=service.findById(h.getA_id());
  		        	Landloard landloard=ls.findById(h.getL_id());
  		        	h.setAgency(agency);
  		        	h.setLandloard(landloard);
  		        }
  			
  			request.setAttribute("lastlylist", lastlylist);
  		}
  		request.setAttribute("counts1", hs.count1syt());		
		request.setAttribute("counts2", hs.count2syt());
		request.setAttribute("counts3", hs.count3syt());
		request.setAttribute("counts4", hs.count4syt());
		request.setAttribute("counts5", hs.count4s2t());	
		request.setAttribute("jzx", hs.countJzx());
		request.setAttribute("ptzx", hs.countPtzx());
		request.setAttribute("mpf", hs.countMpf());
		request.setAttribute("qt", hs.countQt());
          request.setAttribute("houseList" ,houses);
      	request.getRequestDispatcher("/WEB-INF/client/more_house.jsp").forward(request,response);
  	}
  	
    //根据多条件查询
    protected void moreHouse2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
      	List<Nav> list=ns.findAll();
          request.setAttribute("navList" ,list);
          String title=request.getParameter("title");
          String direction=request.getParameter("direction");
          String rtype=request.getParameter("rtype");
          String htype=request.getParameter("htype");
          String style=request.getParameter("style");
          String flag=request.getParameter("flag");
          System.out.print(htype);
          List<House> houses=hs.findAllHouseByMap(title,direction,rtype,style,htype,flag); 
          for(House h:houses) {
          	Imgs imgs=hs.findByFwbh2(h.getFwbh());
          	h.setImgs(imgs);
          	Agency agency=service.findById(h.getA_id());
          	Landloard landloard=ls.findById(h.getL_id());
          	h.setAgency(agency);
          	h.setLandloard(landloard);
          }
         
  		HttpSession session = request.getSession();	
  	
  		List<Integer> ids= (ArrayList<Integer>)session.getAttribute("ids");		
  		if(ids!=null) {		
  			List<House> lastlylist = null;
  			for(Integer id:ids) {
  				lastlylist=hs.selectAllById(id);
  			}
  			  for(House h:lastlylist) {
  		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
  		        	h.setImgs(imgs);
  		        	Agency agency=service.findById(h.getA_id());
  		        	Landloard landloard=ls.findById(h.getL_id());
  		        	h.setAgency(agency);
  		        	h.setLandloard(landloard);
  		        }
  			
  			request.setAttribute("lastlylist", lastlylist);
  		}
  		request.setAttribute("counts1", hs.count1syt());		
		request.setAttribute("counts2", hs.count2syt());
		request.setAttribute("counts3", hs.count3syt());
		request.setAttribute("counts4", hs.count4syt());
		request.setAttribute("counts5", hs.count4s2t());
		request.setAttribute("jzx", hs.countJzx());
		request.setAttribute("ptzx", hs.countPtzx());
		request.setAttribute("mpf", hs.countMpf());
		request.setAttribute("qt", hs.countQt());
          request.setAttribute("houseList" ,houses);
      	request.getRequestDispatcher("/WEB-INF/client/more_house.jsp").forward(request,response);
  	}
  	
	
   //关于我们
    protected void toAbout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
      
    	request.getRequestDispatcher("/WEB-INF/client/about.jsp").forward(request,response);
	}
    //联系我们
    protected void toContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
    	request.getRequestDispatcher("/WEB-INF/client/contact_us.jsp").forward(request,response);
	}
    
    //申请房产中介
    protected void toAgencyRegiste(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
      
    	request.getRequestDispatcher("/WEB-INF/client/agency_registe.jsp").forward(request,response);
	}
    protected void welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request,response);
	}
    //去网站首页
    protected void toWebsite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
        List<House> houses=hs.findAllHouse();
       
        for(House h:houses) {
        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
        	h.setImgs(imgs);
        }
        request.setAttribute("houseList" ,houses);
    	request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request,response);
	}
    //去租客注册界面
    protected void toUserReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
    	request.getRequestDispatcher("/WEB-INF/client/user_reg.jsp").forward(request,response);
	}
    //去房东入驻界面
    protected void toLandLordReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
    	request.getRequestDispatcher("/WEB-INF/client/landloard_reg.jsp").forward(request,response);
	}
    //去中介入驻界面
    protected void toAgentReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
    	request.getRequestDispatcher("/WEB-INF/client/agent_reg.jsp").forward(request,response);
	}
    //跳转到登录界面
    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
	}
    //跳转用户登录界面
    protected void toUserLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
    	request.getRequestDispatcher("/WEB-INF/client/user_login.jsp").forward(request,response);
	}


	
}
