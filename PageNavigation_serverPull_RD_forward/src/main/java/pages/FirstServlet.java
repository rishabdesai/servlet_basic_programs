package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/first" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("IndexPageUserName");
		HttpSession session = request.getSession();
		session.setAttribute("SessionNameKey", name);

		ServletContext application = this.getServletContext();
		application.setAttribute("applicationNameKey", name);

		// Page navigation using - forward scenario - option-1
		String path = response.encodeURL("/second"); //note: '/' is mandatory
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(path);
		rd.forward(request, response);
	
		// Page navigation using - forward scenario - option -2
		/*
		  String path = response.encodeURL("second"); //note: '/' is optional
		  RequestDispatcher rd = request.getRequestDispatcher(path); 
		  rd.forward(request, response);
		 */
	
		
		
		
		
	
	}
	
	
	
}
