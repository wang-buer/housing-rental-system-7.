package com.fwzl.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fwzl.entity.Agency;
import com.fwzl.entity.Landloard;
import com.fwzl.entity.Nav;
import com.fwzl.service.AgencyService;
import com.fwzl.service.NavService;
import com.fwzl.service.impl.AgencyServiceImpl;
import com.fwzl.service.impl.NavServiceImpl;
import com.fwzl.utils.MyUtil;
import com.fwzl.utils.WebUtils;

import jdk.nashorn.internal.ir.Flags;

/**
 *处理中介的的请求
 */
@WebServlet("/AgencyServlet")
@MultipartConfig(maxFileSize = 20*1024*1024)
public class AgencyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AgencyService service=new AgencyServiceImpl();
	private NavService ns=new NavServiceImpl();
      
	//分页查询中介信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Agency> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("agencyList",list); //绑定参数
        int nums=service.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/agency/agency_list.jsp").forward(request,response); //页面转发
    }
	
	//添加中介
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加    	
    
		PrintWriter out = response.getWriter();		
		String flag=request.getParameter("flag");	 
		 response.setContentType("text/html;charset=utf-8");			
		Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
			String uploadfileDate = dateFormat.format(date);
			request.setCharacterEncoding("utf-8");
			Part part=request.getPart("resPath");
			String realname=request.getParameter("realname");	
			 String sex=request.getParameter("sex");	
			 String phone=request.getParameter("phone");	
			 String gznx=request.getParameter("gznx");
			 String note=request.getParameter("note");	
			 String cno=request.getParameter("cno");	
			 String education=request.getParameter("education");
			 String qq=request.getParameter("qq");	
			 String pwd=request.getParameter("pwd");	
			 String agentstore=request.getParameter("agentstore");	
			 System.out.println(realname+sex+phone);
			 Agency record=new Agency();
			 record.setStatus(0);
			 record.setRealname(realname);
			 record.setSex(sex);
			 record.setPhone(phone);
			 record.setGznx(gznx);
			 record.setNote(note);
			 record.setCno(cno);
			 record.setEducation(education);
			 record.setQq(qq);
			 record.setPwd(pwd);		 
			 record.setAgentstore(agentstore);
	
			File uploadFileDir = new File(WebUtils.getRealPath());
			if(!uploadFileDir.exists()) {
				uploadFileDir.mkdir();
			}
			String oldName = MyUtil.getFileName(part);
			record.setTx(uploadfileDate+"-"+oldName);
		
		   				
			
			if(oldName!=null) {
				part.write(uploadFileDir+File.separator+uploadfileDate+"-"+oldName);//写入文件
			
			}else {
				out.print("<script language='javascript'>alert('upload failed');"
				+"window.location.href='uploadHttpOne.jsp';</script>");
			}
			if(flag.equals("1")) {
				if(service.existsPhone(phone)) {
					 request.setAttribute("msg","该手机号已存在");
			         request.setAttribute("phone",phone);
			         request.setAttribute("realname",realname);
			         List<Nav> list=ns.findAll();
			         request.setAttribute("navList" ,list);
			         request.getRequestDispatcher("/WEB-INF/client/agency_registe.jsp").forward(request,response);//返回到登陆界面
				 }
				 record.setStatus(0);
				 service.addAgency(record);					
				 request.getRequestDispatcher("/WEB-INF/client/success.jsp").forward(request,response);
			}else if(flag.equals("2")){
				 record.setStatus(1);
				 if(service.existsPhone(phone)) {
					 request.setAttribute("msg","该手机号已存在");
			         request.setAttribute("phone",phone);
			         request.setAttribute("realname",realname);		       
			         request.getRequestDispatcher("/WEB-INF/agency/add_agency.jsp").forward(request,response);//返回到登陆界面
				 }
				service.addAgency(record);	
				response.sendRedirect(request.getContextPath()+"/AgencyServlet?action=list");//重定向防止重复提交
			}
			
	
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Agency agency=service.findById(id);
         request.setAttribute("agency",agency);      
         request.getRequestDispatcher("/WEB-INF/agency/edit_agency.jsp").forward(request,response);
    }

   
    //编辑中介信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String flag=request.getParameter("flag");	
        String realname=request.getParameter("realname");	
		 String sex=request.getParameter("sex");	
		 String phone=request.getParameter("phone");	
		 String gznx=request.getParameter("gznx");
		 String note=request.getParameter("note");	
		 String cno=request.getParameter("cno");	
		 String education=request.getParameter("education");
		 String qq=request.getParameter("qq");	
		 String pwd=request.getParameter("pwd");	
		 String agentstore=request.getParameter("agentstore");	
		 Agency record=new Agency();
		 record.setId(id);
		 record.setRealname(realname);
		 record.setSex(sex);
		 record.setPhone(phone);
		 record.setGznx(gznx);
		 record.setNote(note);
		 record.setCno(cno);
		 record.setEducation(education);
		 record.setQq(qq);
		 record.setPwd(pwd);		 
		 record.setAgentstore(agentstore);
       
        System.out.print("flag:"+flag);
        if(flag.equals("1")) {
        	 try {
                int b= service.updateAgency(record);
                System.out.print(b+"***********");
             }catch(Exception e) {};
        	Agency agency=service.findById(id);
             request.setAttribute("agency",agency);
             System.out.println(agency);
            		
             request.getRequestDispatcher("/WEB-INF/agency/agency_info.jsp").forward(request,response);
        	  //response.sendRedirect(request.getContextPath()+"/AgencyServlet?action=findMyInfo&a_id="+id);//重定向防止重复提交
        }else {
        	 try {
                 service.updateAgency(record);
             }catch(Exception e) {};
        	 response.sendRedirect(request.getContextPath()+"/AgencyServlet?action=list");//重定向防止重复提交
        }
       
    }
    
    //审核通过
    protected void pass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        Agency record=new Agency();
        record.setId(id);
        try {
            service.updateStatus(record);
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/AgencyServlet?action=list");//重定向防止重复提交



    }
    //删除中介信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteAgency(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/AgencyServlet?action=list"); //重定向防止重复提交哦
        }
      
    }
    //查看中介自己的信息
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询个人信息
    	int a_id=WebUtils.parseInt(request.getParameter("a_id"),0);
        Agency agency=service.findById(a_id);
        request.setAttribute("agency",agency);
        System.out.println(agency);
        request.getRequestDispatcher("/WEB-INF/agency/agency_info.jsp").forward(request,response);
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String agentstore=request.getParameter("agentstore");
        String phone=request.getParameter("phone");
        List<Agency> list=service.findByMap(agentstore,phone);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/agency/list_agency.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/agency/list_agency.jsp").forward(request, response);
        }
    }
    //查询所有房产经纪人
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<Agency> list=service.findAll();
    	List<Nav> list2=ns.findAll();
        request.setAttribute("navList" ,list2);
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/agency_list.jsp").forward(request, response);
        }else {      
            request.setAttribute("agencyList" ,list);
            request.getRequestDispatcher("/WEB-INF/client/agency_list.jsp").forward(request, response);
        }
    }

    
  //跳转到添加中介
    protected void toAddAgency(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/agency/add_agency.jsp").forward(request,response);
    }
	

}
