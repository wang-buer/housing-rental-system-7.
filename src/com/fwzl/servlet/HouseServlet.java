package com.fwzl.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.w3c.dom.ls.LSException;

import com.fwzl.entity.Agency;
import com.fwzl.entity.House;
import com.fwzl.entity.Imgs;
import com.fwzl.entity.Landloard;
import com.fwzl.entity.Nav;
import com.fwzl.service.AgencyService;
import com.fwzl.service.HouseService;
import com.fwzl.service.LandloardService;
import com.fwzl.service.NavService;
import com.fwzl.service.YykfService;
import com.fwzl.service.impl.AgencyServiceImpl;
import com.fwzl.service.impl.HouseServiceImpl;
import com.fwzl.service.impl.LandloardServiceImpl;
import com.fwzl.service.impl.NavServiceImpl;
import com.fwzl.service.impl.YykfServiceImpl;
import com.fwzl.utils.MyUtil;
import com.fwzl.utils.WebUtils;

/**
 *处理房屋的请求
 */
@WebServlet("/HouseServlet")
@MultipartConfig(maxFileSize = 20*1024*1024)
public class HouseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private YykfService service=new YykfServiceImpl();
	private LandloardService ls=new LandloardServiceImpl();	
	private HouseService hs=new HouseServiceImpl();
	private NavService ns=new NavServiceImpl();
	private AgencyService as=new AgencyServiceImpl();
	//查询房东的房子
	protected void findMyHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询
              
		Integer l_id=Integer.parseInt(request.getParameter("l_id"));
        List<Map<String, Object>> list=hs.findMyHouse(l_id);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此房源");
            request.getRequestDispatcher("/WEB-INF/house/landloard_house.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/house/landloard_house.jsp").forward(request, response);
        }
    }

	//多条件查询房源
	  protected void findHouseByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询
	        String xq=request.getParameter("xq");
	        String address=request.getParameter("address");
	        List<Map<String, Object>> list=hs.findHouseByMap(xq, address);
	        if(null == list || list.size() ==0 ){
	            request.setAttribute("msg" ,"无此信息");
	            request.getRequestDispatcher("/WEB-INF/house/list_house.jsp").forward(request, response);
	        }else {
	            request.removeAttribute("msg");
	            request.setAttribute("list" ,list);
	            request.getRequestDispatcher("/WEB-INF/house/list_house.jsp").forward(request, response);
	        }
	    }
	  
	  //删除房源图片
	 protected void deleteImgs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
	        int id=WebUtils.parseInt(request.getParameter("id"),0);
	        String fwbh=request.getParameter("fwbh");	  
	        int b=hs.deleteImgs(id);
	        if(b==1) {
	        	  response.sendRedirect(request.getContextPath()+"/HouseServlet?action=findAllImgs&fwbh="+fwbh); //重定向防止重复提交哦
	        }
	      
	    }
	//查看房屋图片
  protected void findAllImgs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询
	        String fwbh=request.getParameter("fwbh");	     
	        List<Imgs> list=hs.findByFwbh(fwbh);
	        if(null == list || list.size() ==0 ){
	            request.setAttribute("msg" ,"无此信息");
	            request.getRequestDispatcher("/WEB-INF/house/houseImgs_list.jsp").forward(request, response);
	        }else {
	            request.removeAttribute("msg");
	            request.setAttribute("list" ,list);
	            request.getRequestDispatcher("/WEB-INF/house/houseImgs_list.jsp").forward(request, response);
	        }
	}

      
	//后台分页展示房源信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Map<String, Object>> list=hs.selectdoubleList(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("houseList",list); //绑定参数
        int nums=hs.queryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/house/house_list.jsp").forward(request,response); //页面转发

    }
	
	//添加房源信息
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/*PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest)request;*/
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
		String uploadfileDate = dateFormat.format(date);
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");		
		int price =Integer.parseInt(request.getParameter("price"));
		int a_id =Integer.parseInt(request.getParameter("a_id"));
		String htype=request.getParameter("htype");
		String rtype=request.getParameter("rtype");
		String direction=request.getParameter("direction");
		String style=request.getParameter("style");
		
		int area =Integer.parseInt(request.getParameter("area"));
		String floor=request.getParameter("floor");
		String detail=request.getParameter("detail");
		String xq=request.getParameter("xq");
		String address=request.getParameter("address");
	
		Landloard landloard=(Landloard) request.getSession().getAttribute("landloard");
		
			House h=new House();
			h.setL_id(landloard.getId());
			h.setA_id(a_id);
			h.setTitle(title);
			h.setFwbh(uploadfileDate);
			h.setPrice(price);
			h.setHtype(htype);
			h.setDirection(direction);
			h.setRtype(rtype);
			h.setStyle(style);
			h.setArea(area);
			h.setFloor(floor);
			h.setDetail(detail);
			h.setXq(xq);
			h.setAddress(address);
			h.setStatus(0);
			hs.addHouse(h);			
		
		//File uploadFileDir = new File(request.getSession().getServletContext().getRealPath("/uploadFiles"));
		File uploadFileDir = new File(WebUtils.getRealPath());
		if(!uploadFileDir.exists()) {
			uploadFileDir.mkdir();
		}
		Collection<Part> parts = request.getParts();
		
		for(Part part:parts) {
		/*	int i=0;
			i++;*/
			if(part==null||!part.getName().contains("resPat")) {
				continue;
			}
			String oldName = MyUtil.getFileName(part);
			if(oldName!=null) {
				part.write(uploadFileDir+File.separator+uploadfileDate+"-"+oldName);
				Imgs record=new Imgs();
				record.setFwbh(uploadfileDate);
				record.setImg_url(uploadfileDate+"-"+oldName);
			   hs.addImgs(record);
			
			}				  
			
		}
		  response.sendRedirect(request.getContextPath()+"/HouseServlet?action=findMyHouse&l_id="+landloard.getId()); //重定向防止重复提交哦
		
	}
	
	//修改房源图片
	protected void updateImgs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");		
		request.setCharacterEncoding("utf-8");
		  int id=WebUtils.parseInt(request.getParameter("id"),0);   
		    String fwbh=request.getParameter("fwbh");
		//File uploadFileDir = new File(request.getSession().getServletContext().getRealPath("/uploadFiles"));
		File uploadFileDir = new File(WebUtils.getRealPath());
		if(!uploadFileDir.exists()) {
			uploadFileDir.mkdir();
		}
		Collection<Part> parts = request.getParts();
		
		for(Part part:parts) {
		
			if(part==null||!part.getName().contains("resPat")) {
				continue;
			}
			String oldName = MyUtil.getFileName(part);
			if(oldName!=null) {
				part.write(uploadFileDir+"\\"+oldName);
				Imgs record=new Imgs();
				record.setImg_url(oldName);
				record.setId(id);
			   hs.updateImgs(record);			
			}				  
			
		}
		response.sendRedirect(request.getContextPath()+"/HouseServlet?action=findAllImgs&fwbh="+fwbh); //重定向防止重复提交哦
	
		
	}


		
	

    	//根据id查询房源信息
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         House house=hs.findById(id);
         request.setAttribute("record",house);      
         List<Agency> agencyList=as.findAll();
         request.setAttribute("agencyList",agencyList);   
         request.getRequestDispatcher("/WEB-INF/house/edit_house.jsp").forward(request,response);
    }
      // 通过房源
     protected void pass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         House house=new House();
         house.setId(id);
         house.setStatus(1);
   	  response.sendRedirect(request.getContextPath()+"/HouseServlet?action=list"); //重定向防止重复提交哦
      
    }
     //查看房源详情
     protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         House house=hs.findById(id);
         Imgs imgs=hs.findByFwbh2(house.getFwbh());
         Landloard landloard=ls.findById(house.getL_id());
         house.setImgs(imgs);
         house.setLandloard(landloard);
         request.setAttribute("house",house);  
         Agency  agency=as.findById(house.getA_id());
         request.setAttribute("agency",agency);  
         List<Nav> list=ns.findAll();
         request.setAttribute("navList" ,list);
         List<House> houses=hs.findAllHouse();       
     	 request.getSession().setAttribute("ids", id);		
         for(House h:houses) {
         	Imgs imgs1=hs.findByFwbh2(h.getFwbh());
         	h.setImgs(imgs1);
         	
         }
         List<Imgs> imgsList=hs.findByFwbh(house.getFwbh());
         request.setAttribute("houseList" ,houses);
         request.setAttribute("imgsList" ,imgsList);
     	HttpSession session = request.getSession();	
		//从SSESSIOn获取一下 ids		
       List<Integer> ids = new ArrayList<Integer>();
		
		
		//最多放5， 如果多出5个将第一个删除
		if(ids.size() >= 5) {
			ids.remove(0);
		}		
 		if(request.getParameter("id")!=null) {
 			ids.add(id);
 		
 		}
 		session.setAttribute("ids", ids);		
         request.getRequestDispatcher("/WEB-INF/client/house_detail.jsp").forward(request,response);
    }
     //根据id查询图片信息
     protected void query2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Imgs imgs=hs.findImgsById(id);
         request.setAttribute("record",imgs);      
         request.getRequestDispatcher("/WEB-INF/house/edit_imgs.jsp").forward(request,response);
    }

     //查询房东个人信息
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询个人信息
    	int id=WebUtils.parseInt(request.getParameter("id"),0);
        House house=hs.findById(id);
        request.setAttribute("house",house);
        System.out.println(house);
        request.getRequestDispatcher("/WEB-INF/house/house_info.jsp").forward(request,response);
    }

    //编辑房源信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
    	 int id=WebUtils.parseInt(request.getParameter("id"),0);
         String title=request.getParameter("title");		
		int price =Integer.parseInt(request.getParameter("price"));
		int a_id =Integer.parseInt(request.getParameter("a_id"));
		
		String htype=request.getParameter("htype");
		String rtype=request.getParameter("rtype");
		String direction=request.getParameter("direction");
		String style=request.getParameter("style");
		int status =Integer.parseInt(request.getParameter("status"));
		int area =Integer.parseInt(request.getParameter("area"));
		String floor=request.getParameter("floor");
		String detail=request.getParameter("detail");
		String xq=request.getParameter("xq");
		String address=request.getParameter("address");
		House h=new House();	
		h.setA_id(a_id);
		h.setTitle(title);
		h.setPrice(price);
		h.setHtype(htype);
		h.setRtype(rtype);
		h.setDirection(direction);
		h.setStyle(style);
		h.setStatus(status);
		h.setArea(area);
		h.setFloor(floor);
		h.setDetail(detail);
		h.setXq(xq);
		h.setAddress(address);
		h.setId(id);
		hs.updateHouse(h);		
		Landloard landloard=(Landloard) request.getSession().getAttribute("landloard");
		String type=(String) request.getSession().getAttribute("type");
		if(type.equals("2")) {
			response.sendRedirect(request.getContextPath()+"/HouseServlet?action=findMyHouse&l_id="+landloard.getId());//重定向防止重复提交哦
		}else {
			response.sendRedirect(request.getContextPath()+"/HouseServlet?action=list");//重定向防止重复提交哦
		}
		
		/*if(landloard!=null ) {
			
			response.sendRedirect(request.getContextPath()+"/HouseServlet?action=list");//重定向防止重复提交哦
		}else{
			PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.href='/loginOut'");
			out.write("</script>");
			out.close();						
		};*/
    }
    //删除房源信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);   
        House house=hs.findById(id);
        hs.deleteByFwbh(house.getFwbh());//同时也删除该房源的图片
        int b=hs.deleteHouse(id);
        service.deleteYykfByHid(id);
        String type=(String) request.getSession().getAttribute("type");
        Landloard landloard=(Landloard) request.getSession().getAttribute("landloard");
        if(b==1&&type.equals("2")) {//跳转到我的房源列表
        	 response.sendRedirect(request.getContextPath()+"/HouseServlet?action=findMyHouse&l_id="+landloard.getId()); //重定向防止重复提交哦
        }else {
        	  response.sendRedirect(request.getContextPath()+"/HouseServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

  

    
  //跳转到添加房东界面
    protected void toAddHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
       List<Agency> agencyList=as.findAll();
       request.setAttribute("agencyList",agencyList);     
    	request.getRequestDispatcher("/WEB-INF/house/add_house.jsp").forward(request,response);
    }
	

}
