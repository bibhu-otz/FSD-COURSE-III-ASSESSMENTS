<%@page import="utility.DbConnection" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>LA-TeachClsSubMap</title>
		
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
						<i class="fa fa-dashboard"></i> Dashboard / View Teacher-Class-Subject-Mapping
					</li>
				</ol>
			</div>
		</div>
		</div>
		<div><a href="addTeachClsSubMap.jsp" class="btn btn-success ">
                Map Teacher-Class-Subject<i class="fa fa-plus"></i>
            </a>
        </div>
       <hr>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							<i class="fa fa-list"></i> View Teacher-Class-Subject-Mapping
						</div>
					</div>
					<h4 id="msg" class=""style="text-align:center"></h4>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
							
								<thead >
									<tr >
										<th>Id</th>
										<th>Teacher Name</th>
										<th>Class Name</th>
										<th>Subject Name</th>
										<th>Class Time</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody id="tcsmBody">
									
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
        <h5 class="modal-title" id="exampleModalLabel">Edit TCSM</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" action="../tcsm" method="post">
        			<div class="form-group">
							<label for="" class="col-md-3 control-label">Teacher Name</label>
							<div class="col-md-6">
								<select  name="teacherName" class="form-control" id="teachername" required>
										<option>Choose Teacher</option>
									
										<%
										Connection con3 = DbConnection.getConnection();
									    String sql3="SELECT teacher_id,teacher_name FROM Teacher";
									    PreparedStatement ps3=con3.prepareStatement(sql3);  
									    
									    ResultSet rs3=ps3.executeQuery();  
									    while(rs3.next())
									    {
									    	%>
									    	<option   value="<%=rs3.getInt(1) %>"><%=rs3.getString(2) %></option>
									    	<% 
									    }
									    %>
									</select>
									<input type="hidden" name="event" value="updateTCSM">
									<input type="hidden" name="tcsmId" id="tcsmId" value="">
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
								<label for="" class="col-md-3 control-label">Class Time</label>
								<div class="col-md-6">
									<input type="text" name="classTime" id="classtime" class="form-control" required>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-md-3 control-label"></label>
								<div class="col-md-6">
									<input type="submit" name="updateTcsm" value="Update" class="btn btn-success form-control">
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
	    	let event = "event=viewTcsm";
	    	//alert(event);
        	$.ajax({
    			url:"../tcsm",
    			data:event,
    			type:"POST",
    			dataType:"json",
    			success:function(data,textStatus,jqXHR){ 
    				console.log(data);
    				let s2="";
    				for (var key in data) {
    					if (data.hasOwnProperty(key)) {
    					  s2+="<tr>";
    					  s2+="<td>"+data[key].tcsm_id+"</td>";
    					  s2+="<td>"+data[key].teacher_name+"</td>";
    					  s2+="<td>"+data[key].class_name+"</td>";
    					  s2+="<td>"+data[key].sub_name+"</td>";
    					  s2+="<td>"+data[key].class_time+"</td>";
    					  s2+="<td><a href='#' class='btn btn-info tcsm_edit' data-id='"+data[key].tcsm_id+"' id='"+data[key].tcsm_id+"'>Edit</a></td>";
    					  s2+="<td><a href='#' class='btn btn-danger tcsm_delete' data-id='"+data[key].tcsm_id+"' id='"+data[key].tcsm_id+"'>Delete</a></td></tr>";
    					}
    				}
    				$('#tcsmBody').html(s2);
    				console.log("success...")
    	  		},
    		error:function(jqXHR,textStatus,errorThrown){
    			console.log(jqXHR.responseText);
    				console.log("error...")
    		}});
			}
			$(document).on('click', '.tcsm_delete', function() {
				tcsm_id = $(this).attr('id');
            	 if (confirm('Are you sure you want to delete this?')) {
            $.ajax({
			    type:'POST',
			    url:'../tcsm',
				data:{'tcsm_id':tcsm_id,'event':'delete_tcsm'},
				method:'POST',
				dataType:'JSON',
				success:function(data,textStatus,jqXHR){
						if(data.trim() ==='done'){
  		  				$('#msg').html("Successfully Deleted!");
  		  				$('#tcsmBody').html('');
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
				
           </script>  
            <script>
					
                 $(document).on('click', '.tcsm_edit', function() {
                	 tcsm_id = $(this).attr('id');
                	$("#editModal").modal("show");
				$.ajax({
				    type:'POST',
				    url:'../tcsm',
					data:{'tcsm_id':tcsm_id,'event':'fatchTcsmById'},
					method:'POST',
					dataType:'JSON',
					success:function(data,textStatus,jqXHR){
						console.log(data);
						$("#tcsmId").val(data[0].tcsm_id);
						$("#classname").val(data[0].class_id);
	    				$("#subjectname").val(data[0].sub_id);
	    				$("#teachername").val(data[0].teacher_id);
	    				$("#classtime").val(data[0].class_time);
	    		},
				error:function(jqXHR,textStatus,errorThrown){
					console.log("error...");
  					}
				    });	
                	   
				 });
                 

			</script>
	</body>
</html>
