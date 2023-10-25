<%@page import="utility.DbConnection" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title> LA-CSM</title>
		
		<!--Add CSS Files-->
		<link rel="stylesheet" type="text/css" href="resources/css/adminstyle.css">
		<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet"  type="text/css" href="resources/font-awesome/css/font-awesome.min.css">
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,300,400,700,900" rel="stylesheet">
		<script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
  		<script>tinymce.init({ selector:'textarea' });</script>
		
	</head>
	<body>
	<div id="wrapper">
		<%@include file="include/sidepanel.jsp" %>
		<div id="page-wrapper">
			<div class="container-fluid">
		    <div class="row">
			<div class="col-lg-12">
				<br>
				<br>
				<ol class="breadcrumb">
					<li class="active">
						<i class="fa fa-dashboard"></i> Dashboard / View Class-Subject-Mapping / Map Class-Subject
					</li>
				</ol>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="panel-title">
							<i class="fa fa-plus"></i> Map Class-Subject
						</div>
					</div>
					<h4 id="msg" style=" text-align: center;"></h4>
					<div class="panel-body">
					<form class="form-horizontal" action="../csm" id="myform1" method="post" >
						<div class="form-group">
							<label for="" class="col-md-3 control-label">Class Name</label>
							<div class="col-md-6">
								<select  name="className" class="form-control" id="classname" required>
										<option>Choose Class</option>
									
										<%
										Connection con = DbConnection.getConnection();
									    String sql="SELECT * FROM Classes";
									    PreparedStatement ps=con.prepareStatement(sql);  
									    
									    ResultSet rs=ps.executeQuery();  
									    while(rs.next())
									    {
									    	%>
									    	<option   value="<%=rs.getInt(1) %>"><%=rs.getString(2) %></option>
									    	<% 
									    }
									    %>
									</select>
									
									<input type="hidden" name="event" value="addCSM">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Subject Name</label>
								<div class="col-md-6">
								<select  name="subjectName" class="form-control" id="subjectname" required>
										<option>Choose Subject</option>
									
										<%
										Connection con2 = DbConnection.getConnection();
									    String sql2="SELECT * FROM Subject";
									    PreparedStatement ps2=con2.prepareStatement(sql2);  
									    
									    ResultSet rs2=ps2.executeQuery();  
									    while(rs2.next())
									    {
									    	%>
									    	<option   value="<%=rs2.getInt(1) %>"><%=rs2.getString(2) %></option>
									    	<% 
									    }
									    %>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="" class="col-md-3 control-label"></label>
								<div class="col-md-6">
									<input type="submit" id="addCSM"  value="Map Class-Subject" class="btn btn-success form-control">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<hr>
		</div>
		</div>
	
		
		<!--Add JavaScript Files-->
		<script src="resources/js/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/sweetalert.min.js"></script>
		
	</body>
</html>
