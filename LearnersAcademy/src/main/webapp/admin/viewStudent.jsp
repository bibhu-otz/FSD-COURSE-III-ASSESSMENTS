<%@page import="utility.DbConnection" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>LA-Student</title>
		
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
				<br>
				<br>
				<ol class="breadcrumb">
					<li class="active">
						<i class="fa fa-dashboard"></i> Dashboard / View Students
					</li>
				</ol>
			</div>
		</div>
		</div>
		<div><a href="addStudent.jsp" class="btn btn-success ">
                Add Student <i class="fa fa-plus"></i>
            </a>
        </div>
       <hr>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							<i class="fa fa-list"></i> View Student
						</div>
					</div>
					<h4 id="msg" class=""style="text-align:center"></h4>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
							
								<thead >
									<tr >
										<th>Student Id</th>
										<th>Student Name</th>
										<th>RollNo</th>
										<th>Admission Date</th>
										<th>Address</th>
										<th>Class Name</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody id="StudentBody">
									
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		
	<hr>
</div>	
</div>	
<!--Edit Modal dept-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Edit Student</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" action="../student" method="post">
							
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Student Name</label>
								<div class="col-md-6">
									<input type="text" name="studentName" id="studentName" class="form-control" required>
									<input type="hidden" name="event" value="updateStudent">
									<input type="hidden" name="studentId" id="studentId" value="">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">RollNo</label>
								<div class="col-md-6">
									<input type="text" name="rollNo" id="rollNo" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Admission Date</label>
								<div class="col-md-6">
									<input type="date" name="admissionDate" id="admissionDate" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Address</label>
								<div class="col-md-6">
									<input type="text" name="address" id="address" class="form-control" required>
								</div>
							</div>
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
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label"></label>
								<div class="col-md-6">
									<input type="submit" name="updateSubject" value="Update" class="btn btn-success form-control">
								</div>
							</div>
						</form>
      </div>
    </div>
  </div>
</div>

		<!--Add JavaScript Files-->
		<%@include file="include/Resources.jsp" %>
		<script>
		$(document).ready(function() {
			getData();
			function getData(){
	    	let event = "event=viewStudent";
	    	//alert(event);
        	$.ajax({
    			url:"../student",
    			data:event,
    			type:"POST",
    			dataType:"json",
    			success:function(data,textStatus,jqXHR){ 
    				console.log(data);
    				let s2="";
    				for (var key in data) {
    					if (data.hasOwnProperty(key)) {
    					  s2+="<tr>";
    					  s2+="<td>"+data[key].std_id+"</td>";
    					  s2+="<td>"+data[key].std_name+"</td>";
    					  s2+="<td>"+data[key].std_rollno+"</td>";
    					  s2+="<td>"+data[key].admission_date+"</td>";
    					  s2+="<td>"+data[key].std_address+"</td>";
    					  s2+="<td>"+data[key].class_name+"</td>";
    					  s2+="<td><a href='#' class='btn btn-info student_edit' data-id='"+data[key].std_id+"' id='"+data[key].std_id+"'>Edit</a>";
    					  s2+=" &nbsp;<a href='#' class='btn btn-danger student_delete' data-id='"+data[key].std_id+"' id='"+data[key].std_id+"'>Delete</a></td></tr>";
    					}
    				}
    				$('#StudentBody').html(s2);
    				console.log("success...")
    	  		},
    		error:function(jqXHR,textStatus,errorThrown){
    			console.log(jqXHR.responseText);
    				console.log("error...")
    		}});
			}
			$(document).on('click', '.student_delete', function() {
				std_id = $(this).attr('id');
            	 if (confirm('Are you sure you want to delete this?')) {
            $.ajax({
			    type:'POST',
			    url:'../student',
				data:{'std_id':std_id,'event':'delete_student'},
				method:'POST',
				dataType:'JSON',
				success:function(data,textStatus,jqXHR){
						if(data.trim() ==='done'){
  		  				$('#msg').html("Successfully Deleted!");
  		  				$('#StudentBody').html('');
  		  				getData();
  		  			 }else{
  		  				$('#msg').html("Something went wrong on server!");
  		  			}
				},
			error:function(jqXHR,textStatus,errorThrown){
				console.log("error...");
		  			$('#msg').html(errorThrown);
		  			}
			    });	
            	} //confirm end   
			 });
			});
		</script>
  
            <script>
					
                 $(document).on('click', '.student_edit', function() {
                	 std_id = $(this).attr('id');
                	$("#editModal").modal("show");
				$.ajax({
				    type:'POST',
				    url:'../student',
					data:{'std_id':std_id,'event':'fatchStudentById'},
					method:'POST',
					dataType:'JSON',
					success:function(data,textStatus,jqXHR){
						console.log(data);
						$("#studentId").val(data[0].std_id);
	    				$("#studentName").val(data[0].std_name);
	    				$("#rollNo").val(data[0].std_rollno);
	    				$("#admissionDate").val(data[0].admission_date);
	    				$("#address").val(data[0].std_address);
	    				$("#classname").val(data[0].class_id);
	    		},
				error:function(jqXHR,textStatus,errorThrown){
					console.log("error...");
  					}
				    });	
                	   
				 });
                 

			</script>
	</body>
</html>
