<%@page import="com.dao.dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="m" class = "com.model.model"></jsp:useBean>
    <jsp:setProperty property="*" name="m"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    int status = dao.savedata(m);
    
    String pass = request.getParameter("pwd");
    String cpass = request.getParameter("cpwd");
    
    if(pass.equals(cpass))
    {
    	 if(status>0)
    	 {
    		 response.sendRedirect("login.jsp");
    	 }
    	 else
    	 {
    		 out.print("Failed");
    	 }
    	
    }
    else
    {
    	out.print("Password and confirm password mismatched.");
    }
    
    %>

</body>
</html>