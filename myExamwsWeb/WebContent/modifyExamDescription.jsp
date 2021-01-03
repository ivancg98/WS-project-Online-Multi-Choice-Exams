<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.*" %>
    <%@ page import="DB.*" %>
    <%@ page import="client.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Exam Description</title>
</head>
<body>

<form autocomplete="off" action="modifyExamDescription.jsp" method="post">
	<p>
		Exam ID
		<br/>
		<input type="text" name="key" required="required"  />
	</p>
	<p>
		New description
		<br/>
		<input type="text" name="description" required="required"  />
	</p>


	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Modify description">

</form>

<p>
<a href="exam.jsp">Return</a>
</p>

</body>
</html>

<%

if(request.getParameter("send")!= null){
	
	String keyStr = request.getParameter("key");
	String description = request.getParameter("description");
	int key = Integer.parseInt(keyStr);
	
	ExamClient examClient = new ExamClient();
	examClient.modifyExamDescription(key, description);
	
}

%>