<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DB.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database</title>
</head>
<body>

	<form autocomplete="off" action="database.jsp" method="post">
		<input type="submit" name="createTables" value="Create tables">
		<input type="submit" name="emptyTables" value="Empty tables">
		<input type="submit" name="deleteTables" value="Delete tables">
	</form>


	<%
		if (request.getParameter("createTables") != null) {
			ConnectDB connectdb = new ConnectDB();
			if (connectdb.createTables()) {
				out.println("Tables created successfully");
			} else {
				out.println("The tables could not be created");
			}

		} else if (request.getParameter("emptyTables") != null) {
			ConnectDB connectdb = new ConnectDB();
			if (connectdb.emptyTables()) {
				out.println("Tables empty successfully");
			} else {
				out.println("The tables could not be empty");
			}

		} else if (request.getParameter("deleteTables") != null) {
			ConnectDB connectdb = new ConnectDB();
			if (connectdb.deleteTables()) {
				out.println("Tables deleted successfully");
			} else {
				out.println("The tables could not be deleted");
			}
		}
	%>

	<br>
	<p>NOTE: Please check the access credentials to the database in the
		ConnectDB file</p>

	<p>
		<br><a href="index.jsp">Return</a><br>
	</p>
	
</body>
</html>