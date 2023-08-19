package in.shubha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test1")
public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// Getting the session object to track the request information of client
		
		HttpSession session=request.getSession();
		
		if(session.isNew()) {
			out.println("<h2>New Session Created with the id::"+session.getId()+"</h2>");
		}else {
			out.println("<h2>Existing session only with the session is::"+session.getId()+"</h2>");
		}
		
		//Retrieving the user-information from request object

		String name=request.getParameter("name");
		String value=request.getParameter("value");
		
		
		//Keeping the user-information in session object

		
		session.setAttribute(name, value);
		session.setMaxInactiveInterval(60);
		//Sending the response to the end-user

		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);
	
		
		out.close();
	}

}
