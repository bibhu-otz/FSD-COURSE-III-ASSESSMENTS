<!DOCTYPE html>
<html>
	<head>
		<title>LA-Subject</title>
		
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
						<i class="fa fa-dashboard"></i> Dashboard / View Subject
					</li>
				</ol>
			</div>
		</div>
		</div>
		<div><a href="addSubject.jsp" class="btn btn-success ">
                Add Subject<i class="fa fa-plus"></i>
            </a>
        </div>
       <hr>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							<i class="fa fa-list"></i> View Subject
						</div>
					</div>
					<h4 id="msg" class=""style="text-align:center"></h4>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
							
								<thead >
									<tr >
										<th>Subject Id</th>
										<th>Subject Name</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody id="subjectBody">
									
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
        <h5 class="modal-title" id="exampleModalLabel">Edit Subject</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" action="../subject" method="post">
							
							<div class="form-group">
								<label for="" class="col-md-3 control-label">Subject Name</label>
								<div class="col-md-6">
									<input type="text" name="subjectName" id="subjectname" class="form-control" required>
									<input type="hidden" name="event" value="updateSubject">
									<input type="hidden" name="subjectId" id="subjectId" value="">
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
	    	let event = "event=viewSubject";
	    	//alert(event);
        	$.ajax({
    			url:"../subject",
    			data:event,
    			type:"POST",
    			dataType:"json",
    			success:function(data,textStatus,jqXHR){ 
    				console.log(data);
    				let s2="";
    				for (var key in data) {
    					if (data.hasOwnProperty(key)) {
    					  s2+="<tr>";
    					  s2+="<td>"+data[key].sub_id+"</td>";
    					  s2+="<td>"+data[key].sub_name+"</td>";
    					  s2+="<td><a href='#' class='btn btn-info subject_edit' data-id='"+data[key].sub_id+"' id='"+data[key].sub_id+"'>Edit</a>";
    					  s2+=" &nbsp;<a href='#' class='btn btn-danger subject_delete' data-id='"+data[key].sub_id+"' id='"+data[key].sub_id+"'>Delete</a></td></tr>";
    					}
    				}
    				$('#subjectBody').html(s2);
    				console.log("success...")
    	  		},
    		error:function(jqXHR,textStatus,errorThrown){
    			console.log(jqXHR.responseText);
    				console.log("error...")
    		}});
			}
			$(document).on('click', '.subject_delete', function() {
				sub_id = $(this).attr('id');
            	 if (confirm('Are you sure you want to delete this?')) {
            $.ajax({
			    type:'POST',
			    url:'../subject',
				data:{'sub_id':sub_id,'event':'delete_subject'},
				method:'POST',
				dataType:'JSON',
				success:function(data,textStatus,jqXHR){
						if(data.trim() ==='done'){
  		  				$('#msg').html("Successfully Deleted!");
  		  				$('#subjectBody').html('');
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
					
                 $(document).on('click', '.subject_edit', function() {
                	 sub_id = $(this).attr('id');
                	$("#editModal").modal("show");
				$.ajax({
				    type:'POST',
				    url:'../subject',
					data:{'sub_id':sub_id,'event':'fatchSubjectById'},
					method:'POST',
					dataType:'JSON',
					success:function(data,textStatus,jqXHR){
						//console.log(data);
						$("#subjectId").val(data[0].sub_id);
	    				$("#subjectname").val(data[0].sub_name);
	    		},
				error:function(jqXHR,textStatus,errorThrown){
					console.log("error...");
  					}
				    });	
                	   
				 });
                 

			</script>
	</body>
</html>
