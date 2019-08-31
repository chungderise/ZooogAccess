<%@ page import="zooog.jp.model.Actor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	Actor a1 = (Actor) request.getSession().getAttribute("actor");
	 %>
	<ur>
	  <li><% out.print(a1.getActorId());%></li>
	  <li><% out.print(a1.getFirstName());%></li>
	  <li><% out.print(a1.getLastName());%></li>
	  <li><% out.print(a1.getLastUpdate());%></li>
	</ur>

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>