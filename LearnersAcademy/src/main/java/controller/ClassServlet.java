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
import bean.Classes;
import dao.ClassDao;
@WebServlet("/classes")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ClassServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		 if(event.equals("addClass")) {
			 	String class_name=request.getParameter("className");
			 	ClassDao cd=new ClassDao();
			 	cd.addClass(class_name );
			 	response.sendRedirect("admin/viewClasses.jsp");
		 }else if(event.equals("viewClasses")) {
			 	ClassDao cd=new ClassDao();
				List<Classes> cls = cd.viewClasses();
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(cls);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("delete_class") ){
				int class_id=Integer.parseInt(request.getParameter("class_id"));
				String status=ClassDao.deleteClass(class_id)==1?"done":"";
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(status);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("fatchClassById")) {
				int class_id=Integer.parseInt(request.getParameter("class_id"));
				ClassDao cd=new ClassDao();
				List<Classes> cls = cd.getClassById(class_id);
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(cls);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("updateClass")) {
				int class_id=Integer.parseInt(request.getParameter("classId"));
				String class_name=request.getParameter("className");
				ClassDao cd=new ClassDao();
			 	cd.updateClass(class_name,class_id );
			 	response.sendRedirect("admin/viewClasses.jsp");
			}
	}

}
