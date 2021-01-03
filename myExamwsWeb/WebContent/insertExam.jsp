
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.Exam" %>
    <%@ page import="DB.*" %>
    <%@ page import="client.ExamClient" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form autocomplete="off" action="insertExam.jsp" method="post">
	<p>
		Description
		<br/>
		<input type="text" name="description" required="required"  />
	</p>
	<p>
		Date
		<br/>
		<input type="text" name="date" required="required"  />
	</p>
	<p>
		Time
		<br/>
		<input type="text" name="time" required="required"  />
	</p>
	<p>
		Location
		<br/>
		<input type="text" name="location" required="required"  />
	</p>
	
	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Insert exam">

</form>

<p>
<a href="exam.jsp">Return</a>
</p>

</body>
</html>

<%

if(request.getParameter("send")!= null){
	
	String description = request.getParameter("description");
	String date = request.getParameter("date");
	String time = request.getParameter("time");
	String locationStr = request.getParameter("location");
	int location = Integer.parseInt(locationStr);
	
	Exam exam = new Exam(description, date, time, location);
	
	ExamClient examClient = new ExamClient ();
	examClient.insertExam(exam);
	
}

%>