package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/third"})
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name= (String) session.getAttribute("SessionName");
		
		ServletContext application = this.getServletContext();
		String userName = (String) application.getAttribute("applicationNameKey");
		
		
		
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>third servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>third servlet, Welcome "+name+" </h1>");
			out.println("<h1>third servlet using ServletContext, Welcome "+userName+" </h1>");
			
			
			
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
