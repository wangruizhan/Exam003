<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hand.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>编辑产品分类</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/content.css"/>
</head>

<body>


<div id="content">
  <form action="<%=request.getContextPath()%>/saedprfl?id=<%=request.getAttribute("id") %>" method="post" id="check_form">
    <table class="add_table" >
      <caption>
      添加产品分类
      </caption>
      <thead>
      </thead>
      <tbody>
        <tr  >
        <%	List<Film> film= (List<Film>)request.getAttribute("film");
			if(null!=film && !film.isEmpty()){
				for(Film p:film){
		%>
			<td  width="15%"> 电影名称:</td>
         <td ><input  name="title"  id="title" type="text" value="<%=p.getTitle() %>">
		   
        </tr>
            <tr  >
          <td  width="15%">描述:</td>
          <td ><input  name="b_classes" id="b_classes" type="text" value="<%=p.getDescription()%>">
		  
        </tr>
        
          <%		}
			}
		%>
            </tr>
        <tr  style="background-color:#EEF4EA">
          <td colspan="3" align="center"><input type="submit" value="添加"/></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
</body>

</html>
