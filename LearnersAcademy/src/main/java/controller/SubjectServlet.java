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
import bean.Subject;
import dao.SubjectDao;

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SubjectServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		   if(event.equals("addSubject")) {
			 	String sub_name=request.getParameter("subjectName");
			 	SubjectDao sd=new SubjectDao();
			 	sd.addSubject(sub_name );
			 	response.sendRedirect("admin/viewSubject.jsp");
		   }else if(event.equals("viewSubject")) {
			 	SubjectDao sd=new SubjectDao();
				List<Subject> sub = sd.viewSubjects();
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(sub);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("delete_subject") ){
				int sub_id=Integer.parseInt(request.getParameter("sub_id"));
				String status=SubjectDao.deleteSubject(sub_id)==1?"done":"";
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(status);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("fatchSubjectById")) {
				int sub_id=Integer.parseInt(request.getParameter("sub_id"));
				SubjectDao sd=new SubjectDao();
				List<Subject> sub = sd.getSubjectById(sub_id);
				GsonBuilder gsonBuilder = new GsonBuilder();
			    Gson  gson = gsonBuilder.create();
			    String JSONObject = gson.toJson(sub);
			  //System.out.print(JSONObject);
				out.print(JSONObject);
			}else if(event.equals("updateSubject")) {
				int sub_id=Integer.parseInt(request.getParameter("subjectId"));
				String sub_name=request.getParameter("subjectName");
				SubjectDao sd=new SubjectDao();
			 	sd.updateSubject(sub_name,sub_id );
			 	response.sendRedirect("admin/viewSubject.jsp");
			}
	}
}
