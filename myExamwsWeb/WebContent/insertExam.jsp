<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.Exam" %>
    <%@ page import="DB.*" %>
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
	
	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Insert exam">

</form>

</body>
</html>

<%

if(request.getParameter("send")!= null){
	
	String description = request.getParameter("description");
	String date = request.getParameter("date");
	String timeStr = request.getParameter("time");
	
	int time = Integer.parseInt(timeStr);
	
	Exam exam = new Exam();
	exam.setDescription(description);
	exam.setDate(date);
	exam.setTime(time);
	
	ExamDB examdb = new ExamDB();
	String result = examdb.insert(exam);
	out.println(result);
	
}

%>