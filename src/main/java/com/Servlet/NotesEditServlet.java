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

@WebServlet("/NotesEditServlet")
public class NotesEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		int noteid=Integer.parseInt(request.getParameter("noteid"));
		String Title=request.getParameter("title");
		String Content=request.getParameter("content");
		
		PostDAO dao=new PostDAO(DBConnect.getConn());
		boolean f=dao.PostUpdate(noteid,Title, Content);
		
		if(f)
		{
			System.out.println("data inserted succesfully");
			HttpSession session=request.getSession();
			session.setAttribute("updateMsg","Notes Updated Sucessuflly");
			response.sendRedirect("showNotes.jsp");

		}
		else
			System.out.println("data not inserted");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
