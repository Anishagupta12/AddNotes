package com.Servlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.db.DBConnect;
import com.user.UserDetails;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails us=new UserDetails();//all the details are stored here in UserDetails
		us.setEmail(email);
		us.setPassword(password);

		UserDAO dao=new UserDAO(DBConnect.getConn());//db connection
		UserDetails user=dao.loginUser(us);
		
		if(user!=null)
		{ 
			HttpSession session=request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("login-failed","Invalid User Name and Password");
			response.sendRedirect("login.jsp");
		}
	
	}

}
