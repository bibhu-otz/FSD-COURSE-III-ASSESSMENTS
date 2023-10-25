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
import dao.CSMDao;


@WebServlet("/csm")
public class CSMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CSMServlet() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		 if(event.equals("addCSM")) {
			 int class_id=Integer.parseInt(request.getParameter("className"));
			 int sub_id=Integer.parseInt(request.getParameter("subjectName"));
			 CSMDao csmdao=new CSMDao();
			 csmdao.addCsm(class_id,sub_id);
			 response.sendRedirect("admin/ClsSubMap.jsp");
		 }else if(event.equals("viewCsm")) {
			CSMDao csmdao=new CSMDao();
			List<CSM> csm = csmdao.viewCSMs();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(csm);
		  //System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("delete_csm") ){
			int csm_id=Integer.parseInt(request.getParameter("csm_id"));
			String status=CSMDao.deleteCsm(csm_id)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(status);
		  //System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("fatchCSMById")) {
			int csm_id=Integer.parseInt(request.getParameter("csm_id"));
			CSMDao csmdao=new CSMDao();
			List<CSM> csm = csmdao.getCsmById(csm_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(csm);
		  //System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("updateCSM")) {
			int csm_id=Integer.parseInt(request.getParameter("csmId"));
			int class_id=Integer.parseInt(request.getParameter("className"));
			int sub_id=Integer.parseInt(request.getParameter("subjectName"));
			CSM csm=new CSM();
			csm.setClass_id(class_id);
			csm.setCsm_id(csm_id);
			csm.setSub_id(sub_id);
			CSMDao csmdao=new CSMDao();
			csmdao.updateCsm(csm);
		 	response.sendRedirect("admin/ClsSubMap.jsp");
		}
	}
}
