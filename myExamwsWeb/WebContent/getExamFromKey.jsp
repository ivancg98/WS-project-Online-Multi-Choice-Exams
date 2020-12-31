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

<form autocomplete="off" action="getExamFromKey.jsp" method="post">
	<p>
		Enter Key
		<br/>
		<input type="text" name="key" required="required"  />
	</p>
	
	<input type="reset" value= "Reset"/>
	<input type="submit" name="send" value= "Search">
</form>

<table border="1">

<p>
<tr>
	<td>Key</td>
	<td>Description</td>
	<td>Date</td>
	<td>Time</td>
	<td>Location</td>
</tr>
</p>




<%

if(request.getParameter("send")!= null){

	ExamDB examdb = new ExamDB();
	int k = Integer.parseInt(request.getParameter("key"));
	Exam exam = examdb.getFromKey(k);
	
	out.println(" <tr>");
	out.println(" <td>"+exam.getKey()+"</td>");
	out.println(" <td>"+exam.getDescription()+"</td>");
	out.println(" <td>"+exam.getDate()+"</td>");
	out.println(" <td>"+exam.getTime()+"</td>");
	out.println(" </tr>");

}

%>

</table>


<p>
<a href="index.jsp">Return</a>
</p>


</body>
</html>

