
<!DOCTYPE html>
<html>
	<head>
		<title> LA-AddTeacher</title>
		
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
						<i class="fa fa-dashboard"></i> Dashboard / ViewTeacher / Add Teacher
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
							<i class="fa fa-plus"></i> Add Teacher
						</div>
					</div>
					<h4 id="msg" style=" text-align: center;"></h4>
					<div class="panel-body">
						<form class="form-horizontal" action="../teacher" id="myform1" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Teacher Name</label>
								<div class="col-md-6">
									<input type="text" name="teachName" class="form-control" required>
									<input type="hidden" name="event" value="addTeacher">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Image</label>
								<div class="col-md-6">
									<input type="file" name="teachImg" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Address</label>
								<div class="col-md-6">
									<input type="text" name="teachAddress" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Contact Number</label>
								<div class="col-md-6">
									<input type="text" name="teachPhno" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Qualification</label>
								<div class="col-md-6">
									<input type="text" name="teachQuali" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Join Date</label>
								<div class="col-md-6">
									<input type="date" name="teachJoinDate" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Salary</label>
								<div class="col-md-6">
									<input type="text" name="techSalary" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label"></label>
								<div class="col-md-6">
									<input type="submit" id="addTeacher"  value="Add Teacher" class="btn btn-success form-control">
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
