package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/first"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		//session creation on server side
		//web container creates session object per client.
		HttpSession session = request.getSession(); //this method always returns session
		session.setAttribute("firstSession", name);
		
	
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>first servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='second'>");
				
			out.println("<h1>First servlet, Welcome "+name+" </h1>");
			
			
			out.println("<input type='submit' value='submit'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
