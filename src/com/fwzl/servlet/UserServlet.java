package com.fwzl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.User;
import com.fwzl.service.UserService;
import com.fwzl.service.impl.UserServiceImpl;
import com.fwzl.utils.WebUtils;

/**
 *处理租客请求
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();
      
	//分页
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码
     
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<User> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("userList",list); //绑定参数
        int nums=service.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/user/user_list.jsp").forward(request,response); //页面转发

    }

		
	//添加租客信息
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String nickname=request.getParameter("nickname");
      
     
        if(service.existsPhone(phone)){
            request.setAttribute("msg","该手机号已注册");
            request.setAttribute("phone",phone);
            request.setAttribute("realname",realname);
            request.getRequestDispatcher("/WEB-INF/user/add_user.jsp").forward(request,response);//返回到登陆界面
        }else {
        	try {
            service.addUser(new User(null,phone,realname,pwd,sex,nickname,null));
        	}catch(Exception e) {};
            response.sendRedirect(request.getContextPath()+"/UserServlet?action=list");//重定向防止重复提交哦

        }
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         User user=service.findById(id);
         request.setAttribute("record",user);      
         request.getRequestDispatcher("/WEB-INF/user/edit_user.jsp").forward(request,response);
    }

     //查询租客个人信息
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询个人信息
    	int id=WebUtils.parseInt(request.getParameter("id"),0);
        User user=service.findById(id);
        request.setAttribute("user",user);
        System.out.println(user);
        request.getRequestDispatcher("/WEB-INF/user/user_info.jsp").forward(request,response);
    }

    //编辑租客信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String nickname=request.getParameter("nickname");
        String type=request.getParameter("type");
        System.out.println(type);
        if (type.equals("1")) {
            service.updateUser(new User(id,phone,realname,pwd,sex,nickname,null));
            response.sendRedirect(request.getContextPath()+"/CommonServlet?action=toPersonInfo");//重定向防止重复提交哦
            
       /*     request.getRequestDispatcher("/WEB-INF/user/edit_success.jsp").forward(request,response);*/
            //response.sendRedirect(request.getContextPath()+"/UserServlet?action=findMyInfo&stuno="+stuno);//重定向防止重复提交哦
        }else {
            service.updateUser(new User(id,phone,realname,pwd,sex,nickname,null));
            response.sendRedirect(request.getContextPath()+"/UserServlet?action=list");//重定向防止重复提交哦
        }



    }
    
    //前台租客修改密码
    protected void updateUserPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);      
        String pwd=request.getParameter("pwd");      
        service.updateUser(new User(id,null,null,pwd,null,null,null));
        PrintWriter out = response.getWriter();			
		out.write("<script>");
		out.write("alert('修改成功！，请重新登录');");
		out.write("location.href='CommonServlet?action=loginOut'");
		out.write("</script>");
		out.close();	
  
   
    }
    //删除租客信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteUser(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/UserServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据手机号和姓名查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        List<User> list=service.findByMap(phone,realname);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/user/list_user.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/user/list_user.jsp").forward(request, response);
        }
    }

    
  //跳转到添加租客界面
    protected void toAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/user/add_user.jsp").forward(request,response);
    }
	

}
