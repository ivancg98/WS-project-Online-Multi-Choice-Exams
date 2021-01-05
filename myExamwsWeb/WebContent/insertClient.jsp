<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="entities.*"%>
<%@ page import="DB.*"%>
<%@ page import="client.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert a Client</title>
</head>
<body>

	<form autocomplete="off" action="insertClient.jsp" method="post">
		<p>
			Client ID <br /> <input type="text" name="key" required="required" />
		</p>
		<p>
			Exam ID <br /> <input type="text" name="keyExam" required="required" />
		</p>


		<input type="reset" value="Reset fields" /> <input type="submit"
			name="send" value="Insert student">

	</form>

	<p>
		<br><a href="client.jsp">Return</a>
	</p>

</body>
</html>

<%
	if (request.getParameter("send") != null) {

		String key = request.getParameter("key");
		String examKeyStr = request.getParameter("keyExam");
		int examKey = Integer.parseInt(examKeyStr);

		Client client = new Client(key, examKey);

		ClientClient clientClient = new ClientClient();
		clientClient.insertClient(client);

	}
%>