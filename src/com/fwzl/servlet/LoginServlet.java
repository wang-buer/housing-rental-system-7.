package com.fwzl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.Admin;
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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as=new AdminServiceImpl();   
	private UserService us=new UserServiceImpl();
	private LandloardService ls=new LandloardServiceImpl();	
	private NavService ns=new NavServiceImpl();
	private HouseService hs=new HouseServiceImpl();
	private AgencyService service=new AgencyServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//处理登录
        String phone = request.getParameter("phone").trim();
        String pwd = request.getParameter("pwd").trim();
        int type=Integer.parseInt(request.getParameter("type").trim());
	       switch (type) {
	       case 1:
				User user=us.login(phone,pwd);
				System.out.println(phone+pwd+"type=1"+user);
				if(user==null){
					  request.setAttribute("msg","手机号或者或者密码错误"); //绑定参数
					  request.getRequestDispatcher("/WEB-INF/client/user_login.jsp").forward(request,response);
				}else {
					request.getSession().setAttribute("user", user);		
					request.getSession().setAttribute("type", "1");				
			        response.sendRedirect(request.getContextPath()+"/CommonServlet?action=toWebsite"); //重定向防止重复提交哦
				
				}
				break;
	       case 2:
				Landloard landloard=ls.login(phone,pwd);
				System.out.println(phone+pwd+"type=2"+landloard);
				if(landloard==null){
					  request.setAttribute("msg","房东手机号或者密码错误"); //绑定参数
					  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
				}else {
					request.getSession().setAttribute("landloard", landloard);		
					request.getSession().setAttribute("type", "2");
					request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
				}
				break;
	       case 3:
				Agency agency=service.login(phone, pwd);
				System.out.println(phone+pwd+"type=2"+agency);
				if(agency==null){
					  request.setAttribute("msg","中介手机号或者密码错误"); //绑定参数
					  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
				}else {
					request.getSession().setAttribute("agency", agency);		
					request.getSession().setAttribute("type", "3");
					request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
				}
				break;
			case 4:
				Admin admin=as.login(phone,pwd);
				System.out.println(phone+pwd+admin);
				if(admin==null){
					request.setAttribute("msg","手机号或者密码错误"); //绑定参数
					request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
				}else {
					request.getSession().setAttribute("admin", admin);		
					request.getSession().setAttribute("type", "4");
					request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);					
				}
				break;
        

	       }
    }
    
    protected void registe1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String nickname=request.getParameter("nickname");
      
     
        if(us.existsPhone(phone)){
            request.setAttribute("msg","该手机号已注册");
            request.setAttribute("phone",phone);
            request.setAttribute("realname",realname);
            request.getRequestDispatcher("/WEB-INF/client/user_reg.jsp").forward(request,response);//返回到登陆界面
        }else {
        	try {
            us.addUser(new User(null,phone,realname,pwd,sex,nickname,null));
        	}catch(Exception e) {};
        	request.getRequestDispatcher("/WEB-INF/client/success.jsp").forward(request,response);//返回到登陆界面

        }
    }
    
    protected void registe2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
  
        if(ls.existsPhone(phone)){
            request.setAttribute("msg","该手机号已注册");
            request.setAttribute("phone",phone);
            request.setAttribute("realname",realname);
            request.getRequestDispatcher("/WEB-INF/client/landloard_reg.jsp").forward(request,response);//返回到登陆界面
        }else {
        	try {
            ls.addLandloard(new Landloard(null,phone,realname,pwd,sex,null));
        	}catch(Exception e) {};
        	request.getRequestDispatcher("/WEB-INF/client/success.jsp").forward(request,response);//返回到登陆界面

        }
    }
    
    protected void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.getSession().invalidate();
    	request.getSession().removeAttribute("type");
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

	
}
