package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.CSM;
import bean.Student;
import dao.StudentDao;
import dao.TcsmDao;
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		 if(event.equals("addStudent")) {
			int class_id=Integer.parseInt(request.getParameter("className"));
			String std_name=request.getParameter("studentName");
			String std_rollno=request.getParameter("rollNo");
			String admission_date=request.getParameter("admissionDate");
			String std_address=request.getParameter("address");
			Student std=new Student();
			std.setAdmission_date(admission_date);
			std.setClass_id(class_id);
			std.setStd_address(std_address);
			std.setStd_rollno(std_rollno);
			std.setStd_name(std_name);
			StudentDao sd=new StudentDao();
			sd.addStudent(std);
			response.sendRedirect("admin/viewStudent.jsp");
		 }else if(event.equals("viewStudent")) {
			 StudentDao sd=new StudentDao();
			 List<Student> student = sd.viewStudents();
			 GsonBuilder gsonBuilder = new GsonBuilder();
			 Gson  gson = gsonBuilder.create();
			 String JSONObject = gson.toJson(student);
		   //System.out.print(JSONObject);
			 out.print(JSONObject);
		}else if(event.equals("delete_student") ){
			int std_id=Integer.parseInt(request.getParameter("std_id"));
			String status=StudentDao.deleteStudent(std_id)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(status);
		 // System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("fatchStudentById")) {
			int std_id=Integer.parseInt(request.getParameter("std_id"));
			StudentDao sd=new StudentDao();
			List<Student> std = sd.getStudentById(std_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(std);
		  //System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("updateStudent")) {
			int std_id=Integer.parseInt(request.getParameter("studentId"));
			int class_id=Integer.parseInt(request.getParameter("className"));
			String std_name=request.getParameter("studentName");
			String std_rollno=request.getParameter("rollNo");
			String admission_date=request.getParameter("admissionDate");
			String std_address=request.getParameter("address");
			Student std=new Student();
			std.setAdmission_date(admission_date);
			std.setClass_id(class_id);
			std.setStd_address(std_address);
			std.setStd_rollno(std_rollno);
			std.setStd_name(std_name);
			std.setStd_id(std_id);
			StudentDao sd=new StudentDao();
			sd.updateStudent(std);
		 	response.sendRedirect("admin/viewStudent.jsp");
		}
	}
}
