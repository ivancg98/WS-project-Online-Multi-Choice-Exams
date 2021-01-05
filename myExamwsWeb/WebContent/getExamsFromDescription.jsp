<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="entities.Exam"%>
<%@ page import="DB.*"%>
<%@ page import="client.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get exam from a Description</title>
</head>
<body>

	<form autocomplete="off" action="getExamsFromDescription.jsp"
		method="post">
		<p>
			Exam description for search <br /> <input type="text"
				name="description" required="required" />
		</p>
		<p>
			<input type="radio" name="typeSearch" value="fullSearch">
			Full Search <input type="radio" name="typeSearch"
				value="partialSearch" checked> Partial Search
		</p>
		<input type="reset" value="Reset field" /> <input type="submit"
			name="send" value="Search">

	</form>

	<%
		if (request.getParameter("send") != null) {

			if (request.getParameter("typeSearch").equals("fullSearch")) {
				response.sendRedirect("http://localhost:8080/myExamwsWeb/rest/exam/fullDescription/"
						+ request.getParameter("description"));
			} else if (request.getParameter("typeSearch").equals("partialSearch")) {
				response.sendRedirect("http://localhost:8080/myExamwsWeb/rest/exam/partialDescription/"
						+ request.getParameter("description"));
			}
		}
	%>




	<p>
		<br><a href="exam.jsp">Return</a>
	</p>


</body>
</html>