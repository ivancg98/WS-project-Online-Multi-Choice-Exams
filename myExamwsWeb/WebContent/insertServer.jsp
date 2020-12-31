<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="entities.*" %>
    <%@ page import="DB.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form autocomplete="off" action="insertServer.jsp" method="post">
	<p>
		Ip
		<br/>
		<input type="text" name="ip" required="required"  />
	</p>
	<p>
		Port
		<br/>
		<input type="text" name="port" required="required"  />
	</p>
	<p>

	<input type="reset" value= "Reset fields"/>
	<input type="submit" name="send" value= "Insert server">

</form>

<p>
<a href="index.jsp">Return</a>
</p>

</body>
</html>

<%

if(request.getParameter("send")!= null){
	
	String ip = request.getParameter("ip");
	String port = request.getParameter("port");
	
	Server server = new Server(ip, port);
	
	ServerDB serverdb = new ServerDB();
	Boolean result = serverdb.insertServer(server);
	out.println(result);
	
}

%>