<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form autocomplete="off" action="getClientFromKey.jsp" method="post">
	<p>
		Enter Client ID
		<br/>
		<input type="text" name="key" required="required"  />
	</p>
	
	<input type="reset" value= "Reset"/>
	<input type="submit" name="send" value= "Search">
</form>





<%

if(request.getParameter("send")!= null){


	response.sendRedirect("http://localhost:8080/myExamwsWeb/rest/client/studentId/"+request.getParameter("key")); 

}

%>




<p>
<a href="client.jsp">Return</a>
</p>

</body>
</html>