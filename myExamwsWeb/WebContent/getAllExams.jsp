<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.Exam" %>
    <%@ page import="DB.*" %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">

<tr>
	<td>Key</td>
	<td>Description</td>
	<td>Date</td>
	<td>Time</td>
</tr>

<% 
ExamDB examdb = new ExamDB();
Exam exam = new Exam();

ArrayList<Exam> listExams = examdb.getAll();

for(int i=0; i<listExams.size(); i++){
	exam = listExams.get(i);
	
	out.println(" <tr>");
	out.println(" <td>"+exam.getKey()+"</td>");
	out.println(" <td>"+exam.getDescription()+"</td>");
	out.println(" <td>"+exam.getDate()+"</td>");
	out.println(" <td>"+exam.getTime()+"</td>");
	out.println(" </tr>");

}

%>
</table>

</body>
</html>