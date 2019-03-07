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
	<%
		String uid=request.getParameter("id");
		School sc=new School();
		int i=sc.delete(Integer.parseInt(uid));
		if(i>0){
			out.print("<script>alert('删除成功');location.href='hello.jsp'</script>");
		}else{
			out.print("<script>alert('删除失败');location.href='hello.jsp'</script>");
		}
	%>
</body>
</html>