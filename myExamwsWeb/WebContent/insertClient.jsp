<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.*" %>
    <%@ page import="DB.*" %>
    <%@ page import="client.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form autocomplete="off" action="insertClient.jsp" method="post">
	<p>
		Student ID
		<br/>
		<input type="text" name="key" required="required"  />
	</p>
	<p>
		Exam ID
		<br/>
		<input type="text" name="keyExam" required="required"  />
	</p>

	
	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Insert student">

</form>

<p>
<a href="client.jsp">Return</a>
</p>

</body>
</html>

<%

if(request.getParameter("send")!= null){
	
	String key = request.getParameter("key");
	String keyExamStr = request.getParameter("keyExam");
	int keyExam = Integer.parseInt(keyExamStr);

	Client client = new Client(key, keyExam);
	
	ClientClient clientClient = new ClientClient();
	clientClient.insertClient(client);
	
}

%>