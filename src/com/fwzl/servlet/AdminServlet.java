package com.fwzl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.Admin;
import com.fwzl.entity.User;
import com.fwzl.service.AdminService;
import com.fwzl.service.impl.AdminServiceImpl;
import com.fwzl.utils.WebUtils;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service=new AdminServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //查看个人信息
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询个人信息
    	int id=WebUtils.parseInt(request.getParameter("id"),0);
        Admin admin=service.findById(id);
        request.setAttribute("admin",admin);
        System.out.println(admin);
        request.getRequestDispatcher("/WEB-INF/admin/admin_info.jsp").forward(request,response);
    }
    
    //管理员修改密码
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String phone=request.getParameter("phone");      
        String pwd=request.getParameter("pwd");      
        String nickname=request.getParameter("nickname");
        Admin  admin=new Admin();
        admin.setId(id);
        admin.setNickname(nickname);
        admin.setPhone(phone);
        admin.setPwd(pwd);
        int b=service.updateAdmin(admin);
        if(b==1) {
        	 Admin record=service.findById(id);
             request.setAttribute("admin",record);
             System.out.println(admin);
             request.getRequestDispatcher("/WEB-INF/admin/admin_info.jsp").forward(request,response);
        }
       
    }
    



}
