package in.shubha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		// Getting the old session object for the same user
		
		HttpSession session=request.getSession(false);
		
		if(session==null) {
			out.println("<h1>No Session information available w.r.t to the user</h1>");
		}else {
			
			// Retrieve the information from session object and process the 
			out.println("<table border='2'><tr><th>AttribueName</th><th>AttributeValue</th></tr>");
			Enumeration<String>names=session.getAttributeNames();
			
			// Processing the information using while loop from enumeration object
			
			while(names.hasMoreElements()) {
				String name=(String) names.nextElement();
			    Object value=session.getAttribute(name);
			    out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
			    
			}
			out.println("</table>");
			long creationTime=session.getCreationTime();
			long LastAccessedTime=session.getLastAccessedTime();
			int MaxInactiveInterval=session.getMaxInactiveInterval();
			
			out.println("<h1>CreationTime         is ::"+new Date(creationTime)+"</h1>");
			out.println("<h1>LastAccessTime       is::"+new Date(LastAccessedTime)+"</h1>");
			out.println("<h1>MaxInactiveIntervalTime       is::"+new Date(MaxInactiveInterval)+"</h1>");


		}
		
		
		out.close();
	}

}
