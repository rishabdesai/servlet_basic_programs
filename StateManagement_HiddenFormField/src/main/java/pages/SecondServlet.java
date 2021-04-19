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

@WebServlet(urlPatterns = {"/second"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("firstCookie");
		
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>second servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='third'>");
			
			out.println("<h1>second servlet, Welcome "+name+" </h1>");
			
			out.println("<input type='hidden' name='firstCookie' value='"+name+"'/>");
			out.println("<input type='submit' value='submit'>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
