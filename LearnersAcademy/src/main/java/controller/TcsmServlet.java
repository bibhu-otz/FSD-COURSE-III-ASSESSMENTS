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
import dao.TcsmDao;

@WebServlet("/tcsm")
public class TcsmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TcsmServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		 if(event.equals("addTCSM")) {
			 int teacher_id=Integer.parseInt(request.getParameter("teacherName"));
			 int class_id=Integer.parseInt(request.getParameter("className"));
			 int sub_id=Integer.parseInt(request.getParameter("subjectName"));
			 String class_time=request.getParameter("classTime");		
			 CSM csm=new CSM();
			 csm.setClass_id(class_id);
			 csm.setSub_id(sub_id);
			 csm.setTeacher_id(teacher_id);
			 csm.setClass_time(class_time);
			 TcsmDao tcsmDao=new TcsmDao();
			 tcsmDao.addTcsm(csm);
			 response.sendRedirect("admin/TeachClsSubMap.jsp");
		 }else if(event.equals("viewTcsm")) {
			TcsmDao tcsmDao=new TcsmDao();
			List<CSM> csm = tcsmDao.viewTcsms();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(csm);
		 // System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("delete_tcsm") ){
			int tcsm_id=Integer.parseInt(request.getParameter("tcsm_id"));
			String status=TcsmDao.deleteTcsm(tcsm_id)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(status);
		 // System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("fatchTcsmById")) {
			int tcsm_id=Integer.parseInt(request.getParameter("tcsm_id"));
			TcsmDao tcsmDao=new TcsmDao();
			List<CSM> csm = tcsmDao.getTcsmById(tcsm_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(csm);
		  //System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("updateTCSM")) {
			
			int tcsm_id=Integer.parseInt(request.getParameter("tcsmId"));
			int class_id=Integer.parseInt(request.getParameter("className"));
			int sub_id=Integer.parseInt(request.getParameter("subjectName"));
			int teacher_id=Integer.parseInt(request.getParameter("teacherName"));
			String class_time=request.getParameter("classTime");
			
			CSM csm=new CSM();
			csm.setClass_id(class_id);
			csm.setTcsm_id(tcsm_id);
			csm.setSub_id(sub_id);
			csm.setTeacher_id(teacher_id);
			csm.setClass_time(class_time);
			TcsmDao tcsmDao=new TcsmDao();
			tcsmDao.updateTcsm(csm);
		 	response.sendRedirect("admin/TeachClsSubMap.jsp");
			
		}
	}

}
