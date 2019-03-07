<%@page import="com.yangt.dome.Student" %>
<%@page import="java.util.List"%>
<%@page import="com.yangt.Test.School"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
<body>
	<table style="border-collapse: collapse" border="1" cellpadding="10">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>邮箱</td>
		</tr>
		<%
		School dao = new School();
		List<Student> list = dao.seek();
		for(Student s : list){
		%>
		<tr>
			<td><%=s.getStuid() %></td>
			<td><%=s.getStuame() %></td>
			<td><%=s.getStusex() %></td>
			<td><%=s.getEmail() %></td>
		</tr>
		<% } %>
	</table>
	<button onclick="del()">删除</button>
	<script type="text/javascript">
		function del(){
			var id = prompt("请输入要删除的学号：");
			location.href="delect.jsp?id="+id;
		}
	</script>
</body>
</html>