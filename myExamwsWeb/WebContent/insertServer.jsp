<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="entities.*"%>
<%@ page import="DB.*"%>
<%@ page import="client.ServerClient"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert a Server</title>
</head>
<body>

	<form autocomplete="off" action="insertServer.jsp" method="post">
		<p>
			Ip <br /> <input type="text" name="ip" required="required" />
		</p>
		<p>
			Port <br /> <input type="text" name="port" required="required" />
		</p>
		<p>

			<input type="reset" value="Reset fields" /> <input type="submit"
				name="send" value="Insert server">
	</form>

	<p>
		<br><a href="server.jsp">Return</a>
	</p>

</body>
</html>

<%
	if (request.getParameter("send") != null) {

		String ip = request.getParameter("ip");
		String port = request.getParameter("port");

		Server server = new Server(ip, port);

		ServerClient serverClient = new ServerClient();
		serverClient.insertServer(server);

	}
%>