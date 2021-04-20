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

@WebServlet(urlPatterns = {"/second"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name= (String) session.getAttribute("SessionName");
		
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>second servlet</title>");
			out.println("</head>");
			out.println("<body>");
			
			String url = response.encodeURL("third");
			out.println("<form action='"+url+"'>");
			
			out.println("<h1>second servlet, Welcome "+name+" </h1>");
			
			out.println("<input type='submit' value='submit'>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
