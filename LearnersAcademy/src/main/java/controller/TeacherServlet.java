package controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import bean.Teacher;
import dao.TeacherDao;
import utility.DbConnection;

@WebServlet("/teacher")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TeacherServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		 if(event.equals("addTeacher")) {
			 	String teacher_name=request.getParameter("teachName");
			 	String teacher_address=request.getParameter("teachAddress");
			 	String teacher_phno=request.getParameter("teachPhno");
			 	String teacher_qualification=request.getParameter("teachQuali");
			 	String join_date=request.getParameter("teachJoinDate");
			 	double teacher_salary=Double.parseDouble(request.getParameter("techSalary"));
		
			 	Part p1=request.getPart("teachImg");
				System.out.println(p1);	
				String Path=DbConnection.Path();
		        String appPath =Path+"/teacherImg";
		      //File path where all files will be stored
		        String imagePath = appPath + "";
		      //Creates the file directory if it does not exists
		        File fileDir = new File(imagePath);
		        if (!fileDir.exists()) 
		                 fileDir.mkdirs();
		      //Get Image Name
		        String imageName1 = p1.getSubmittedFileName();
		        String fileExt1 = imageName1.substring(imageName1.length()-3);
		        String imgname1=new Date().getTime() +"1"+"."+fileExt1;
		        
		        String finalImgPath1="teacherImg" + "/"+ imgname1;
		
				        if(validateImage1(imageName1)){
				            try{
				                p1.write(imagePath + "/" + imgname1);
				            }catch (Exception ex) { }
				        }else{ out.print("<script> alert('Invalid Image Format')</script>");  }
		        
					Teacher teacher=new Teacher();
					teacher.setTeacher_name(teacher_name);
					teacher.setTeacher_img(imgname1);
					teacher.setJoin_date(join_date);
					teacher.setTeacher_address(teacher_address);
					teacher.setTeacher_phno(teacher_phno);
					teacher.setTeacher_salary(teacher_salary);
					teacher.setTeacher_qualification(teacher_qualification);
					
					 int i=TeacherDao.addTeacher(teacher);
					 if (i>=0) {
						 response.sendRedirect("admin/viewTeacher.jsp?msg=true");
					 }else {
						 out.print("<script> alert('Somthing went to wrong')</script>"); 
					 }
			}else if(event.equals("viewTeacher")) {
				TeacherDao teacherDao=new TeacherDao();
				List<Teacher> teacher = teacherDao.viewTeachers();
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(teacher);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("delete_teacher") ){
				int teacher_id=Integer.parseInt(request.getParameter("teacherId"));
				String status=TeacherDao.deleteTeacher(teacher_id)==1?"done":"";
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(status);
			 // System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("fatchTeacherById")) {
				int teacher_id=Integer.parseInt(request.getParameter("teacherId"));
				TeacherDao teacherDao=new TeacherDao();
				List<Teacher> teacher = teacherDao.getTeacherDetailsById(teacher_id);
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(teacher);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("updateTeacher")) {
				int teacher_id=Integer.parseInt(request.getParameter("teacherId"));
				String teacher_name=request.getParameter("teachName");
			 	String teacher_address=request.getParameter("teachAddress");
			 	String teacher_phno=request.getParameter("teachPhno");
			 	String teacher_qualification=request.getParameter("teachQuali");
			 	String join_date=request.getParameter("teachJoinDate");
			 	double teacher_salary=Double.parseDouble(request.getParameter("techSalary"));
		
			 	Part p1=request.getPart("teachImg");
			  //System.out.println(p1);	
				String Path=DbConnection.Path();
		        String appPath =Path+"/teacherImg";
		      //File path where all files will be stored
		        String imagePath = appPath + "";
		      //Creates the file directory if it does not exists
		        File fileDir = new File(imagePath);
		        if (!fileDir.exists()) 
		                 fileDir.mkdirs();
		      //Get Image Name
		        String imageName1 = p1.getSubmittedFileName();
		        String fileExt1 = imageName1.substring(imageName1.length()-3);
		        String imgname1=new Date().getTime() +"1"+"."+fileExt1;
		        
		        String finalImgPath1="teacherImg" + "/"+ imgname1;
		
				        if(validateImage1(imageName1)){
				            try{
				                p1.write(imagePath + "/" + imgname1);
				            }catch (Exception ex) { }
				        }else{ out.print("<script> alert('Invalid Image Format')</script>");  }
		        
					Teacher teacher=new Teacher();
					teacher.setTeacher_id(teacher_id);
					teacher.setTeacher_name(teacher_name);
					teacher.setTeacher_img(imgname1);
					teacher.setJoin_date(join_date);
					teacher.setTeacher_address(teacher_address);
					teacher.setTeacher_phno(teacher_phno);
					teacher.setTeacher_salary(teacher_salary);
					teacher.setTeacher_qualification(teacher_qualification);
					int i=TeacherDao.updateTeacher(teacher);
					 if (i>=0) {
						 response.sendRedirect("admin/viewTeacher.jsp?msg=true");
					 }else {
						 out.print("<script> alert('Somthing went to wrong')</script>"); 
					 }
			}
		}
	
	
	private boolean validateImage1(String imageName1){
	      String fileExt1 = imageName1.substring(imageName1.length()-3);
	      if("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1))
	      { 
	    	  return true;
	      }
	      return false;
	    }

}
