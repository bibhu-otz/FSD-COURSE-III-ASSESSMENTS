<%@ page session="true" %>
<%@ page import="utility.DbConnection" %>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
if (session.getAttribute("username") == null || session.getAttribute("username").equals(""))
{
	response.sendRedirect("../index.jsp");
}

String tempPath=DbConnection.Path();
String Path =tempPath.substring(tempPath.length() - 13);
System.out.println(Path);
%>

<!DOCTYPE html>
<html>
<head>
	<title>LearnersAcademy-Adminstrator</title>
	<!--Add CSS Files-->
	<link rel="stylesheet" type="text/css" href="resources/css/adminstyle.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet"  type="text/css" href="resources/font-awesome/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,300,400,700,900" rel="stylesheet">
	
</head>
<body>
	<div id="wrapper">
		<%@include file="include/sidepanel.jsp" %>
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header dashHead"></h1>
		<ol class="breadcrumb">
			<li class="active">
				<i class="fa fa-dashboard"></i> Welcome to <% out.print(request.getSession().getAttribute("username")); %>
			</li>
		</ol>
	</div>
</div>
			
			</div>
		</div>
	</div>
	
	<!--Add JavaScript Files-->
	<%@include file="include/Resources.jsp" %>
	
	
		
</body>
</html>