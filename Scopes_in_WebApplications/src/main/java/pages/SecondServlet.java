package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/second"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = "";
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>second servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>second servlet, Welcome </h1>");
			out.println("<form action='third' >");
			
			//read REQUEST scope value
			name = (String) request.getAttribute("RequestScopeName");
			out.println("<h3>Request scope value :  "+name+"</h3><br/>");
			
			//read SESSION scope value
			HttpSession session = request.getSession();
			name = (String) session.getAttribute("SessionScope");
			out.println("<h3>session scope value :  "+name+"</h3><br/>");
			
			//read APPLICATION scope value
			ServletContext application = this.getServletContext();
			name = (String) application.getAttribute("ApplicationScope");
			out.println("<h3>Applicaiton scope value :  "+name+"</h3><br/>");
			
			
			
			out.println("<input type='submit' value='submit'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

}
