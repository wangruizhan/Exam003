<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hand.entity.*" %>
    <%@page import="com.hand.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <title>电影 列表</title>
 </head>
  
 <body>
 <div  id="title">
 
</div>
<div id="position"> 当前位置： 电影列表 </div>
  <tr>
  <form action="<%=request.getContextPath() %>/chprfl" method="post" id="check_form" >
  <table border="1" class="table_main"  cellspacing="0" cellpadding="0">
  <caption align="center" id="caption" id="caption">分类列表</caption>
		<tr class="a">
			<td align="center">film_id</td>
			<td align="center">title</td>
			<td align="center">description</td>
			
		
		</tr>
		
		<%	List<Film> aa = (List<Film>)request.getAttribute("search");
			if(aa!=null && !aa.isEmpty()){
				List<Film> film =(List<Film>)request.getAttribute("search");
				for(Film a: film){
		%>
			<tr class="b">
			<td id=div2><%=a.getFilm_id()%></td> 
            <td align="center"><input type="checkbox" name="choose" value="<%=a.getFilm_id()%>"></td>
		
			<td><%=a.getTitle()%></td>
			<td><%=a.getDescription()%> </td>
		
      		 </tr>	
		<%			
				}
			}else{
				List<Film> film =(List<Film>)request.getAttribute("film");
				if(null!=film && !film.isEmpty()){
					for(Film a:film){
		%>
				<tr class="b">
			<td id=div2><%=a.getFilm_id()%></td> 
            <td align="center"><input type="checkbox" name="choose" value="<%=a.getFilm_id()%>"></td>
			<td><%=a.getTitle()%></td>
			<td><%=a.getDescription()%></td>
			
      		 </tr>	
      		 <%}
				}
				}%>
		<tr class="b">
			<td colspan="7">
					
				<a href="javascript:deleteRecords('choose','<%=request.getContextPath() %>/deprfl');" class="btn">删除</a>&nbsp;
					<a href="javascript:editRecords('choose','<%=request.getContextPath() %>/edprfl');" class="btn">编辑</a>&nbsp;
					<a href="<%=request.getContextPath() %>/film/add_film" class="btn">添加</a>
			</td>
	   </tr>
	   
	  
  </table>
  
  
  </form>
  </tr>
 </body>
</html>
