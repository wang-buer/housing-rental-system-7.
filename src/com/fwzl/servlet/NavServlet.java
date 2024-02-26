package com.fwzl.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwzl.entity.Nav;
import com.fwzl.service.NavService;
import com.fwzl.service.impl.NavServiceImpl;
import com.fwzl.utils.WebUtils;

/**
 *处理导航栏的请求
 */
@WebServlet("/NavServlet")
public class NavServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private NavService service=new NavServiceImpl();
      
	//分页查询导航栏信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Nav> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("navList",list); //绑定参数
        int nums=service.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/nav/nav_list.jsp").forward(request,response); //页面转发
    }
	
	//添加导航栏
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
        String name=request.getParameter("name");
        String url=request.getParameter("url");    
        String note=request.getParameter("note");  
        int px=Integer.parseInt(request.getParameter("px"));
        if(service.queryCount()>=8) {
        	   request.setAttribute("msg","最大导航栏数量为8!");      
               request.getRequestDispatcher("/WEB-INF/nav/add_nav.jsp").forward(request,response);
        }
        if(service.existsPx(px)) {
        	  request.setAttribute("msg","排序号存在了啊");      
              request.getRequestDispatcher("/WEB-INF/nav/add_nav.jsp").forward(request,response);
        }
        try {
            service.addNav(new Nav(null,name,url,note,px));
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/NavServlet?action=list");//重定向防止重复提交
        
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Nav nav=service.findById(id);
         request.setAttribute("nav",nav);      
         request.getRequestDispatcher("/WEB-INF/nav/edit_nav.jsp").forward(request,response);
    }

   
    //编辑导航栏信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String name=request.getParameter("name");
        String url=request.getParameter("url");    
        String note=request.getParameter("note");   
        int px=Integer.parseInt(request.getParameter("px"));
        try {
            service.updateNav(new Nav(id,name,url,note,px));
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/NavServlet?action=list");//重定向防止重复提交



    }
    //删除导航栏信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteNav(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/NavServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Nav> list=service.findByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/nav/list_nav.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/nav/list_nav.jsp").forward(request, response);
        }
    }
    //查询所有的导航栏
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<Nav> list=service.findAll();
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request, response);
        }else {      
            request.setAttribute("navList" ,list);
            request.getRequestDispatcher("/WEB-INF/nav/webiste.jsp").forward(request, response);
        }
    }

    
  //跳转到添加导航栏
    protected void toAddNav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/nav/add_nav.jsp").forward(request,response);
    }
	

}
