<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.*" %>
    <%@ page import="DB.*" %>
    <%@ page import="client.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Grade</title>
</head>
<body>

<form autocomplete="off" action="uploadClientGrade.jsp" method="post">
	<p>
		Client ID
		<br/>
		<input type="text" name="key" required="required"  />
	</p>
	<p>
		Exam ID
		<br/>
		<input type="text" name="keyExam" required="required"  />
	</p>
		<p>
		Grade
		<br/>
		<input type="text" name="grade" required="required"  />
	</p>

	
	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Upload grade">

</form>

<p>
<a href="client.jsp">Return</a>
</p>

</body>
</html>

<%

if(request.getParameter("send")!= null){
	
	String key = request.getParameter("key");
	String examKeyStr = request.getParameter("keyExam");
	String gradeStr = request.getParameter("grade");
	int examKey = Integer.parseInt(examKeyStr);
	float grade = Float.valueOf(gradeStr);


	ClientClient clientClient = new ClientClient();
	clientClient.uploadGrade(key, examKey, grade);
	
}

%>