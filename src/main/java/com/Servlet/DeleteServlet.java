package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.PostDAO;
import com.db.DBConnect;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer noteid=Integer.parseInt(request.getParameter("note_id"));
		
		PostDAO dao=new PostDAO(DBConnect.getConn());
		HttpSession session=null;
		
		boolean f=dao.DeleteNotes(noteid);
		if(f)
		{
			session=request.getSession();
			session.setAttribute("upadteMsg","Notes Deleted Sucessuflly");
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("wrongMsg","Something went Wrong on Server");
			response.sendRedirect("showNotes.jsp");

	    }

	   }

}