<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.DAO.PostDAO" %>
<%@page import="com.db.DBConnect"%>
<%@page import="java.util.*" %>
<%@page import="java.util.List" %>
<%@page import="com.user.Post" %>
<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");

if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please Login...");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<%
	String updateMsg=(String)session.getAttribute("updateMsg");
	if(updateMsg!=null)
	{%>
	<div class="alert alert-success" role="alert"><%= updateMsg %></div>	
	<%
	 session.removeAttribute("updateMsg");
	}
	%>
	
	<%
	String wrongMsg=(String)session.getAttribute("updating");
	if(wrongMsg!=null)
	{%>
	<div class="alert alert-danger" role="alert"><%= wrongMsg %></div>	
	<%
	 session.removeAttribute("DeleteMsg");
	}
	%>
	

	<div class="container">
		<h2 class="text-center">All Notes:</h2>

		<div class="row">
			<div class="col-md-12">
				<%	
					if (user3 != null)
					{
					PostDAO ob = new PostDAO(DBConnect.getConn());
					List<Post> post = ob.getData(user3.getId());
					for (Post po : post) 
					{						
				%>
			
				
			
			<div class="card mt-3">
					<img alt="" src="img/s9.jpg" class="card-img-top mt-2 m-auto "
						style="max-width: 120px;">
						

					<div class="card-body p-4">
						<h5 class="card-title "><%=po.getTitle() %></h5>

						<p><%=po.getContent()%>.</p>

						<p>
     						<p class="text-success">Published By:<%= user3.getName()%>
							<p class="text-primary">
							<p class="text-success">Published Date:<%= po.getPdate()%>
							<p class="text-success">
						</p>

					
						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%=po.getId() %>"  class="btn btn-danger">Delete</a> 
							<a href="edit.jsp?note_id=<%=po.getId() %>" class="btn btn-primary">Edit</a>
						

						</div>
					</div>
				</div>	
				<%
				}
				}
				%>	
			</div>
		</div>
	</div>
		<%@include file="all_component/footer.jsp"%>

</body>

</html>