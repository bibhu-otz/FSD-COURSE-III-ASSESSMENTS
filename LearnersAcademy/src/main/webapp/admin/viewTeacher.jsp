<!DOCTYPE html>
<html>
	<head>
		<title>LA-Teachers</title>
		
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
						<i class="fa fa-dashboard"></i> Dashboard / View Teacher
					</li>
				</ol>
			</div>
		</div>
		</div>
		<div><a href="addTeacher.jsp" class="btn btn-success ">
                Add Teacher<i class="fa fa-plus"></i>
            </a>
        </div>
       <hr>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							<i class="fa fa-list"></i> View Teacher
						</div>
					</div>
					<h4 id="msg" class=""style="text-align:center"></h4>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
							
								<thead >
									<tr >
										<th>Teacher Id</th>
										<th>Name</th>
										<th>Image</th>
										<th>Address</th>
										<th>ContactNo</th>
										<th>Qualification</th>
										<th>JoinDate</th>
										<th>Salary</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody id="teacherBody">
									
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
        <h5 class="modal-title" id="exampleModalLabel">Edit Teacher</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" action="../teacher" method="post" enctype="multipart/form-data" >
							
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Teacher Name</label>
								<div class="col-md-6">
									<input type="text" name="teachName" id="teachname" class="form-control" required>
									<input type="hidden" name="event" value="updateTeacher">
									<input type="hidden" name="teacherId" id="teachId" value="">
								</div>
							</div>
							
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Address</label>
								<div class="col-md-6">
									<input type="text" name="teachAddress" id="teachAdd" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Contact Number</label>
								<div class="col-md-6">
									<input type="text" name="teachPhno" id="techCon" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Qualification</label>
								<div class="col-md-6">
									<input type="text" name="teachQuali" id="techQ" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Join Date</label>
								<div class="col-md-6">
									<input type="date" name="teachJoinDate" id="teachDa" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Salary</label>
								<div class="col-md-6">
									<input type="text" name="techSalary" id="teachsal" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Image</label>
								<div class="col-md-6">
									<input type="file" name="teachImg" id="techPic" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label"></label>
								<div class="col-md-6">
									<input type="submit" name="updateTeacher" value="Update" class="btn btn-success form-control">
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
	    	let event = "event=viewTeacher";
	    	//alert(event);
        	$.ajax({
    			url:"../teacher",
    			data:event,
    			type:"POST",
    			dataType:"json",
    			success:function(data,textStatus,jqXHR){ 
    				console.log(data);
    				let s2="";
    				for (var key in data) {
    					if (data.hasOwnProperty(key)) {
    					  s2+="<tr>";
    					  s2+="<td>"+data[key].teacher_id+"</td>";
    					  s2+="<td>"+data[key].teacher_name+"</td>";
    					  s2+="<td><img src='resources/img/teacherImg/"+data[key].teacher_img+"' style='width:50px;height:50px'></td>";
    					  s2+="<td>"+data[key].teacher_address+"</td>";
    					  s2+="<td>"+data[key].teacher_phno+"</td>";
    					  s2+="<td>"+data[key].teacher_qualification+"</td>";
    					  s2+="<td>"+data[key].join_date+"</td>";
    					  s2+="<td>"+data[key].teacher_salary+"</td>";
    					  s2+="<td><a href='#' class='btn btn-info btn-block teacher_edit' data-id='"+data[key].teacher_id+"' id='"+data[key].teacher_id+"'>Edit</a>";
    					  s2+=" <a href='#' class='btn btn-danger btn-block teacher_delete' data-id='"+data[key].teacher_id+"' id='"+data[key].teacher_id+"'>Delete</a></td></tr>";
    					}
    				}
    				$('#teacherBody').html(s2);
    				console.log("success...")
    	  		},
    		error:function(jqXHR,textStatus,errorThrown){
    			console.log(jqXHR.responseText);
    				console.log("error...")
    		}});
			}
			$(document).on('click', '.teacher_delete', function() {
				teacherId = $(this).attr('id');
            	 if (confirm('Are you sure you want to delete this?')) {
            $.ajax({
			    type:'POST',
			    url:'../teacher',
				data:{'teacherId':teacherId,'event':'delete_teacher'},
				method:'POST',
				dataType:'JSON',
				success:function(data,textStatus,jqXHR){
						if(data.trim() ==='done'){
  		  				$('#msg').html("Successfully Deleted!");
  		  				$('#teacherBody').html('');
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
			$(document).on('click', '.teacher_edit', function() {
                	 teacherId = $(this).attr('id');
                	$("#editModal").modal("show");
				$.ajax({
				    type:'POST',
				    url:'../teacher',
					data:{'teacherId':teacherId,'event':'fatchTeacherById'},
					method:'POST',
					dataType:'JSON',
					success:function(data,textStatus,jqXHR){
						//console.log(data);
						$("#teachId").val(data[0].teacher_id);
	    				$("#teachname").val(data[0].teacher_name);
	    				$("#teachAdd").val(data[0].teacher_address);
	    				$("#techCon").val(data[0].teacher_phno);
	    				$("#techQ").val(data[0].teacher_qualification);
	    				$("#teachDa").val(data[0].join_date);
	    				$("#teachsal").val(data[0].teacher_salary);
	    				$("#techPic").val(data[0].teacher_img);
  				},
				error:function(jqXHR,textStatus,errorThrown){
					console.log("error...");
  					}
				    });	
                	   
				 });
                 

			</script>
	</body>
</html>
