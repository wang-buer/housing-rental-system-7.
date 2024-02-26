package com.fwzl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.Landloard;
import com.fwzl.service.LandloardService;
import com.fwzl.service.impl.LandloardServiceImpl;
import com.fwzl.utils.WebUtils;

/**
 *处理房东的请求
 */
@WebServlet("/LandloardServlet")
public class LandloardServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private LandloardService service=new LandloardServiceImpl();
      
	//分页
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码
     
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Landloard> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("landloardList",list); //绑定参数
        int nums=service.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/landloard/landloard_list.jsp").forward(request,response); //页面转发

    }

		
	//添加房东信息
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");     
     
        if(service.existsPhone(phone)){
            request.setAttribute("msg","该手机号已注册");
            request.setAttribute("phone",phone);
            request.setAttribute("realname",realname);
            request.getRequestDispatcher("/WEB-INF/landloard/add_landloard.jsp").forward(request,response);//返回到登陆界面
        }else {
        	try {
            service.addLandloard(new Landloard(null,phone,realname,pwd,sex,null));
        	}catch(Exception e) {};
            response.sendRedirect(request.getContextPath()+"/LandloardServlet?action=list");//重定向防止重复提交哦

        }
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Landloard landloard=service.findById(id);
         request.setAttribute("record",landloard);      
         request.getRequestDispatcher("/WEB-INF/landloard/edit_landloard.jsp").forward(request,response);
    }

     //查询房东个人信息
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询个人信息
    	int l_id=WebUtils.parseInt(request.getParameter("l_id"),0);
        Landloard landloard=service.findById(l_id);
        request.setAttribute("landloard",landloard);
        System.out.println(landloard);
        request.getRequestDispatcher("/WEB-INF/landloard/landloard_info.jsp").forward(request,response);
    }

    //编辑房东信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String type=(String) request.getSession().getAttribute("type");
        System.out.print(type+sex+">>>>>>>>>>>>>>>");
        //Landloard landloard=(Landloard) request.getSession().getAttribute("landloard");
        if (type.equals("2")) {
            service.updateLandloard(new Landloard(id,phone,realname,pwd,sex,null));
           
            response.sendRedirect(request.getContextPath()+"/LandloardServlet?action=findMyInfo&l_id="+id);//重定向防止重复提交哦
        }else {
            service.updateLandloard(new Landloard(id,phone,realname,pwd,sex,null));
            response.sendRedirect(request.getContextPath()+"/LandloardServlet?action=list");//重定向防止重复提交哦
        }



    }
    //管理员修改
    protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");      
     service.updateLandloard(new Landloard(id,phone,realname,pwd,sex,null));
    response.sendRedirect(request.getContextPath()+"/LandloardServlet?action=list");//重定向防止重复提交哦
    }
    //删除房东信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteLandloard(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/LandloardServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据手机号和姓名查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询
        String phone=request.getParameter("phone");
        String realname=request.getParameter("realname");
        List<Landloard> list=service.findByMap(phone,realname);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/landloard/list_landloard.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/landloard/list_landloard.jsp").forward(request, response);
        }
    }

    
  //跳转到添加房东界面
    protected void toAddLandloard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/landloard/add_landloard.jsp").forward(request,response);
    }
	

}
