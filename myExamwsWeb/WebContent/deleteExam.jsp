<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entities.Exam" %>
    <%@ page import="DB.*" %>
    <%@ page import="client.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form autocomplete="off" action="deleteExam.jsp" method="post">
	<p>
		Exam ID
		<br/>
		<input type="text" name="key" required="required"  />
	</p>

	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Delete exam">

</form>

<p>
<a href="exam.jsp">Return</a>
</p>

<%

if(request.getParameter("send")!= null){
	

	String keyStr = request.getParameter("key");
	int key = Integer.parseInt(keyStr);
	
	
	
	ExamClient examClient = new ExamClient ();
	examClient.deleteExam(key);
	
}

%>

</body>
</html>