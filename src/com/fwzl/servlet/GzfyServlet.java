package com.fwzl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.Agency;
import com.fwzl.entity.Gzfy;
import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;
import com.fwzl.entity.Landloard;
import com.fwzl.entity.Nav;
import com.fwzl.entity.User;
import com.fwzl.service.AdminService;
import com.fwzl.service.AgencyService;
import com.fwzl.service.GzfyService;
import com.fwzl.service.HouseService;
import com.fwzl.service.LandloardService;
import com.fwzl.service.NavService;
import com.fwzl.service.impl.AdminServiceImpl;
import com.fwzl.service.impl.AgencyServiceImpl;
import com.fwzl.service.impl.GzfyServiceImpl;
import com.fwzl.service.impl.HouseServiceImpl;
import com.fwzl.service.impl.LandloardServiceImpl;
import com.fwzl.service.impl.NavServiceImpl;
import com.fwzl.utils.WebUtils;

/**
 * 处理公共的一些请求，比如页面之间的跳转等
 */
@WebServlet("/GzfyServlet")
public class GzfyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as=new AdminServiceImpl();   
	private NavService ns=new NavServiceImpl();
	private HouseService hs=new HouseServiceImpl();
	private AgencyService service=new AgencyServiceImpl();
	private LandloardService ls=new LandloardServiceImpl();
	private GzfyService gs=new GzfyServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GzfyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //取消关注
	 protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
	        int id=WebUtils.parseInt(request.getParameter("id"),0);	      
	        int b=gs.deleteGzfy(id);
	        if(b==1) {
	        	  response.sendRedirect(request.getContextPath()+"/GzfyServlet?action=mygzfy"); //重定向防止重复提交哦
	        }
	      
	    }

    //我的关注房源
    protected void mygzfy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<Nav> list=ns.findAll();
        request.setAttribute("navList" ,list);
        User user=(User)request.getSession().getAttribute("user");
		if(user!=null) {
			
			  List<Gzfy> gzfies=gs.findMyGzfy(user.getPhone());
			     
		        for(Gzfy g:gzfies) {
		        	House h=hs.findById(g.getH_id());
		        	Imgs imgs=hs.findByFwbh2(h.getFwbh());
		        	g.setImgs(imgs);
		        	g.setHouse(h);
		        	
		        }
		        request.setAttribute("gzfylist" ,gzfies);
		    	request.getRequestDispatcher("/WEB-INF/client/my_gzfy.jsp").forward(request,response);
			
		}else {
			PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='CommonServlet?action=toUserLogin'");
			out.write("</script>");
			out.close();	
		}
      
	}
	
   
    //跳转到登录界面
    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
	}
    
    //关注房源
    protected void gzfy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int hid=Integer.parseInt(request.getParameter("hid"));
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null) {
			Gzfy record=new Gzfy();
			record.setPhone(user.getPhone());
			record.setH_id(hid);
			gs.addGzfy(record);
			
		}else {
			PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='CommonServlet?action=toUserLogin'");
			out.write("</script>");
			out.close();	
		}
		  response.sendRedirect(request.getContextPath()+"/GzfyServlet?action=mygzfy"); //重定向防止重复提交哦
    	/*request.getRequestDispatcher("/WEB-INF/client/login.jsp").forward(request,response);*/
	}


	
}
