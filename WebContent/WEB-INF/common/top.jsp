<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>
 <div class="content">
  <div class="width1190">
   <form action="CommonServlet?action=moreHouse3" method="post" class="pro-search">
    <table>
   
     <tr>
      <th>租&emsp;&emsp;金：</th>
      <td>
       <a href="CommonServlet?action=moreHouse" class="pro-cur">不限</a>
         <a href="CommonServlet?action=moreHouse1&flag=0">500以下</a>
       <a href="CommonServlet?action=moreHouse1&flag=1">500-1000</a>
       <a href="CommonServlet?action=moreHouse1&flag=2">1001-2000</a>
       <a href="CommonServlet?action=moreHouse1&flag=3">2001-3000</a>
      <a href="CommonServlet?action=moreHouse1&flag=4">3001-4000</a>
          <a href="CommonServlet?action=moreHouse1&flag=5">4001-5000</a>
         <a href="CommonServlet?action=moreHouse1&flag=6">5000以上</a>
        
       <input type="text" class="protext" name="price1"   style="width:40px;"/> - <input type="text" class="protext"  name="price2" style="width:40px;"/> 元 
       <input type="submit"  value="确定" />
      
      </td>
     </tr>
       <tr>
      <th>朝&emsp;&emsp;向：</th>
      <td>
       <a href="CommonServlet?action=moreHouse" class="pro-cur">不限</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝南">朝南</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝东">朝东</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝西">朝西</a>
       <a href="CommonServlet?action=moreHouse2&direction=朝北">朝北</a>
     
      </td>
     </tr>
     
     <tr>
      <th>面&emsp;&emsp;积：</th>
      <td>
       <a href="CommonServlet?action=moreHouse2" class="pro-cur">不限</a>
       <a href="CommonServlet?action=moreHouseFindByArea&area=1">10平方以下</a>
       <a href="CommonServlet?action=moreHouseFindByArea&area=2">11-30平方</a>
       <a href="CommonServlet?action=moreHouseFindByArea&area=3">31-60平方</a>
       <a href="CommonServlet?action=moreHouseFindByArea&area=4">61-80平方</a>
       <a href="CommonServlet?action=moreHouseFindByArea&area=5">80平方以上</a>
      </td>
     </tr>
       <tr>
      <th>房&emsp;&emsp;型：</th>
      <td>
       <a href="CommonServlet?action=moreHouse2" class="pro-cur">不限</a>
      <a href="CommonServlet?action=moreHouse2&htype=一室一厅">一室一厅(${counts1})</a> 
       <a href="CommonServlet?action=moreHouse2&htype=两室一厅">两室一厅(${counts2})</a>
       <a href="CommonServlet?action=moreHouse2&htype=三室一厅">三室一厅(${counts3})</a>
       <a href="CommonServlet?action=moreHouse2&htype=四室一厅">四室一厅(${counts4})</a>
       <a href="CommonServlet?action=moreHouse2&htype=四室两厅">四室两厅(${counts5})</a>

      </td>
     </tr>
      <tr>
      <th>装修风格：</th>
      <td>
       <a href="CommonServlet?action=moreHouse2" class="pro-cur">不限</a>
       <a href="CommonServlet?action=moreHouse2&style=精装修">精装修(${jzx})</a>
       <a href="CommonServlet?action=moreHouse2&style=普通装修">普通装修(${ptzx})</a>
       <a href="CommonServlet?action=moreHouse2&style=毛坯房">毛坯房(${mpf})</a>
       <a href="CommonServlet?action=moreHouse2&style=其他">其他(${qt})</a>
    
      </td>
     </tr>
   <tr>
      <th>出租方式：</th>
      <td>
       <a href="CommonServlet?action=moreHouse" class="pro-cur">不限</a>
       <a href="CommonServlet?action=moreHouse2&rtype=合租">合租</a>
       <a href="CommonServlet?action=moreHouse2&rtype=整租">整租</a>
       <a href="CommonServlet?action=moreHouse2&rtype=短租">短租</a>
       <a href="CommonServlet?action=moreHouse2&rtype=长租">长租</a>
       <a href="CommonServlet?action=moreHouse2&rtype=其他">其他</a>
      </td>
     </tr>
    </table>
    <div class="paixu">
     <strong>排序：</strong>
     <a href="CommonServlet?action=moreHouse" class="pai-cur">默认</a>
     <a href="CommonServlet?action=moreHouse2&flag=1">价格 &or;</a>
     <a href="CommonServlet?action=moreHouse2&flag=2">最新 &or;</a>
    </div>
   </form><!--pro-search/-->
  </div><!--width1190/-->
  </div>
   <!-- <div class="form-group">
                            <label>户型</label>
                          <select name="htype" class="form-control">
                         <option value="一室一厅" selected>一室一厅</option>
                                <option value="两室一厅" <>两室一厅</option>  
                                <option value="三室一厅" >三室一厅</option>  
                                <option value="四室一厅" >四室一厅</option>  
                                <option value="四室两厅" >四室两厅</option>                                                           
                            </select>
                           
                        </div> -->