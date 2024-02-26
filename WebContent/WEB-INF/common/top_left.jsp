<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
  <div class="list-list">
  
     <dl>
      <dt><a href="javascript:;">出租方式</a></dt>
      <dd>
       <a href="CommonServlet?action=moreHouse2&rtype=整租">整租</a>
       <a href="CommonServlet?action=moreHouse2&rtype=合租">合租</a>
      <a href="CommonServlet?action=moreHouse2&rtype=场租">长租</a>
        <a href="CommonServlet?action=moreHouse2&rtype=短租">短租</a>
        <a href="CommonServlet?action=moreHouse2&rtype=其他">其他</a>
      </dd>
     </dl>
     
      <dl>
      <dt><a href="javascript:;">朝&emsp;&emsp;向</a></dt>
      <dd>
        <a href="CommonServlet?action=moreHouse" class="pro-cur">不限</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝南">朝南</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝东">朝东</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝西">朝西</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝北">朝北</a>
     
    
      </dd>
     </dl>
     <dl>
      <dt><a href="javascript:;">租房类型</a></dt>
      <dd>
        <a href="CommonServlet?action=moreHouse" class="pro-cur">不限</a
     <a href="CommonServlet?action=moreHouse2&htype=一室一厅">一室一厅</a>
       <a href="CommonServlet?action=moreHouse2&htype=两室一厅">两室一厅</a>
       <a href="CommonServlet?action=moreHouse2&htype=三室一厅">三室一厅</a>
       <a href="CommonServlet?action=moreHouse2&htype=四室一厅">四室一厅</a>
       <a href="CommonServlet?action=moreHouse2&htype=四室两厅">四室两厅</a>
      </dd>
     </dl>
     
      <dl>
      <dt><a href="javascript:;">装修风格</a></dt>
      <dd>
       <a href="CommonServlet?action=moreHouse2&style=精装修">精装修</a>
       <a href="CommonServlet?action=moreHouse2&style=普通装修">普通装修</a>
       <a href="CommonServlet?action=moreHouse2&style=毛坯房">毛坯房</a>
        <a href="CommonServlet?action=moreHouse2&style=其他">其他</a>
      </dd>
     </dl>
   
    </div>